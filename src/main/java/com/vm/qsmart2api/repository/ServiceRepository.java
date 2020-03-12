/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vm.qsmart2api.repository;

import com.vm.Qsmart.model.Service;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Ashok
 */
public interface ServiceRepository extends JpaRepository<Service, Integer>{
    
    @Modifying
    @Transactional
    @Query("UPDATE Service service set service.status=:status where service.id=:serviceId")
     public void update(@Param("serviceId")int serviceId, @Param("status") short status);

     @Query("SELECT s, fd.floorName, d.deptName,b.buildId,b.buildEngName,b.buildArbName FROM Service s "
                    + " inner join Department d on s.deptId = d.deptId "
                    + " inner join FloorData fd on d.floorId = fd.floorId "
                    + " Left JOIN BuildingInfo b on fd.buildId=b.buildId "
                    + " WHERE s.deptId = :deptId ")
    public List<Object[]> getServicesByDeptId(@Param("deptId")int deptId);
    
}
