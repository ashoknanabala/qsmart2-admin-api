/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vm.qsmart2api.repository;

import com.vm.Qsmart.model.FloorData;
import com.vm.Qsmart.utils.LnkMenyTypes;
import com.vm.Qsmart.utils.UserRoles;
import static com.vm.Qsmart.utils.UserRoles.DOCTOR;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author Tejasri
 */
public interface LevelRepository extends JpaRepository<FloorData, Integer> {

    @Query("SELECT fd,bi.buildEngName,bi.buildArbName,bi.buildId FROM FloorData fd "
            + " left join BuildingInfo bi on bi.buildId = fd.buildId "
            + "where fd.orgId = :orgId")

    public List<Object[]> getAllLevelsByOrgId(@Param("orgId") int orgId);

    @Modifying
    @Transactional
    @Query("UPDATE FloorData f set f.status=:status Where f.floorId=:floorId")
    public void updateLevelStatusinDb(@Param("floorId") int floorId, @Param("status") short status);

    @Query("SELECT fd, s,bi.buildId,bi.buildEngName,bi.buildArbName FROM FloorData fd "
            + "inner join Service s on fd.floorId = s.floorId "
            + " left join BuildingInfo bi on bi.buildId = fd.buildId "
            + "where fd.orgId = :orgId AND fd.status='1'")
    public List<Object[]> getFloorsAndServicesByFacilitateId(@Param("orgId") int facilitateId);

    @Query("SELECT d,s,u FROM Department d "
                    + " inner join Service s on d.deptId = s.deptId "
                    + " left join LnkMenuHirarchy lmh on lmh.parentId = s.serviceId "
                    + " left join Users u on lmh.childId = u.userId  join fetch u.roles r"
                    + " where d.floorId = :floorId and lmh.lnkMenuId =:lnkMenuId "
                    + " and (r.roleId = :roleId or r.roleId = :roleId1) and u.isactive='1' and s.status='1'")
    public List<Object[]> getDeptsWithServicesAndDoctorsByFloorId(@Param("floorId") int floorId, @Param("lnkMenuId") int lnkMenuId,@Param("roleId") int roleId,@Param("roleId1") int roleId1);
    
}
