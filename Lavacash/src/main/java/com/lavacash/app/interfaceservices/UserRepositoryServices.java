package com.lavacash.app.interfaceservices;

import com.lavacash.app.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserRepositoryServices {

    public List<User> getAll();
    public Optional<User> get(int id);
    public void add(User u);
    public User getUserVerify(String correo, String contrasena);

}
