/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vm.qsmart2api.repository;

import com.vm.Qsmart.model.Role;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Tejasri
 */

public interface RolesRepository extends JpaRepository<Role, Integer> {

    @Query("SELECT r FROM Role r WHERE r.roleName=:roleName ")
    public Role findByRoleName(@Param("roleName") String roleName);

    //Role findByRoleName(String roleName);     
    @Query("SELECT r FROM Role r LEFT JOIN RoleTree rt ON r.roleId = rt.roleTreePK.roleId WHERE rt.roleTreePK.parentRoleId = :parentRoleId ")
    public List<Role> getRolesByParentRoleId(@Param("parentRoleId")int parentRoleId);
    
    }
