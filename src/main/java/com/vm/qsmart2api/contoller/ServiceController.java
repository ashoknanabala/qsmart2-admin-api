/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vm.qsmart2api.contoller;

import com.vm.Qsmart.model.Service;
import com.vm.qsmart2api.dtos.Response;
import com.vm.qsmart2api.dtos.ServiceGetDto;
import com.vm.qsmart2api.services.ServiceService;
import java.util.List;
import java.util.Locale;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Ashok
 */
@RestController
@RequestMapping("service/")
public class ServiceController {
    
     private static final Logger logger = LogManager.getLogger(ServiceController.class);
    
     @Autowired
     ServiceService serviceService;
     
    public String createService(){
        
        return null;
        
    }
    
    @PutMapping(path = "/{loginid}/status/{serviceId}/update",
            produces = {"application/json", "application/xml"})
    public ResponseEntity<Response> updateServiceStatus(
            @PathVariable("loginid") int loginId, @PathVariable("serviceId") int serviceId,
            @RequestParam("status") short status) {
        StringBuilder sb = null;
        String header = null;
         Response sResponse = null;
        try {
            sb = new StringBuilder();
            header = sb.append("[LOGIN_ID_").append(loginId).append("] ").toString().toUpperCase(Locale.getDefault());
            logger.info("{}>>:updateServiceStatus:LoignId:{},serviceId:{},Status:{}", header, loginId, serviceId, status);
             serviceService.updateStatusInDb(header, loginId, serviceId, status);
            sResponse = new Response(true, "successfully update");
            logger.info("{}<<:updateServiceStatus:Response:{}", header, sResponse);
            return ResponseEntity.status(HttpStatus.OK).body(sResponse);
        } catch (Exception e) {
            logger.error("{}Excep:updateServiceStatus:Error:{}", header, e.getMessage());
            Response srResponse = new Response(false, "update fail");
            logger.info("{}<<:updateServiceStatus:Response:[{}]", header, srResponse);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(srResponse);
        } 
    }
    
    
     @GetMapping(path = "{loginId}/getServicesBydeptId/{deptId}",
            produces = {"application/json", "application/xml"})
    public ServiceGetDto getServicesBydeptId(@PathVariable("loginId") int loginId,
            @PathVariable("deptId") int deptId) {
        try {
      return serviceService.getServicesByDeptId(deptId);
        } catch (Exception e) {
            e.printStackTrace();
        } 
         return null;
    }
    
    
     @GetMapping(path = "pagenation",
            produces = {"application/json", "application/xml"})
    public Page<Service> getServices() {
         Page<Service> service = null;
        try {
          service = serviceService.getServicesByaPagenation(PageRequest.of(0, 10));
        } catch (Exception e) {
            e.printStackTrace();
        } 
         return service;
    }
    
    
}
