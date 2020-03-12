///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.vm.qsmart2api.mapper;
//
//import com.vm.Qsmart.model.TblService;
//import com.vm.qsmart2api.dtos.serviceq2.ServiceCrtDto;
//import com.vm.qsmart2api.dtos.serviceq2.ServiceDto;
//import org.mapstruct.Mapper;
//import org.mapstruct.ReportingPolicy;
//import org.mapstruct.factory.Mappers;
//
///**
// *
// * @author Tejasri
// */
//
//@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE,componentModel = "String")
//public interface ServiceQ2Mapper {
//    
//     ServiceQ2Mapper INSTANCE = Mappers.getMapper( ServiceQ2Mapper.class );
//     
//    TblService serviceCrtDtoToTblService(ServiceCrtDto dto);
//    
//    ServiceDto tblServiceToServiceDto(TblService service);
//    
//}
