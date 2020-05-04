package com.kitezone.app.ws.userservice;

import com.kitezone.app.ws.ui.model.request.UpdateUserDetails;
import com.kitezone.app.ws.ui.model.request.UserDetailsRequest;
import com.kitezone.app.ws.ui.model.responce.UserRest;
import org.springframework.http.ResponseEntity;

public interface UserService {

    UserRest createUser(UserDetailsRequest userDetail);

    ResponseEntity<UserRest> getUser(String userId);

    UserRest updateUser (String userId, UpdateUserDetails userDetail);

    void deleteUser (String userId);
}
