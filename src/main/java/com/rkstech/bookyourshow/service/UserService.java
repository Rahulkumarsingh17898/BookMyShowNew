package com.rkstech.bookyourshow.service;

import com.rkstech.bookyourshow.models.User;
import com.rkstech.bookyourshow.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class UserService {

    UserRepository userRepository; // concreate class of the interface is created by data jpa which is injected by spring

    public User createUser(User user) {
        System.out.println("Got user: " + user.getEmail());
        return userRepository.save(user);
    }

    public User getUser(Long userId) {
       return userRepository.findById(userId).orElse(null);

    }
}
