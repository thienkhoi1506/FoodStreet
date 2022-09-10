package com.streetfood.repository.interfaces;

import com.streetfood.pojo.Product;
import com.streetfood.pojo.User;

import java.util.List;

public interface UserRepository {
    boolean addUser(User user);
    User getUsers(String username);

    List<User> getAllUsers();
    User getUserById (long id);

}
