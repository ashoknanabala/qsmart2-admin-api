/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vm.qsmart2api.services;

import com.vm.Qsmart.model.Role;
import com.vm.qsmart2api.dtos.roles.RolesCreateDto;
import com.vm.qsmart2api.mapper.RolesMapper;
import com.vm.qsmart2api.repository.RolesRepository;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Tejasri
 */
public class RolesService {

    @Autowired
    RolesRepository rolesRepository;

    public static final Logger logger = LogManager.getLogger(RolesService.class);

    public int saveRolesInDb(String header, int loginId, RolesCreateDto roleCreateDto) {
        logger.info("{}Enter:saveRolesInDb:RequestBody:{}:", header, roleCreateDto);
        try {
            Role role = RolesMapper.INSTANCE.rolesCreateDtoToRole(roleCreateDto);
            role.setCreatedBy(loginId);
            role.setStatus((short) 1);
            rolesRepository.save(role);
            return role.getRoleId();
        } catch (Exception e) {
            logger.error("{}Excep:saveCorporateInDb:Error:{}", header, ExceptionUtils.getRootCauseMessage(e));
            throw new RuntimeException("Role failed to create");
        }
    }
}
