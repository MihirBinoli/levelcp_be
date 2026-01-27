package com.jabardastcoder.jabardastcoder_backend.Controller;


import com.jabardastcoder.jabardastcoder_backend.DTO.Response.JabardastResponse;
import com.jabardastcoder.jabardastcoder_backend.DTO.UserRoundDTO;
import com.jabardastcoder.jabardastcoder_backend.Service.UserLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class JabardastController {


    @Autowired
    UserLogic userLogic;


    @GetMapping("getAllUsers")
    public List<JabardastResponse> getAllUsers()
    {
        return userLogic.getAllUsers();
    }

    // implement start round api

}
