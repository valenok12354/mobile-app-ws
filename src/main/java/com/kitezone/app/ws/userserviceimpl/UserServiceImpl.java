package com.kitezone.app.ws.userserviceimpl;

import com.kitezone.app.ws.ui.model.request.UpdateUserDetails;
import com.kitezone.app.ws.userservice.UserService;
import com.kitezone.app.ws.ui.model.request.UserDetailsRequest;
import com.kitezone.app.ws.ui.model.responce.UserRest;
import com.kitezone.app.ws.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Component
public class UserServiceImpl implements UserService {

    Map<String, UserRest> users;
    Utils utils;

    @Autowired
    public UserServiceImpl(Utils utils) {
        this.utils = utils;
    }

    @Override
    public UserRest createUser(UserDetailsRequest userDetail) {
        UserRest returnValue = new UserRest();
        returnValue.setLastName(userDetail.getLastName());
        returnValue.setName(userDetail.getFirstName());
        returnValue.setMail(userDetail.getEmail());
        String userId = utils.getUuid();
        returnValue.setUserId(userId);

        if (users == null) {
            users = new HashMap<>();
        }
        users.put(userId, returnValue);
        return returnValue;
    }

    @Override
    public ResponseEntity<UserRest> getUser(String userId) {
        if (users.containsKey(userId)) {
            return new ResponseEntity<>(users.get(userId), HttpStatus.NO_CONTENT);
        } else return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

    }

    @Override
    public UserRest updateUser(String userId, UpdateUserDetails userDetail) {
        UserRest updateUserDetail = users.get(userId);
        updateUserDetail.setName(userDetail.getFirstName());
        updateUserDetail.setLastName(userDetail.getLastName());
        users.put(userId, updateUserDetail);
        return updateUserDetail;
    }

    @Override
    public void deleteUser(String userId) {
        users.remove(userId);
    }
}