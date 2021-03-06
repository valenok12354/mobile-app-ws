package com.kitezone.app.ws.ui.controller;

import com.kitezone.app.ws.ui.model.request.UpdateUserDetails;
import com.kitezone.app.ws.ui.model.request.UserDetailsRequest;
import com.kitezone.app.ws.ui.model.responce.UserRest;
import com.kitezone.app.ws.userservice.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Map;


@RestController
@RequestMapping("/users") //http://localhost:8080/users
public class UserController {

    Map<String, UserRest> users;

    @Autowired
    UserService userService;

    @GetMapping
    public String getUser(@RequestParam(value = "page", defaultValue = "1") int page,
                          @RequestParam(value = "limit", defaultValue = "50") int limit,
                          @RequestParam(value = "sort", required = false, defaultValue = "desc") String sort)

//        throw new UserServiceException("my exeption trown");
    {
        return "ger user page " + page + "limit " + limit + "sort " + sort;
    }


    @GetMapping(path = "/{userId}", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<UserRest> getUser(@PathVariable String userId) {
        return userService.getUser(userId);
    }

    @PostMapping(produces = {MediaType.APPLICATION_XML_VALUE,
            MediaType.APPLICATION_JSON_VALUE},
            consumes = {MediaType.APPLICATION_XML_VALUE,
                    MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<UserRest> createUser(@Valid @RequestBody UserDetailsRequest userDetail) {

        UserRest returnValue = userService.createUser(userDetail);
        return new ResponseEntity<>(returnValue, HttpStatus.OK);
    }

    @PutMapping(path = "/{userId}", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public UserRest updateUser(@PathVariable String userId, @RequestBody UpdateUserDetails userDetail) {
        return userService.updateUser(userId, userDetail);
    }

    @DeleteMapping(path = "/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable String userId) {
        userService.deleteUser(userId);
        return ResponseEntity.noContent()
                             .build();
    }
}
