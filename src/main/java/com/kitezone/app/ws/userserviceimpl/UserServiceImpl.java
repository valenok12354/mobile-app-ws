package com.kitezone.app.ws.userserviceimpl;

import com.kitezone.app.ws.userservice.UserService;
import com.kitezone.app.ws.ui.model.request.UserDetailsRequest;
import com.kitezone.app.ws.ui.model.responce.UserRest;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    Map<String, UserRest> users;

    @Override
    public UserRest createUser(UserDetailsRequest userDetail) {
        UserRest returnValue = new UserRest();
        returnValue.setLastName(userDetail.getLastName());
        returnValue.setName(userDetail.getFirstName());
        returnValue.setMail(userDetail.getEmail());
        String userId = UUID.randomUUID()
                            .toString();
        returnValue.setUserId(userId);
        if (users == null) {
            users = new HashMap<>();
        } ;
        users.put(userId, returnValue);
        return returnValue;
    }
}
