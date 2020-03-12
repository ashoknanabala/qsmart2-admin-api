///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.vm.qsmart2api.contoller;
//
//import com.vm.Qsmart.model.TblService;
//import com.vm.qsmart2api.dtos.Response;
//import com.vm.qsmart2api.dtos.service.ServiceCrtDto;
//import com.vm.qsmart2api.dtos.service.ServiceDto;
//import com.vm.qsmart2api.mapper.ServiceMapper;
//import com.vm.qsmart2api.repository.ServiceRepository;
//import com.vm.qsmart2api.services.ServiceService;
//import java.util.List;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
///**
// *
// * @author Tejasri
// */
//@RestController
//@RequestMapping("service/")
//public class ServiceQ2Controller {
//
//    private static final Logger logger = LogManager.getLogger(LocationController.class);
//
//    @Autowired
//    ServiceQ2Service serviceService;
//
//    @Autowired
//    ServiceQ2Repository serviceRepository;
//
//    @PostMapping("/create")
//    public ResponseEntity<Response> createService(@RequestBody ServiceCrtDto serviceDto) {
//       logger.info(">>[{}]", "Enter");
//        TblService location = ServiceQ2Mapper.INSTANCE.serviceCrtDtoToTblService(serviceDto);
//        
//        serviceService.save(location);
//        // return "Location created successfully";
//        Response response;
//        response = new Response(true, "Service succesfully created");
//       logger.info("<<[{}]:createService:[{}]", "Exit", response);
//        return ResponseEntity.status(HttpStatus.OK).body(response);
//    }
//
//
////    @PutMapping("/update")
////    public ResponseEntity<Response> updateLocation(@RequestBody ServiceDto service) {
////       logger.info(">>[{}]", "Enter");
////        serviceService.update(service);
////        Response response;
////        response = new Response(true, "Service succesfully updated");
////        logger.info("<<[{}]:updateLocation:[{}]", "Exit", response);
////        return ResponseEntity.status(HttpStatus.OK).body(response);
////    }
////
////    @GetMapping("/getallservice")
////    public List<TblService> getAllLocations() {
////        return serviceRepository.findAll();
////    }
////
//    @DeleteMapping("/locations/{id}")
//    public ResponseEntity<Response> deleteService(@PathVariable("id") int id) {
//       logger.info(">>[{}]", "Enter");
//        serviceRepository.deleteById(id);
//        Response response;
//        response = new Response(true, "Service succesfully deleted");
//        logger.info("<<[{}]:deleteService:[{}]", "Exit", response);
//        return ResponseEntity.status(HttpStatus.OK).body(response);
//    }
//
//}
