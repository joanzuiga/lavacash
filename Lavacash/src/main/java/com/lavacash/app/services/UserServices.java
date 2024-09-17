package com.lavacash.app.services;

import com.lavacash.app.domain.Role;
import com.lavacash.app.domain.User;
import com.lavacash.app.interfaces.UserRepository;
import com.lavacash.app.interfaceservices.UserRepositoryServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServices implements UserRepositoryServices {

    @Autowired
    private UserRepository repo;

    @Override
    public List<User> getAll() {
        return (List<User>) repo.findAll();
    }

    @Override
    public Optional<User> get(int id) {
        return repo.findById(id);
    }

    @Override
    public void add(User u) {
        u.setRol(Role.CLIENT.toString());
       repo.save(u);
    }

    @Override
    public User getUserVerify(String correo, String contrasena) {
        return repo.getUserVerify(correo, contrasena);
        
    }
}
