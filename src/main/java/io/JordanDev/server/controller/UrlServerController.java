package io.JordanDev.server.controller;

import io.JordanDev.server.model.Server;
import io.JordanDev.server.service.ServerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

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

    @GetMapping("/newServer")
    public String showNewServer(Model model){
        Server server = new Server();
        model.addAttribute("newServer", server);
        return "index";
    }

    @PostMapping("/saveServer")
    public String saveServer(@ModelAttribute("Server") Server server){
        serverService.create(server);
        return "redirect:/fullList";
    }

    @RequestMapping(value = "/test", method = { RequestMethod.GET, RequestMethod.POST })
    public String ScanTest(@ModelAttribute("Server") Server server) throws IOException {
        int timeout=1000;
        for (int i=1;i<22;i++){
            String host = "192.168.1." + i;
            if (InetAddress.getByName(host).isReachable(timeout)){
                System.out.println(host);
                server.setIpAddress(host);
                serverService.saveServer(server);
                serverService.getAllServers();

            }

        }


        return "redirect:/";
    }



}
