package com.smartcode.security.securitydemo.repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.smartcode.security.securitydemo.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;

@Repository


public interface UserRepository extends CrudRepository<User, Long> {
     Page<User> findAll(Pageable pageable);
     List<User> findByLoginName(String loginName);
     List<User> findByFullNameContaining(String fullname);

}
