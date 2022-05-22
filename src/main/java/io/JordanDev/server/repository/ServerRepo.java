package io.JordanDev.server.repository;

import io.JordanDev.server.model.Server;
import org.springframework.data.jpa.repository.JpaRepository;

//managing server class (domain) and type primary key (Long)
//manage information in database
public interface ServerRepo extends JpaRepository<Server, Long> {

    // JPA findBy....
    Server findByIpAddress(String ipAddress);




}
