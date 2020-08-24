package com.smartcode.security.securitydemo.service;

/**
 * Created by panjingp on 2/15/2017.
 */

import java.util.List;
import com.smartcode.security.securitydemo.domain.Permission;

public interface PermissionService {

    public abstract long countAllPermissions();
    public abstract void deletePermission(Permission permission);
    public abstract Permission findPermission(Long id);
    public abstract List<Permission> findAllPermissions();
    public abstract List<Permission> findPermissionEntries(int firstResult, int maxResults);
    public abstract void savePermission(Permission permission);
    public abstract Permission updatePermission(Permission permission);

}
