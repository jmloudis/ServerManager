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

//    @GetMapping("/scan")
//    public String ScanLan() throws IOException {
//        int timeout=1000;
//        for (int i=1;i<50;i++){
//            String host = "192.168.1." + i;
//            if (InetAddress.getByName(host).isReachable(timeout)){
//                System.out.println(host);
//            }
//        }
//
//        return "index";
//    }

    @RequestMapping(value = "/test", method = { RequestMethod.GET, RequestMethod.POST })
    public String ScanTest(@ModelAttribute("Server") Server server) throws IOException {
        int timeout=1000;
        for (int i=1;i<22;i++){
            String host = "192.168.1." + i;
            if (InetAddress.getByName(host).isReachable(timeout)){
                System.out.println(host);
                server.setIpAddress(host);
                serverService.create(server);
                serverService.getAllServers();

            }

        }

        return "redirect:/index";
    }



}
