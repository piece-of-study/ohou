package org.ohou.controller;

import org.ohou.dto.UserDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class IndexController {
    @GetMapping(value="/")
    public String index(Model model){
        model.addAttribute("test", "1234");
        return "index";
    }

    @GetMapping(value="/json", produces = "application/json")
    @ResponseBody
    public Object json(){
        Map<String, String> m = new HashMap<>();
        m.put("test", "1234");
        return m;
    }
    @GetMapping("/user/login")
    public String login(Model model){
        return "/login";
    }

    @GetMapping("/join")
    public String join(Model model){
        model.addAttribute("userDto", new UserDto());
        return "/join";
    }
}