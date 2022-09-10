package com.streetfood.service.implementations;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.streetfood.pojo.User;
import com.streetfood.repository.interfaces.UserRepository;
import com.streetfood.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.*;

@Service("userDetailsService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private Cloudinary cloudinary;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Override
    public boolean addUser(User user) {
//        try {
            user.setPassword(this.bCryptPasswordEncoder.encode(user.getPassword()));
            user.setRole(User.User);
            Date d = new Date();
//            Map r = this.cloudinary.uploader().upload(user.getAvtarImg().getBytes(),
//                    ObjectUtils.asMap("resource_type", "auto"));
//            user.setAvatarUrl((String) r.get("secure_url"));
            return this
                    .userRepository
                    .addUser(user);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return false;
    }

    @Override
    public User getUserByUsername(String username) {
        return this.userRepository.getUsers(username);
    }

    @Override
    public List<User> getAllUsers() {
        return this.userRepository.getAllUsers();
    }

    @Override
    public User getUserById(long id) {
        return this.userRepository.getUserById(id);
    }


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = this.getUserByUsername(s);

        if (user == null) {
            throw new UsernameNotFoundException("Invalid");
        }
        Set<GrantedAuthority> authorities = new HashSet<>();
        authorities.add(new SimpleGrantedAuthority(user.getRole()));

        return new org.springframework.security.core.userdetails.User(
                user.getUsername(), user.getPassword(), authorities
        );
    }
}
