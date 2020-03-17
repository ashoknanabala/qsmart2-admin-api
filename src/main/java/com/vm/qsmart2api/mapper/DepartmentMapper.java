/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vm.qsmart2api.mapper;

import com.vm.Qsmart.model.Department;
import com.vm.qsmart2api.dtos.department.DepartmentFloorGetDto;
import com.vm.qsmart2api.dtos.department.DepartmentGtDto;
import com.vm.qsmart2api.dtos.department.DepartmentNewCrtDto;
import com.vm.qsmart2api.dtos.department.DepartmentNewUpDto;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

/**
 *
 * @author Tejasri
 */
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE,componentModel = "String")
public interface DepartmentMapper {
 DepartmentMapper INSTANCE = Mappers.getMapper(DepartmentMapper.class);
 
 Department departmentCrtDtoToDepartment(DepartmentNewCrtDto dto);
    
 Department departmentUpdateDtoToDepartment(DepartmentNewUpDto dto);
 
 List<DepartmentGtDto> departmentFloorGetDtoToDepartment(List<Department> dto);
 
 DepartmentGtDto departmentToDepartmentGtDto(Department dto);
 
}
