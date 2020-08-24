package com.smartcode.security.securitydemo.service;

/**
 * Created by panjingp on 2/15/2017.
 */
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;

public class UserInfo extends BaseUserDetails {
    private static final long serialVersionUID = 1L;
    private String email;
    private String dept;

    public UserInfo(String username, String password, boolean enabled,
                    Set<GrantedAuthority> authorities) throws IllegalArgumentException {
        super(username, password, enabled, authorities);
    }
    public UserInfo(String username, String password,
                    boolean enabled, boolean accountNonExpired,
                    boolean credentialsNonExpired, Set<GrantedAuthority> authorities) throws IllegalArgumentException {
        super(username, password, enabled, authorities);
    }

    public UserInfo(String username, String password,
                    boolean enabled, boolean accountNonExpired,
                    boolean credentialsNonExpired,boolean accountNonLocked ,Set<GrantedAuthority> authorities) throws IllegalArgumentException {
        super(username, password, enabled, authorities);
    }
    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }



    public String getDept() {
        return dept;
    }
    public void setDept(String dept) {
        this.dept = dept;
    }
    public boolean equals(Object rhs) {
        if (!(rhs instanceof UserInfo) || (rhs == null)) {
            return false;
        }

        if (super.equals(rhs)) {
            UserInfo userInfo = (UserInfo) rhs;

            return ((this.email == null) && (userInfo.getEmail() == null))
                    || ((this.email != null)
                    && this.email.equals(userInfo.getEmail()));
        }

        return false;
    }

    public int hashCode() {
        int code = super.hashCode();

        if (this.email != null) {
            code *= -11;
        }

        return code;
    }



}