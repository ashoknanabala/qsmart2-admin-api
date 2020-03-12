///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.vm.qsmart2api.repository;
//
//import com.vm.Qsmart.model.TblLocation;
//import java.util.List;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//
///**
// *
// * @author Tejasri
// */
//public interface LocationRepository extends JpaRepository<TblLocation, Integer> {
//
//    @Query("SELECT loc, br"
//            + " from TblLocation loc JOIN "
//            + " TblBranch br ON loc.locId=br.locationId ")
//    public List<Object[]> getLocationWithBranches();
//    
//    
//    @Query("SELECT loc.locId,loc.locNameEn,loc.locNameAr, br FROM TblLocation loc "
//            + " JOIN TblBranch br ON loc.locId=br.locationId ")
//    public List<Object[]> getLocationWithBranches2();
//
//}
