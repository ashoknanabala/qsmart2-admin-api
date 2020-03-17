/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vm.qsmart2api.dtos.roles;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author VMLAP25
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class RolesCreateDto {  

    @Size(min = 1, max = 50, message = "{role.dto.namesize}")
    @ApiModelProperty(required = true, notes = "Role name should't be empty.", example = "Admin")
    @NotNull(message = "{role.dto.rname.notnull}")
    private String roleName;

    @Size(min = 1, max = 200, message = "{role.dto.descritptionsize}")
    @ApiModelProperty(required = true, notes = "Role description should't be empty.", example = "is an admin")
    @NotNull(message = "{role.dto.description.notnull}")
    private String roleDescription;

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
        return "RolesCreateDto{" + "roleName=" + roleName + ", roleDescription=" + roleDescription + '}';
    }

}
