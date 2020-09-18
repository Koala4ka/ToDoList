package com.planmanage.notes.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.UUID;

@Controller
public class MainController {

    @RequestMapping(value = { "/", "/index" }, method = RequestMethod.GET)
    public String index(Model model)
    {
        UUID uuid = UUID.randomUUID();
        model.addAttribute("listId", uuid.toString());
        return "index";
    }
}

