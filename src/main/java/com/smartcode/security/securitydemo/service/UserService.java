package com.smartcode.security.securitydemo.service;

import com.smartcode.security.securitydemo.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Created by panjingp on 2/17/2017.
 */
public interface UserService {
    void save(User user);

    User findOne(Long id);

    Page<User> findAll(Pageable pageable);


    void delete(User user);
}
