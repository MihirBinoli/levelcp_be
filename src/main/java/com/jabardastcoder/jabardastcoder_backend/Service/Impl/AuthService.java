package com.jabardastcoder.jabardastcoder_backend.Service.Impl;

import com.jabardastcoder.jabardastcoder_backend.Config.JwtUtil;
import com.jabardastcoder.jabardastcoder_backend.DTO.Request.LoginRequest;
import com.jabardastcoder.jabardastcoder_backend.DTO.Response.LoginResponse;
import com.jabardastcoder.jabardastcoder_backend.Entity.UserEntity;
import com.jabardastcoder.jabardastcoder_backend.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder =
            new BCryptPasswordEncoder();


    @Autowired
    JwtUtil jwtUtil;

    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public LoginResponse register(LoginRequest request) {

        if (userRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Email already in use");
        }

        if (userRepository.existsByUsername(request.getUserName())) {
            throw new RuntimeException("Username already in use");
        }

        UserEntity user = new UserEntity();
        user.setUsername(request.getUserName());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setActive(true);

        UserEntity saved = userRepository.save(user);

        return new LoginResponse();
    }

    public LoginResponse login(LoginRequest request) {

        UserEntity user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }

        String token = jwtUtil.generateToken(user);

        return new LoginResponse(token);
    }

}
