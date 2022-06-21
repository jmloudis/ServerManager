package io.JordanDev.server.service;

import io.JordanDev.server.model.User;
import io.JordanDev.server.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepo userRepo;

    @Override
    public void create(User user) {
        this.userRepo.save(user);
    }
}
