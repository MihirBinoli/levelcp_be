package com.jabardastcoder.jabardastcoder_backend.Controller;


import com.jabardastcoder.jabardastcoder_backend.DTO.Request.LoginRequest;
import com.jabardastcoder.jabardastcoder_backend.DTO.Response.LoginResponse;
import com.jabardastcoder.jabardastcoder_backend.Service.Impl.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }


    // REGISTER
    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public LoginResponse register(@RequestBody LoginRequest request) {
        return authService.register(request);
    }

    // LOGIN
    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest request) {
        return authService.login(request);
    }

    @PutMapping("/addCfHandle")
    public LoginResponse addCfHandle(@RequestBody LoginRequest request){
        return authService.addCfHandle(request);
    }
}
