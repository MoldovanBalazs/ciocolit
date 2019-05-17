package com.wcff.ciocolit.service;

import com.wcff.ciocolit.domain.UserBuilder;
import com.wcff.ciocolit.domain.User;
import com.wcff.ciocolit.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class UserService {

    @Autowired
    private UserRepository userRepository;

//    @GetMapping("/user/{id}")
//    public User getUserById(@PathVariable Long id) {
//        User user = UserBuilder.createUserBuilder().name("Ioana").username("ioana$efa").password("password").build();
//        userRepository.save(user);
//        return userRepository.findById(id).get();
//    }
}
