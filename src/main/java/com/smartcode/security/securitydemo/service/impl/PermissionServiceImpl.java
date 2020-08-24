package com.smartcode.security.securitydemo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.smartcode.security.securitydemo.domain.Permission;
import com.smartcode.security.securitydemo.repository.PermissionRepository;
import com.smartcode.security.securitydemo.service.PermissionService;

@Service
@Transactional
public class PermissionServiceImpl implements PermissionService {

	@Autowired
    PermissionRepository permissionRepository;

	public long countAllPermissions() {
        return permissionRepository.count();
    }

	public void deletePermission(Permission permission) {
        permissionRepository.delete(permission);
    }

	public Permission findPermission(Long id) {
        return permissionRepository.findById(id).get();
    }

	public List<Permission> findAllPermissions() {
        return permissionRepository.findAll();
    }

	public List<Permission> findPermissionEntries(int firstResult, int maxResults) {
        return permissionRepository.findAll(PageRequest.of(firstResult / maxResults, maxResults)).getContent();
    }

	public void savePermission(Permission permission) {
        permissionRepository.save(permission);
    }

	public Permission updatePermission(Permission permission) {
        return permissionRepository.save(permission);
    }
}
