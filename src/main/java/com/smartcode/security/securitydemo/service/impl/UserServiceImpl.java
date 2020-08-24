package com.smartcode.security.securitydemo.service.impl;
import java.util.Date;
import com.smartcode.security.securitydemo.repository.UserRepository;
import com.smartcode.security.securitydemo.service.UserService;
import com.smartcode.security.securitydemo.service.UserService;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.smartcode.security.securitydemo.domain.User;
import com.smartcode.security.securitydemo.exception.ResourceNotFoundException;

/**
 * Created by panjingp on 2/17/2017.
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired

    protected UserRepository userRepository;

    @Override
    public void save(User user) {


        Date now = new DateTime().toDate();
        if (user.getCreateDate() == null) {
            user.setUpdatedAt(now);
        }

        user.setUpdatedAt(now);
        userRepository.save(user);
    }

    @Override
    @Transactional(readOnly = true)
    public User findOne(Long id) {
        User user = userRepository.findById(id).get();
        if (user == null) {
            throw new ResourceNotFoundException("User [id=" + id
                    + "] is not found.");
        }
        return user;
    }

    @Override
    @Transactional(readOnly = true)
    public Page<User> findAll(Pageable pageable) {
        Page<User> page = userRepository.findAll(pageable);
        return page;
    }


    @Override
    public void delete(User user) {
        userRepository.delete(user);
    }
}