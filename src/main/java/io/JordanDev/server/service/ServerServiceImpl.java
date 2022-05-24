package io.JordanDev.server.service;

import io.JordanDev.server.enumeration.Status;
import io.JordanDev.server.model.Server;
import io.JordanDev.server.repository.ServerRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.transaction.Transactional;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Collection;
import java.util.List;
import java.util.Random;

import static java.lang.Boolean.TRUE;
import static org.springframework.data.domain.PageRequest.of;

// lombok creates instructor and creates dependency injection
//@RequiredArgsConstructor
@Service
@Transactional
// something printed in the console - log
@Slf4j
public class ServerServiceImpl implements ServerService{

    private final ServerRepo serverRepo;

    @Autowired
    public ServerServiceImpl(ServerRepo serverRepo) {
        this.serverRepo = serverRepo;
    }

    @Override
    public Server create(Server server) {
        log.info("Saving new server: {}", server.getName());
        server.setImageUrl(setServerImageUrl());
        return serverRepo.save(server);
    }



    @Override
    public Server ping(String ipAddress) throws IOException {
        log.info("Pinging server IP: {}", ipAddress);
        Server server = serverRepo.findByIpAddress(ipAddress);
        InetAddress address = InetAddress.getByName(ipAddress);
        // if server is ping within 10000ms, set status to SERVER_UP otherwise SERVER_DOWN
        server.setStatus(address.isReachable(7500) ? Status.SERVER_UP : Status.SERVER_DOWN);
        serverRepo.save(server);
        return server;
    }

    @Override
    public Collection<Server> list(int limit) {
        log.info("Fetching all servers");

        // static import
        return serverRepo.findAll(of(0, limit)).toList();
    }


    @Override
    public Server get(Long id) {
        log.info("Fetching server by Id: {}", id);

        return serverRepo.findById(id).get();
    }

    @Override
    public Server getAllActiveAddresses(String subnet) throws IOException {



        return null;

    }

    @Override
    public Server update(Server server) {
        log.info("Updating server: {}", server.getName());
        return serverRepo.save(server);
    }

    @Override
    public Boolean delete(Long id) {
        log.info("Deleting server: {}", id);
        serverRepo.deleteById(id);
        return TRUE;
    }

    private String setServerImageUrl() {
        String[] imageNames = {"server.png", "server-2.png", "server-3.png"};
        // bound 3 since there are three images and will not go above 3 images
        return ServletUriComponentsBuilder.fromCurrentContextPath().path("/server/image/" + imageNames[new Random().nextInt(3)]).toUriString();
    }

    @Override
    public List<Server> getAllServers() {
        return serverRepo.findAll();
    }
}
