///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.vm.qsmart2api.contoller;
//
//import com.vm.Qsmart.model.TblLocation;
//import com.vm.qsmart2api.dtos.Response;
//import com.vm.qsmart2api.dtos.location.LocationBranchDto;
//import com.vm.qsmart2api.dtos.location.LocationCreateDto;
//import com.vm.qsmart2api.dtos.location.LocationDto;
//import com.vm.qsmart2api.dtos.location.LocationGDto;
//import com.vm.qsmart2api.dtos.location.LocationGetDto;
//import com.vm.qsmart2api.mapper.LocationMapper;
//import static com.vm.qsmart2api.mapper.LocationMapper.INSTANCE;
//import com.vm.qsmart2api.repository.LocationRepository;
//import com.vm.qsmart2api.services.LocationService;
//import com.vm.qsmart2api.utils.DBConstants;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Locale;
//import java.util.Optional;
//import static javafx.scene.input.KeyCode.T;
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//import javax.validation.Valid;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.validation.Errors;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestHeader;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
///**
// *
// * @author Tejasri
// */
//@RestController
//@RequestMapping("location/")
//public class LocationController {
//
//    private static final Logger logger = LogManager.getLogger(LocationController.class);
//
//    @Autowired
//    @PersistenceContext(name = DBConstants.JPA_UNIT_NAME_QSMART)
//    EntityManager entityManager;
//
//    @Autowired
//    LocationService locationService;
//
//    @Autowired
//    LocationRepository locationRepository;
//
//    @PostMapping("{loginid}/create")
//
//    public ResponseEntity<Response> createLocation(@RequestHeader(value = "Accept-Language", required = false)
//            @PathVariable("loginid") int loginId,
//            @Valid @RequestBody LocationCreateDto locationDto) throws IOException {
//        StringBuilder sb = new StringBuilder();
//        sb.append("[LOGIN_ID_").append(loginId).append("]");
//        String header = sb.toString();
//        Response response;
//        try {
//
//            logger.info("{}>>LoignId:{},GroupData:{}", header, loginId, (locationDto != null));
//            logger.trace("{}>>LoignId:{},GroupData:{}", header, loginId, locationDto);
//
//            TblLocation location = LocationMapper.INSTANCE.locationCrtDtoToTblLocation(locationDto);
//            locationService.save(location);
//            response = new Response(true, "Location succesfully created");
//            logger.info("<<[{}]:data:[{}]", "Exit", response);
//            return ResponseEntity.status(HttpStatus.OK).body(response);
//
//        } catch (Exception e) {
//            logger.error("{}Excep:createLocation:Error:{}", e.getMessage());
//            response = new Response(false, "Failed to create location");
//            logger.info("{}<<:Response:[{}]", response);
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
//        } finally {
//            sb = null;
//            header = null;
//            // response = null;
//        }
//    }
//
//    @PutMapping(path = "{loginid}/update",
//            produces = {"application/json", "application/xml"})
//    public ResponseEntity<Response> updateLocation(@RequestHeader(value = "Accept-Language", required = false)
//            @PathVariable("loginid") int loginId,
//            @Valid @RequestBody LocationDto location, Errors errors) {
//        StringBuilder sb = new StringBuilder();
//        sb.append("[LOGIN_ID_").append(loginId).append("]");
//        String header = sb.toString();
//        Response response = null;
//        try {
//            logger.info("{}>>LoignId:{},RequestBody:{}", header, loginId, (location != null));
//            logger.debug("{}>>:updateLocation:LoignId:{},RequestBody:{}", header, loginId, location);
//            if (errors.hasErrors()) {
//                response = new Response(false, errors.getFieldError().getDefaultMessage());
//                logger.info("{}<<Response:{}", header, response);
//                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
//            } else {
//                locationService.update(loginId, location);
//                response = new Response(true, "Location succesfully updated");
//                logger.info("<<:[{}]", "Exit", response);
//                return ResponseEntity.status(HttpStatus.OK).body(response);
//            }
//        } catch (Exception e) {
//            logger.error("{}Excep:updateLocation:Error:{}", e.getMessage());
//            response = new Response(false, "Failed to update location");
//            logger.info("{}<<Response:[{}]", response);
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
//        } finally {
//            sb = null;
//            header = null;
//            response = null;
//        }
//    }
//
//    @GetMapping(path = "{loginid}/getAll",
//            produces = {"application/json", "application/xml"})
//    public ResponseEntity<LocationGDto> getAllLocations(@RequestHeader(value = "Accept-Language", required = false)
//            @PathVariable("loginid") int loginId) {
//        StringBuilder sb = new StringBuilder();
//        sb.append("[LOGIN_ID_").append(loginId).append("]");
//        String header = sb.toString();
//        LocationGDto loctn = new LocationGDto();
//        try {
//            logger.info("{}>>Request:[{}]", header, loginId);
//            List<TblLocation> location = locationRepository.findAll();
//            List<LocationDto> locationDto = LocationMapper.INSTANCE.toToLocationDto(location);
//            loctn.setLocation(locationDto);
//            logger.trace("{}<<Response:{}", header, loctn);
//            return ResponseEntity.status(HttpStatus.OK).body(loctn);
//        } catch (Exception e) {
//            logger.error("{}Excep:getAllLocations:Error:{}", e.getMessage());
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new LocationGDto());
//        } finally {
//            sb = null;
//            header = null;
//
//        }
//    }
//
//    @DeleteMapping(path = "{loginid}/locations/{id}",
//            produces = {"application/json", "application/xml"})
//    public ResponseEntity<Response> deleteLocation(@RequestHeader(value = "Accept-Language", required = false)
//            @PathVariable("id") int id, @PathVariable("loginid") int loginId) {
//        StringBuilder sb = new StringBuilder();
//        sb.append("[LOGIN_ID_").append(loginId).append("]");
//        String header = sb.toString();
//        Response response = null;
//        try {
//            logger.info("{}>>Request:[{}]", header, id);
//            locationRepository.deleteById(id);
//            response = new Response(true, "Location succesfully deleted");
//            logger.info("<<[{}]:deleteLocation:[{}]", "Exit", response);
//            return ResponseEntity.status(HttpStatus.OK).body(response);
//        } catch (Exception e) {
//            logger.error("{}Excep:deleteLocation:Error:{}", e.getMessage());
//            response = new Response(false, "Failed to delete location");
//            logger.info("{}<<Response:[{}]", response);
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
//        } finally {
//            sb = null;
//            header = null;
//            response = null;
//        }
//    }
//
//    @GetMapping(path = "{loginid}/{uuid}/getLocations-Branches",
//            produces = {"application/json", "application/xml"})
//    public ResponseEntity<LocationBranchDto> getAllLocationsWithBranches(@RequestHeader(value = "Accept-Language", required = false)
//            @PathVariable("loginid") int loginId, @PathVariable("uuid") int uniqueId) {
//        StringBuilder sb = new StringBuilder();
//        sb.append("[LOGIN_ID_").append(loginId).append("]");
//        sb.append("[UNIQUE_ID_").append(uniqueId).append("]");
//        String header = sb.toString();
//        LocationBranchDto loctn = new LocationBranchDto();
//        try {
//            logger.info("{}>>Request:[{}]", header, loginId);
//            loctn = locationService.getLocationsWithBranches(loginId);
//            logger.trace("{}<<Response:{}", header, loctn);
//            return ResponseEntity.status(HttpStatus.OK).body(loctn);
//        } catch (Exception e) {
//            logger.error("{}Excep:getAllLocations:Error:{}", e.getMessage());
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new LocationBranchDto());
//        } finally {
//            sb = null;
//            header = null;
//
//        }
//    }
//    @GetMapping("dtos")
//    public List<LocationGetDto> getAllLocationsWithBranches2() {
//        return locationService.getAllLocationsWithBranches2();
//    }
//}
//
