/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vm.qsmart2api.mapper;

import com.vm.Qsmart.model.Service;
import com.vm.qsmart2api.dtos.ServiceGDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

/**
 *
 * @author Ashok
 */
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ServiceMapper {
    
      ServiceMapper INSTANCE = Mappers.getMapper( ServiceMapper.class );
      
     ServiceGDto serivceToServiceGDto(Service serivce);
}
