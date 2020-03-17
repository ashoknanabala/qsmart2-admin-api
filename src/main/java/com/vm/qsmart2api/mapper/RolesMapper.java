/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vm.qsmart2api.mapper;

import com.vm.Qsmart.model.Role;
import com.vm.qsmart2api.dtos.roles.RolesCreateDto;
import com.vm.qsmart2api.dtos.roles.RolesDto;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

/**
 *
 * @author Tejasri
 */
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE,componentModel = "String")
public interface RolesMapper {
    RolesMapper INSTANCE =Mappers.getMapper(RolesMapper.class);
    
    List<RolesDto> rolesToRolesDto(List<Role> dto);
    
    Role rolesCreateDtoToRole(RolesCreateDto dto);
    
    RolesDto rolesToRolesDtooo(Role dtos);
    
}

