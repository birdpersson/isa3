package com.isa35.isa3.controller;

import com.isa35.isa3.security.TokenUtils;
import com.isa35.isa3.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    TokenUtils tokenUtils;

    @Autowired
    UserService userService;

}
