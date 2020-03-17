/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vm.qsmart2api.dtos.roles;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 *
 * @author VMLAP25
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class RolesDto {
    
    private Integer roleId;
    private String roleName;
    private String roleDescription;

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleDescription() {
        return roleDescription;
    }

    public void setRoleDescription(String roleDescription) {
        this.roleDescription = roleDescription;
    }

    @Override
    public String toString() {
        return "RolesDto{" + "roleId=" + roleId + ", roleName=" + roleName + ", roleDescription=" + roleDescription + '}';
    }

    
    
}
