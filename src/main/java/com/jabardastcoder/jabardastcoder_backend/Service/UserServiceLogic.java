package com.jabardastcoder.jabardastcoder_backend.Service;


import com.jabardastcoder.jabardastcoder_backend.DTO.Response.JabardastResponse;

import java.util.List;

public interface UserServiceLogic {


    List<JabardastResponse> getAllUsers();
}
