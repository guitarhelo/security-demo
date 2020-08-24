package com.smartcode.security.securitydemo.repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.smartcode.security.securitydemo.domain.Role;

import java.util.List;

@Repository

public interface RoleRepository extends CrudRepository<Role, Long> {
    Page<Role> findAll(Pageable pageable);
    List<Role> findAll();
}
