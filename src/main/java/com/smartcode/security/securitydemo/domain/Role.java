package com.smartcode.security.securitydemo.domain;

import javax.validation.constraints.NotNull;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Version;

import com.smartcode.security.securitydemo.domain.User;
import com.smartcode.security.securitydemo.domain.Permission;

@Entity

@Table(name = "t_role")
public class Role {

    /**
     */
    @NotNull
    private String roleName;

    /**
     */
    private String roleDesc;

    /**
     */
    private Boolean enabled;

    /**
     */
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Date createDate;
    
    @ManyToMany(fetch = FetchType.EAGER, cascade = { CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "t_role_permission_map", joinColumns = { @JoinColumn(name = "role_id") }, inverseJoinColumns = { @JoinColumn(name = "permission_id") })
    private Set<Permission> permissions = new java.util.HashSet<Permission>();
    


	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

	@Version
    @Column(name = "version")
    private Integer version;

	public Long getId() {
        return this.id;
    }

	public void setId(Long id) {
        this.id = id;
    }

	public Integer getVersion() {
        return this.version;
    }

	public void setVersion(Integer version) {
        this.version = version;
    }

	public String getRoleName() {
        return this.roleName;
    }

	public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

	public String getRoleDesc() {
        return this.roleDesc;
    }

	public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }

	public Boolean getEnabled() {
        return this.enabled;
    }

	public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

	public Date getCreateDate() {
        return this.createDate;
    }

	public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

	public Set<Permission> getPermissions() {
        return this.permissions;
    }

	public void setPermissions(Set<Permission> permissions) {
        this.permissions = permissions;
    }


}
