/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vm.qsmart2api.dtos.roles;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;

/**
 *
 * @author VMHDCLAP21
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class RoleDto {

    @ApiModelProperty(required = true, notes = "roleId should not be empty", example = "2")
    @NotNull(message = "{role.dto.roleId.notnull}")
    private Integer roleId;
    
    @ApiModelProperty(required = true, notes = "roleName should not be empty", example = "2")
    @NotNull(message = "{role.dto.rname.notnull}")
    private String roleName;

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    @Override
    public String toString() {
        return "RoleDto{" + "roleId=" + roleId + ", roleName=" + roleName + '}';
    }

}
