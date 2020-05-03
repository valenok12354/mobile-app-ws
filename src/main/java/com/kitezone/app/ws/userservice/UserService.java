package com.kitezone.app.ws.userservice;

import com.kitezone.app.ws.ui.model.request.UserDetailsRequest;
import com.kitezone.app.ws.ui.model.responce.UserRest;

public interface UserService {

    UserRest createUser(UserDetailsRequest userDetail);

}
