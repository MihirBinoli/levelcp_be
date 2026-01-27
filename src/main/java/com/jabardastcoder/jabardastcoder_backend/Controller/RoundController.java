package com.jabardastcoder.jabardastcoder_backend.Controller;


import com.jabardastcoder.jabardastcoder_backend.DTO.UserRoundDTO;
import com.jabardastcoder.jabardastcoder_backend.Service.RoundLogic;
import com.jabardastcoder.jabardastcoder_backend.Service.UserLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/round")
public class RoundController {


    @Autowired
    RoundLogic roundLogic;

    @PostMapping("createRound")
    public UserRoundDTO createRound(@RequestBody UserRoundDTO userRoundDTO){
        return roundLogic.createRound(userRoundDTO);
    }
}
