/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vm.qsmart2api.mapper;

import com.vm.Qsmart.model.Department;
import com.vm.Qsmart.model.FloorData;
import com.vm.Qsmart.model.Service;
import com.vm.Qsmart.model.Users;
import com.vm.qsmart2api.dtos.department.DepartmentDataDto;
import com.vm.qsmart2api.dtos.floor.FloorCreateDto;
import com.vm.qsmart2api.dtos.floor.FloorDataDto;
import com.vm.qsmart2api.dtos.floor.FloorUpdateDto;
import com.vm.qsmart2api.dtos.floor.LevelGDto;
import com.vm.qsmart2api.dtos.service.ServiceDataDto;
import com.vm.qsmart2api.dtos.service.ServiceGDto;
import com.vm.qsmart2api.dtos.usersdto.DoctorGetDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

/**
 *
 * @author Tejasri
 * 
 */
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE,componentModel = "String")

public interface LevelMapper {
    
    LevelMapper INSTANCE = Mappers.getMapper( LevelMapper.class );
    
    FloorData floorCreateDtoToFloorData(FloorCreateDto dto);
    
    FloorData floorUpDtoToFloorData(FloorUpdateDto dto);
    
    LevelGDto floorDataToLevelGDto(FloorData dto);
    
    FloorDataDto floorDataToFloorDataDto(FloorData dto);
    
    ServiceGDto serviceToServiceGDto(Service dto);
    
    DepartmentDataDto departmentDtoToDepartment(Department dto);
    
    ServiceDataDto serviceDataDtoToService(Service dto);
    
    DoctorGetDto doctorGetDtoToUsers(Users dto);
    
}
