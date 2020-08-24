package com.smartcode.security.securitydemo.service.impl;

/**
 * Created by panjingp on 2/15/2017.
 */
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.smartcode.security.securitydemo.domain.Role;
import com.smartcode.security.securitydemo.domain.Permission;
import com.smartcode.security.securitydemo.repository.PermissionRepository;
import com.smartcode.security.securitydemo.repository.RoleRepository;
import com.smartcode.security.securitydemo.service.RoleService;

import org.springframework.security.access.SecurityConfig;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PermissionRepository permissionRepository;


    public long countAllRoles() {
        return roleRepository.count();
    }

    public void deleteRole(Role role) {
        roleRepository.delete(role);
    }

    public Role findRole(Long id) {
        return roleRepository.findById(id).get();
    }

    public List<Role> findAllRoles() {
        return roleRepository.findAll();
    }

    public List<Role> findRoleEntries(int firstResult, int maxResults) {
        return roleRepository.findAll(PageRequest.of(firstResult / maxResults, maxResults)).getContent();
    }

    public void saveRole(Role role) {
        roleRepository.save(role);
    }

    public Role updateRole(Role role) {
        return roleRepository.save(role);
    }

    @Override

    public Map<String, Collection<ConfigAttribute>> findAllPermission() {
        // TODO Auto-generated method stub
        Map<String, Collection<ConfigAttribute>> resourceMap = new HashMap<String, Collection<ConfigAttribute>>();
        List<Permission> permisson=permissionRepository.findAll();
        Iterator<Permission> it = permisson.iterator();
        while(it.hasNext())
        {
            Collection<ConfigAttribute> attsList = new ArrayList<ConfigAttribute>();
            Permission permissonEntiry=it.next();
            System.out.println("======"+permissonEntiry.getPermissionString());
            Set<Role> rp=permissonEntiry.getRoles();
            System.out.println("permiss_size"+rp.size());
            System.out.println("permiss"+rp);


            Iterator<Role> rpit = rp.iterator();
            while(rpit.hasNext())
            {
                //Permission permisson=new Permission();
                Role rpEntity= rpit.next();
                //	System.out.print("rpentity====="+rpEntity.getPermissionId().getUrl());

                //if(rpEntity!=null)
                //	 permisson=(Permission)rpEntity.getPermissionId();

                //String resourceUrl=permisson.getUrl();
                System.out.println("the role name=== "+rpEntity.getRoleName());
                ConfigAttribute caValue = new SecurityConfig(rpEntity.getRoleName());
                if(!attsList.contains(caValue))
                    attsList.add(caValue);
                System.out.println("attsList======"+attsList);




                //resourceMap.put(rpEntity.getPermissionId().getUrl(),attsList);
            }

            resourceMap.put(permissonEntiry.getPermissionString(),attsList);
            System.out.println("roucesMap size"+resourceMap.size());
            System.out.println("roucesMap"+resourceMap);
        }


        return resourceMap;
    }


}

