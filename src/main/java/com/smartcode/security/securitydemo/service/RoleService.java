package com.smartcode.security.securitydemo.service;

/**
 * Created by panjingp on 2/15/2017.
 */
import java.util.Collection;
import java.util.List;
import java.util.Map;
import org.springframework.security.access.ConfigAttribute;
import com.smartcode.security.securitydemo.domain.Role;
public interface RoleService {

    public abstract long countAllRoles();

    public abstract void deleteRole(Role role);

    public abstract Role findRole(Long id);

    public abstract List<Role> findAllRoles();

    public abstract List<Role> findRoleEntries(int firstResult, int maxResults);

    public abstract void saveRole(Role role);

    public abstract Role updateRole(Role role);

    public abstract Map<String, Collection<ConfigAttribute>> findAllPermission();


}

