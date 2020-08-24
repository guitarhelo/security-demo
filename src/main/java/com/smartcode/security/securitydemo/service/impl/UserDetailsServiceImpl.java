package com.smartcode.security.securitydemo.service.impl;

/**
 * Created by panjingp on 2/15/2017.
 */
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.security.core.SpringSecurityMessageSource;
import org.springframework.context.support.MessageSourceAccessor;
import com.smartcode.security.securitydemo.domain.User;
import com.smartcode.security.securitydemo.domain.Role;
import com.smartcode.security.securitydemo.repository.UserRepository;
import com.smartcode.security.securitydemo.service.UserInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@Service
/**
 * 实现SpringSecurity的UserDetailsService接口,实现获取用户Detail信息的回调函数.
 *
 * @author John.Pan
 * @since 1.0
 */
@Transactional(readOnly = true)
public class UserDetailsServiceImpl implements UserDetailsService {

    private static Logger logger = LoggerFactory.getLogger(UserDetailsServiceImpl.class);

    protected MessageSourceAccessor messages = SpringSecurityMessageSource.getAccessor();
    @Autowired
    UserRepository userRepository;




    /**
     * 获取用户Details信息的回调函数.
     */

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException, DataAccessException {

        List<User> accountList = userRepository.findByLoginName(username);

        User user=accountList.get(0);

        if (null == user) {
            logger.debug("Query returned no results for user '" + username + "'");

            throw new UsernameNotFoundException(
                    messages.getMessage("User.notFound", new Object[] { username }, "Username {0} not found"));
        }

        Boolean enabled=user.getEnabled();


        Set<GrantedAuthority> grantedAuths = obtainGrantedAuthorities(user);
        //演示代码暂时设置为true
        boolean accountNonExpired = true;
        boolean credentialsNonExpired = true;
        boolean accountNonLocked = true;
        //2.X的spring security要求使用数组,3.0后成为过期方法
		/*
		UserDetails userdetails = new org.springframework.security.core.userdetails.User(user.getUsername(), user
				.getPassword(), enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, grantedAuths);
        */





        UserInfo userdetails = new UserInfo(user.getLoginName(), user
                .getPassword(), user.getEnabled(), accountNonExpired, credentialsNonExpired, accountNonLocked, grantedAuths);

        userdetails.setEmail(user.getEmail());
        //userdetails.setDept(user.getDepartment().getDepartmentName());
        userdetails.setDept("Department demo");

        logger.info("=======",userdetails);
        return userdetails;
    }

    /**
     * 获得用户所有角色的权限集合.
     */
    @SuppressWarnings("deprecation")
    private Set<GrantedAuthority> obtainGrantedAuthorities(User user) {
        Set<GrantedAuthority> authSet = new HashSet<GrantedAuthority>();
        for (Role ar : user.getRoles()) {


           // authSet.add(new GrantedAuthorityImpl(ar.getRoleName()));
            authSet.add(new SimpleGrantedAuthority(ar.getRoleName()));
        }
        return authSet;
    }
}
