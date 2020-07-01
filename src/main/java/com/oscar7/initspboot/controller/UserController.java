package com.oscar7.initspboot.controller;

import com.oscar7.initspboot.services.UserService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.java.Log;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.context.request.WebRequest;

@Log
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Controller
@RequiredArgsConstructor
public class UserController {
    UserService userService;

    @GetMapping("/registration")
    public String showRegistartionForm(final WebRequest request, final Model model) {
        model.addAttribute("user", userService);
        return "registration";
    }
}
