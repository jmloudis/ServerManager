package io.JordanDev.server.service;

import io.JordanDev.server.model.Server;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.Collection;
import java.util.List;

// functionality / features to implement later in the ServerServiceImpl
// interface
public interface ServerService {

    Server create(Server server);


    //can change server status once pinged
    Server ping(String ipAddress) throws IOException;
    Collection<Server> list(int limit);
    Server get(Long id);
    Server update(Server server);

    Server getAllActiveAddresses(String subnet) throws IOException;
    Boolean delete(Long id);

    List<Server> getAllServers();


}
