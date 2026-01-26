package com.jabardastcoder.jabardastcoder_backend.Controller;


import com.jabardastcoder.jabardastcoder_backend.DTO.Response.JabardastResponse;
import com.jabardastcoder.jabardastcoder_backend.Service.UserServiceLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class JabardastController {


    @Autowired
    UserServiceLogic userServiceLogic;


    @GetMapping("getAllUsers")
    public List<JabardastResponse> getAllUsers()
    {
        return userServiceLogic.getAllUsers();
    }

}
