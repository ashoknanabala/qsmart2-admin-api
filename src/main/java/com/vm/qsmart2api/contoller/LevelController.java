/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vm.qsmart2api.contoller;

import com.vm.Qsmart.model.FloorData;
import com.vm.qsmart2api.dtos.CustomResponse;
import com.vm.qsmart2api.dtos.Response;
import com.vm.qsmart2api.dtos.department.DepartmentListDto;
import com.vm.qsmart2api.dtos.floor.FloorCreateDto;
import com.vm.qsmart2api.dtos.floor.FloorListDto;
import com.vm.qsmart2api.dtos.floor.FloorUpdateDto;
import com.vm.qsmart2api.dtos.floor.LevelGetDto;
import com.vm.qsmart2api.dtos.location.LocationCreateDto;
import com.vm.qsmart2api.mapper.LevelMapper;
import com.vm.qsmart2api.repository.LevelRepository;
import com.vm.qsmart2api.services.LevelService;
import com.vm.qsmart2api.utils.DBConstants;
import java.io.IOException;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Tejasri
 */
@RestController
@RequestMapping("level/")
public class LevelController {

    private static final Logger logger = LogManager.getLogger(LevelController.class);

    @Autowired
    @PersistenceContext(name = DBConstants.JPA_UNIT_NAME_QSMART)
    EntityManager entityManager;

    @Autowired
    LevelRepository levelRepository;

    @Autowired
    LevelService levelService;

    @PostMapping("{loginid}/create")
    public ResponseEntity<Response> createLevel(@RequestHeader(value = "Accept-Language", required = false)
            @PathVariable("loginid") int loginId,
            @Valid @RequestBody FloorCreateDto flooDto) throws IOException {
        StringBuilder sb = new StringBuilder();
        sb.append("[LOGIN_ID_").append(loginId).append("]");
        String header = sb.toString();
        Response response;
        try {
            logger.info("{}>>LoignId:{},GroupData:{}", header, loginId, (flooDto != null));
            logger.trace("{}>>LoignId:{},GroupData:{}", header, loginId, flooDto);
            FloorData floor = LevelMapper.INSTANCE.floorCreateDtoToFloorData(flooDto);
            levelService.save(loginId, floor);
            response = new Response(true, "Level succesfully created");
            logger.info("<<[{}]:data:[{}]", "Exit", response);
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (Exception e) {
            logger.error("{}Excep:createLocation:Error:{}", e.getMessage());
            response = new Response(false, "Failed to create Level");
            logger.info("{}<<:Response:[{}]", response);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        } finally {
            sb = null;
            header = null;
        }
    }

    @PutMapping(path = "{loginid}/update",
            produces = {"application/json", "application/xml"})
    public ResponseEntity<Response> updateLevel(@RequestHeader(value = "Accept-Language", required = false)
            @PathVariable("loginid") int loginId,
            @Valid @RequestBody FloorUpdateDto floor, Errors errors) {
        StringBuilder sb = new StringBuilder();
        sb.append("[LOGIN_ID_").append(loginId).append("]");
        String header = sb.toString();
        Response response = null;
        try {
            logger.info("{}>>LoignId:{},RequestBody:{}", header, loginId, (floor != null));
            logger.debug("{}>>:updateLocation:LoignId:{},RequestBody:{}", header, loginId, floor);
            if (errors.hasErrors()) {
                response = new Response(false, errors.getFieldError().getDefaultMessage());
                logger.info("{}<<Response:{}", header, response);
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
            } else {
                levelService.update(loginId, floor);
                response = new Response(true, "Level succesfully updated");
                logger.info("<<:[{}]", "Exit", response);
                return ResponseEntity.status(HttpStatus.OK).body(response);
            }
        } catch (Exception e) {
            logger.error("{}Excep:updateLocation:Error:{}", e.getMessage());
            response = new Response(false, "Failed to update location");
            logger.info("{}<<Response:[{}]", response);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        } finally {
            sb = null;
            header = null;
            response = null;
        }
    }

    @GetMapping(path = "{loginid}/getAll/{orgid}",
            produces = {"application/json", "application/xml"})
    public ResponseEntity<LevelGetDto> getAllLevelsByOrgId(@RequestHeader(value = "Accept-Language", required = false)
            @PathVariable("loginid") int loginId,
            @PathVariable("orgid") int orgId) {
        StringBuilder sb = new StringBuilder();
        sb.append("[LOGIN_ID_").append(loginId).append("]");
        String header = sb.toString();
        LevelGetDto loctn = new LevelGetDto();
        try {
            logger.info("{}>>Request:[{}]", header, loginId);
            loctn = levelService.getAllLevelsByOrgId(loginId, orgId);
            logger.trace("{}<<Response:{}", header, loctn);
            return ResponseEntity.status(HttpStatus.OK).body(loctn);
        } catch (Exception e) {
            logger.error("{}Excep:getAllLocations:Error:{}", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new LevelGetDto());
        } finally {
            sb = null;
            header = null;
        }
    }

    @PutMapping(path = "{loginid}/{floorid}/updatestatus/{status}",
            produces = {"application/json", "application/xml"})
    public String updateStatusByLevelId(
            @RequestHeader(value = "Accept-Language", required = false)
            @PathVariable("loginid") int loginId,
            @PathVariable("floorid") int floorId,
            @PathVariable("status") short status
    ) {
//        StringBuilder sb = new StringBuilder();
//        sb.append("[USER_ID_:").append(loginId).append("]");
//        String header = sb.toString().toUpperCase();
//        CustomResponse response = null;
        try {
            //logger.info("{}>>:updateStatusByLevelId:UserId:{}:sttaus:{}", header, loginId, status);
            levelService.updateLevelStatusinDb(floorId, status);
            // response = new CustomResponse(true,"Level Status Updated Sucessfully");
            //logger.info("{}<<:updateStatusByLevelId:Response:{}", header, response.isStatus());
            return "update successfully";
        } catch (Exception e) {
//            logger.error("{}Excep:updateStatusByLevelId:Error:{}", header, e.getMessage());
//            response = new CustomResponse(false, "Failed to update level status");
//            logger.error("{}Excep:updateStatusByLevelId:response:{}", header, response);
            e.printStackTrace();
            return "failed";

//        } finally {
//            sb = null;
//            header = null;
//            response = null;
//        }
        }
    }

    @GetMapping(path = "{loginid}/floor-service/{orgid}", produces = {"application/json", "application/xml"})
    public ResponseEntity<FloorListDto> getFloorsAndServices(@PathVariable("loginid") int loginId,
            @PathVariable("orgid") int orgId
    ) {
        StringBuilder sb = new StringBuilder();
        sb.append("[LOGIN_ID_:").append(loginId).append("]");
        String header = sb.toString();
        FloorListDto floorsss = new FloorListDto();
        try {
            logger.info("{}>>:getFloorsAndServices:LoignId:{},OrgId:{}", header, loginId, orgId);
            floorsss = levelService.getFloorsAndServicesByFacilitateId(header, orgId);
            logger.info("{}<<:getFloorsAndServices:Response:{}", header, (floorsss != null));
            logger.trace("{}<<:getFloorsAndServices:Response:{}", header, floorsss);
            return ResponseEntity.status(HttpStatus.OK).body(floorsss);
        } catch (Exception e) {
            logger.error("{}Excep:getFloorsAndServicesByFacilitateId:Error:{}", header, e.getMessage());
            floorsss = new FloorListDto(new ArrayList<>());
            logger.info("{}<<:getFloorsAndServicesByFacilitateId:Response:[{}]", header, floorsss);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(floorsss);
        } finally {
            sb = null;
            header = null;

        }
    }
    
    @GetMapping(path = "{loginid}/service-doctors/{floorId}", produces = {"application/json", "application/xml"})
    public ResponseEntity<DepartmentListDto> getDeptsWithServicesAndDoctorsByFloorId(@PathVariable("loginid") int loginId,
            @PathVariable("floorId") int floorId
    ) {
        StringBuilder sb = new StringBuilder();
        sb.append("[LOGIN_ID_:").append(loginId).append("]");
        String header = sb.toString();
        DepartmentListDto sResponse = null;
        try {
            logger.info("{}>>:getDeptsWithServicesAndDoctorsByFloorId:LoignId:{},floorId:{}", header, loginId, floorId);
            sResponse = levelService.getDeptsWithServicesAndDoctorsByFloorId(header, floorId);
            logger.info("{}<<:getDeptsWithServicesAndDoctorsByFloorId:Response:{}", header, (sResponse != null));
            logger.trace("{}<<:getDeptsWithServicesAndDoctorsByFloorId:Response:{}", header, sResponse);
            return ResponseEntity.status(HttpStatus.OK).body(sResponse);
        } catch (Exception e) {
            logger.error("{}Excep:getDeptsWithServicesAndDoctorsByFloorId:Error:{}", header, e.getMessage());
            sResponse = new DepartmentListDto(new ArrayList<>());
            logger.info("{}<<:getDeptsWithServicesAndDoctorsByFloorId:Response:{}", header, (sResponse != null));
            logger.trace("{}<<:getDeptsWithServicesAndDoctorsByFloorId:Response:{}", header, sResponse);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(sResponse);
        } finally {
            sb = null;
            header = null;
            sResponse = null;
        }
    }
    
}






