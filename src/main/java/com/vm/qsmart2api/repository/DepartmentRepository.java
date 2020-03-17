/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vm.qsmart2api.repository;

import com.vm.Qsmart.model.Department;
import com.vm.qsmart2api.mapper.DepartmentMapper;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Tejasri
 */
public interface DepartmentRepository extends JpaRepository<Department, Integer> {

    @Query("SELECT d FROM Department d WHERE UPPER(d.deptName) = :deptName "
            + "and d.floorId=:floorId ")
    public Department validateFloorIdAndDeptName(@Param("deptName") String deptName, @Param("floorId") int floorId);

    @Query("SELECT d FROM Department d WHERE UPPER(d.deptArbName) = :deptArbName "
            + "and d.floorId=:floorId ")
    public Department validateDeptArbNameByFloorId(@Param("deptArbName") String deptArbName, @Param("floorId") int floorId);

    @Query("SELECT d FROM Department d WHERE UPPER(d.pharmaLocation) = :pharmaLocation and d.orgId = :orgId and d.deptType=:deptType")
    public Department validatePharmaLocationByOrgIdInDb(@Param("orgId") int orgId, @Param("pharmaLocation") String pharmaLocation, @Param("deptType") short deptType);

    @Query("SELECT p FROM Department p WHERE p.pharmaIndex = :pharmaIndex and p.orgId = :orgId and p.deptType=:deptType ")
    public Department validatePharmaIndexByOrgIdInDb(@Param("orgId") int orgId, @Param("pharmaIndex") int pharmaIndex, @Param("deptType") short deptType);

    Department findByDeptId(int deptId);

    @Query("SELECT d FROM Department d "
            + " WHERE UPPER(d.deptName) = :deptName "
            + " and d.floorId = :floorId "
            + " and d.deptId != :deptId ")
    public Department validateDeptEngNameByFloorId(@Param("deptName") String deptName, @Param("floorId") int floorId, @Param("deptId") int deptId);

    @Query("SELECT d FROM Department d "
            + " WHERE d.floorId = :floorId "
            + " and d.deptId != :deptId and d.deptArbName = :deptArbName")
    public Department validateDeptArbNameById(@Param("floorId") int floorId, @Param("deptId") int deptId, @Param("deptArbName") String deptArbName);

    @Query("SELECT d FROM Department d WHERE UPPER(d.pharmaLocation) = :pharmaLocation and d.deptId!=:deptId and d.orgId = :orgId and d.deptType=:deptType")
    public Department validatePharmaLocationUpdateByOrgIdInDb(@Param("orgId") int orgId, @Param("pharmaLocation") String pharmaLocation, @Param("deptId") int deptId, @Param("deptType") int deptType);

    @Query("SELECT p FROM Department p WHERE p.pharmaIndex = :pharmaIndex and p.deptId!=:deptId and p.orgId = :orgId and p.deptType=:deptType")
    public Department validatePharmaIndexUpdateByOrgIdInDb(@Param("orgId") int orgId, @Param("pharmaIndex") int pharmaIndex, @Param("deptId") int deptId, @Param("deptType") int deptType);
    
    @Query("SELECT dp FROM Department dp WHERE dp.floorId=:floorId")
    public List<Department> findDepartmentsByFloorId(@Param("floorId") int floorId);

    @Query("SELECT dp FROM Department dp WHERE dp.floorId=:floorId")
    public List<Object[]> findDepartmentsByFloorId1(@Param("floorId") int floorId);
    
}
