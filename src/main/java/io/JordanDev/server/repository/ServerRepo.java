package io.JordanDev.server.repository;

import io.JordanDev.server.model.Server;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

//managing server class (domain) and type primary key (Long)
//manage information in database
@Repository
public interface ServerRepo extends JpaRepository<Server, Long> {

    // JPA findBy....
    Server findByIpAddress(String ipAddress);





}
