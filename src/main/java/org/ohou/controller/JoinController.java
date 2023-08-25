package org.ohou.controller;

import org.ohou.dto.UserDto;
import org.ohou.model.Authority;
import org.ohou.model.User;
import org.ohou.repository.UserRepository;
import org.ohou.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class JoinController {

    private final UserService userService;
    private final UserRepository userRepository;

    public JoinController(UserService userService, UserRepository userRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
    }

    @GetMapping("/join")
    public String join(Model model){
        model.addAttribute("userDto", new UserDto());
        return "/join";
    }

    @PostMapping("/join-success")
    public String joinSuccessForm(@ModelAttribute("userDto") UserDto userDto){
        User user = new User();
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());


        for(Authority authority : userDto.getAuthorities()){
            authority.setUser(user);
        }
        userRepository.save(user);
        return "/join-success";
    }

}
