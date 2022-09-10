package com.streetfood.service.interfaces;

import com.streetfood.pojo.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    boolean addUser(User user);
    User getUserByUsername(String username);

    List<User> getAllUsers();
    User getUserById (long id);

}
