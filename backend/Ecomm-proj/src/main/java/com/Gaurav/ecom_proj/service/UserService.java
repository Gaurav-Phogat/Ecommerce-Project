package com.Gaurav.ecom_proj.service;

import com.Gaurav.ecom_proj.model.User;
import com.Gaurav.ecom_proj.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepo repo;

    public User addUser(User user) {
            System.out.println(user.getRole());
            return repo.save(user);
    }



    public User getUserByName(String userName) {
        return repo.findByUsername(userName).orElseThrow(() -> new RuntimeException("User Not Found"));
    }
}
