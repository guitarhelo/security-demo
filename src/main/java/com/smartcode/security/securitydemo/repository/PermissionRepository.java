package com.smartcode.security.securitydemo.repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.smartcode.security.securitydemo.domain.Permission;

import java.util.List;


@Repository
public interface PermissionRepository extends CrudRepository<Permission, Long> {
    Page<Permission> findAll(Pageable pageable);
    List<Permission> findAll();
}
