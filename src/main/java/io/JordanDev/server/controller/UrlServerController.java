package io.JordanDev.server.controller;

import io.JordanDev.server.enumeration.Status;
import io.JordanDev.server.model.Server;
import io.JordanDev.server.service.ServerServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

@Controller
@Slf4j
public class UrlServerController {
    private ServerServiceImpl serverService;

    @Autowired
    public UrlServerController(ServerServiceImpl serverService) {
        this.serverService = serverService;
    }

    @GetMapping("/")
    public String getFullList(Model model){
        model.addAttribute("allServers", serverService.list(30));
        return "index";
    }

    @GetMapping("/serversUp")
    public String getServersUp(Model model){
        model.addAttribute("serversUp", serverService.getServerStatus(Status.SERVER_UP));
        return "serverUp";
    }

    @GetMapping("/serversDown")
    public String getServersDown(Model model){
        model.addAttribute("serversDown", serverService.getServerStatus(Status.SERVER_DOWN));

        return "user/serverDown";
    }

    @GetMapping("/newServer")
    public String showNewServer(Model model){
        Server server = new Server();
        model.addAttribute("newServer", server);
        return "index";
    }

    @PostMapping("/saveServer")
    public String saveServer(@Valid @ModelAttribute("Server") Server server, BindingResult result){
        if (result.hasErrors()) {
            return "index";
        }
        serverService.create(server);
        return "redirect:/";
    }

    @RequestMapping(value = "/test", method = { RequestMethod.GET, RequestMethod.POST })
    public String ScanTest(@ModelAttribute("Server") Server server) throws IOException {
        int timeout=1000;
        for (int i=1;i<22;i++){
            String host = "192.168.1." + i;
            if (InetAddress.getByName(host).isReachable(timeout)){
                System.out.println(host);
                server.setIpAddress(host);
                server.setStatus(Status.SERVER_UP);
                serverService.create(server);
                serverService.getAllServers();
            }

        }

        return "redirect:/";
    }

    @GetMapping("/ping/{ipAddress}")
    public String pingIpAddress(@PathVariable("ipAddress") String ipAddress) throws IOException {
        Server server = serverService.ping(ipAddress);
        server.getStatus();
        log.info(server.getIpAddress() + " " + server.getStatus());
        return "redirect:/";
    }

    @GetMapping("/deleteServer/{id}")
    public String deleteServer(@PathVariable("id") Long id){
        serverService.delete(id);
        return "redirect:/";

    }






}
