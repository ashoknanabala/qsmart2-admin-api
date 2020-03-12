/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vm.qsmart2api.repository;

//import com.vm.Qsmart.model.TblBranch;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Ashok
 */
//@Repository
//public interface BranchRepository extends JpaRepository<TblBranch, Integer> {
//
//    @Query(" SELECT loc.locId, loc.locNameEn, loc.locNameAr, br FROM TblLocation loc "
//            + " JOIN TblBranch br ON loc.locId= br.locationId"
//            + " where loc.locId=:locId")
//    public List<Object[]> getBranchesByLocId(@Param("locId") int locId);
//
////    @Query(" SELECT loc, br FROM TblLocation loc "
////            + " JOIN TblBranch br ON loc.locId= br.locationId"
////            + " where loc.locId=:locId")
////    public List<Object[]> getListByLocId(int locId);
//
//    
//    @Query(" SELECT loc.locId, loc.locNameEn, loc.locNameAr, br FROM TblLocation loc "
//            + " JOIN TblBranch br ON loc.locId= br.locationId")
//    public List<Object[]> getBranchesByLoc();
//
//}
