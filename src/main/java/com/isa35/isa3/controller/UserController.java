package com.isa35.isa3.controller;

import com.isa35.isa3.model.User;
import com.isa35.isa3.security.TokenUtils;
import com.isa35.isa3.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    TokenUtils tokenUtils;

    @Autowired
    UserService userService;

    @GetMapping("/")
    public ResponseEntity<User> getUser(HttpServletRequest request) {
        User user = userService.findByUsername(tokenUtils.getUsernameFromToken(tokenUtils.getToken(request)));

        return new ResponseEntity(HttpStatus.OK);
    }

}
