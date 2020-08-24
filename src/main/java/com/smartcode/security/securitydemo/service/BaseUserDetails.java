package com.smartcode.security.securitydemo.service;

/**
 * Created by panjingp on 2/15/2017.
 */
import java.util.Collection;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;



public class BaseUserDetails implements UserDetails {
    private static final long serialVersionUID = 1L;
    protected String password;
    protected String username;
    protected Collection<GrantedAuthority> authorities;
    protected boolean accountNonExpired;
    protected boolean accountNonLocked;
    protected boolean credentialsNonExpired;
    protected boolean enabled;

    public BaseUserDetails(String username, String password,
                           boolean enabled, Collection<GrantedAuthority> authorities)
            throws IllegalArgumentException {
        this(username, password, enabled, true, true, authorities);
    }

    public BaseUserDetails(String username, String password,
                           boolean enabled, boolean accountNonExpired,
                           boolean credentialsNonExpired, Collection<GrantedAuthority> authorities)
            throws IllegalArgumentException {
        this(username, password, enabled, accountNonExpired,
                credentialsNonExpired, true, authorities);
    }

    public BaseUserDetails(String username, String password,
                           boolean enabled, boolean accountNonExpired,
                           boolean credentialsNonExpired, boolean accountNonLocked,
                           Collection<GrantedAuthority> authorities) throws IllegalArgumentException {
        if (((username == null) || "".equals(username))
                || (password == null)) {
            throw new IllegalArgumentException(
                    "Cannot pass null or empty values to constructor");
        }

        this.username = username;
        this.password = password;
        this.enabled = enabled;
        this.accountNonExpired = accountNonExpired;
        this.credentialsNonExpired = credentialsNonExpired;
        this.accountNonLocked = accountNonLocked;
        setAuthorities(authorities);
    }




    public Collection<GrantedAuthority> getAuthorities() {
        return authorities;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }


    public boolean isAccountNonExpired() {
        return accountNonExpired;
    }

    public boolean isAccountNonLocked() {
        return this.accountNonLocked;
    }

    public boolean isCredentialsNonExpired() {
        return credentialsNonExpired;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void expireAccount() {
        this.accountNonExpired = false;
    }

    public void lockAccount() {
        this.accountNonLocked = false;
    }

    public void expireCredential() {
        this.credentialsNonExpired = false;
    }

    public void disable() {
        this.enabled = false;
    }



    public void setAuthorities(Collection<GrantedAuthority> authorities) {
        this.authorities = authorities;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (accountNonExpired ? 1231 : 1237);
        result = prime * result + (accountNonLocked ? 1231 : 1237);
        result = prime * result
                + ((authorities == null) ? 0 : authorities.hashCode());
        result = prime * result + (credentialsNonExpired ? 1231 : 1237);
        result = prime * result + (enabled ? 1231 : 1237);
        result = prime * result
                + ((password == null) ? 0 : password.hashCode());
        result = prime * result
                + ((username == null) ? 0 : username.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        BaseUserDetails other = (BaseUserDetails) obj;
        if (accountNonExpired != other.accountNonExpired)
            return false;
        if (accountNonLocked != other.accountNonLocked)
            return false;
        if (authorities == null) {
            if (other.authorities != null)
                return false;
        } else if (!authorities.equals(other.authorities))
            return false;
        if (credentialsNonExpired != other.credentialsNonExpired)
            return false;
        if (enabled != other.enabled)
            return false;
        if (password == null) {
            if (other.password != null)
                return false;
        } else if (!password.equals(other.password))
            return false;
        if (username == null) {
            if (other.username != null)
                return false;
        } else if (!username.equals(other.username))
            return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("BaseUserDetails [accountNonExpired=");
        builder.append(accountNonExpired);
        builder.append(", accountNonLocked=");
        builder.append(accountNonLocked);
        builder.append(", authorities=");
        builder.append(authorities);
        builder.append(", credentialsNonExpired=");
        builder.append(credentialsNonExpired);
        builder.append(", enabled=");
        builder.append(enabled);
        builder.append(", password=");
        builder.append(password);
        builder.append(", username=");
        builder.append(username);
        builder.append("]");
        return builder.toString();
    }


}