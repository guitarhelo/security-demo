package com.smartcode.security.securitydemo.domain;

import javax.validation.constraints.NotNull;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.FetchType;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import org.springframework.format.annotation.DateTimeFormat;

import com.smartcode.security.securitydemo.domain.Role;

@Entity
@Table(name = "t_permission")
public class Permission {

	 
    /**
     */
    @NotNull
    private String permissionName;

    /**
     */
    private String permissionDesc;

    /**
     */
    @NotNull
    private String permissionString;

    /**
     */
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Date createDate;

    /**
     */
    private Boolean enabled;
    
    @ManyToMany(fetch = FetchType.EAGER, cascade = { CascadeType.PERSIST,CascadeType.MERGE},mappedBy = "permissions")
    private Set<Role> roles = new java.util.HashSet<Role>();


	public String getPermissionName() {
        return this.permissionName;
    }

	public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }

	public String getPermissionDesc() {
        return this.permissionDesc;
    }

	public void setPermissionDesc(String permissionDesc) {
        this.permissionDesc = permissionDesc;
    }

	public String getPermissionString() {
        return this.permissionString;
    }

	public void setPermissionString(String permissionString) {
        this.permissionString = permissionString;
    }

	public Date getCreateDate() {
        return this.createDate;
    }

	public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

	public Boolean getEnabled() {
        return this.enabled;
    }

	public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

	public Set<Role> getRoles() {
        return this.roles;
    }

	public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

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
}
