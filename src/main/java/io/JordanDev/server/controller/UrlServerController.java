package io.JordanDev.server.controller;

import io.JordanDev.server.service.ServerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UrlServerController {
    private ServerServiceImpl serverService;

    @Autowired
    public UrlServerController(ServerServiceImpl serverService) {
        this.serverService = serverService;
    }


    @GetMapping("/fullList")
    public String getFullList(Model model){
        model.addAttribute("allServers", serverService.list(30));
        return "index";
    }
}
