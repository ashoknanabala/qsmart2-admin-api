///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.vm.qsmart2api.mapper;
//
//import com.vm.Qsmart.model.TblBranch;
//import com.vm.qsmart2api.dtos.BranchDto;
//import java.util.List;
//import org.mapstruct.Mapper;
//import org.mapstruct.ReportingPolicy;
//import org.mapstruct.factory.Mappers;
//
///**
// *
// * @author Ashok
// */
//@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
//public interface BranchMapper {
//
//   BranchMapper INSTANCE = Mappers.getMapper( BranchMapper.class );
//    
//    BranchDto branchToBranchDto(TblBranch branch);
//
//    TblBranch branchDtoToTblBranch(BranchDto branchDto);
//    
//    List<BranchDto> toBranchDto(List<TblBranch> branchs);
//
//}
