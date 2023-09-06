package org.ohou.controller;

import org.ohou.dto.UserDto;
import org.ohou.model.User;
import org.ohou.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserApiController {

    private final UserService userService;

    public UserApiController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/join-success")
    public String joinSuccess(@ModelAttribute("userDto") UserDto userDto){
        User user = userService.registerUser(userDto);
        userService.autoLogin(user);
        return "/index";
    }

}
