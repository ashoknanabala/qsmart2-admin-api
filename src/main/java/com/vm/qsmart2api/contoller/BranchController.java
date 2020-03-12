///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.vm.qsmart2api.contoller;
//
//import com.vm.Qsmart.model.TblBranch;
//import com.vm.qsmart2api.dtos.BranchDto;
//import com.vm.qsmart2api.dtos.LocationBranchDto;
//import com.vm.qsmart2api.dtos.Response;
//import com.vm.qsmart2api.mapper.BranchMapper;
//import com.vm.qsmart2api.services.BranchService;
//import java.util.List;
//import java.util.Locale;
//import java.util.Optional;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
///**
// *
// * @author Ashok
// */
//@RestController
//@RequestMapping("branch/")
//public class BranchController {
//
//    private static final Logger logger = LogManager.getLogger(UserController.class);
//
//    @Autowired
//    BranchService branchService;
//
//    @GetMapping("{id}")
//    public BranchDto getBranch(@PathVariable("id") int id) {
//        logger.info("{}>>:createBranch:Request:[{}]", id);
//         BranchDto branchDto = new BranchDto();
//         try{
//        Optional<TblBranch> branch = branchService.findById(id);
//        if(branch.isPresent()){
//         branchDto = BranchMapper.INSTANCE.branchToBranchDto(branch.get());  
//        }
//        logger.info("{}>>:createBranch:Respnse:[{}]", id);
//          }catch(Exception e){
//              e.printStackTrace();
//          }
//     return branchDto;
//    }
//
//    @GetMapping("allbranch")
//    public List<BranchDto> getAllBranch() {
//        List<BranchDto> branchDtos = null;
//        try {
//            List<TblBranch> branchs = branchService.findAllBranch();
//            branchDtos = BranchMapper.INSTANCE.toBranchDto(branchs);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return branchDtos;
//
//    }
//
//    @PostMapping("{loginid}/create")
//    public ResponseEntity<Response> createBranch(@RequestBody BranchDto branchDto, @PathVariable("logingid") int logingid) {
//        logger.info("{}>>:createBranch:Request:[{}]", logingid);
//        Response response;
//        TblBranch branch = BranchMapper.INSTANCE.branchDtoToTblBranch(branchDto);
//        try {
//            branchService.save(branch);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        logger.info("{}>>:createBranch:Response:[{}]", logingid);
//        response = new Response(true, "Branch created successfully");
//        return ResponseEntity.status(HttpStatus.OK).body(response);
//    }
//
//    @PostMapping("{logingid}/update/{id}")
//    public ResponseEntity<Response> updateBranch(@RequestBody BranchDto branchDto, @PathVariable("id") int id, @PathVariable("logingid") int logingid) {
//        logger.info("{}>>:updateBranch:Request:[{}]", id);
//        TblBranch branch = branchService.findById(id).get();
//        Response response = null;
//        if (branch == null) {
//            response = new Response(false, "Branch is not found");
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
//        } else {
//            branch.setBranchNameAr(branchDto.getBranchNameAr());
//            branch.setBranchNameEn(branchDto.getBranchNameEn());
//            try {
//                branchService.save(branch);
//                response = new Response(true, "Branch updated successfully");
//                logger.info("{}>>:updateBranch:Request:[{}]", id);
//
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//            return ResponseEntity.status(HttpStatus.OK).body(response);
//        }
//    }
//
//    @GetMapping("dtos/{id}")
//    public LocationBranchDto getdtos(@PathVariable("id") int locId) {
//        logger.info(">>[{}]", locId);
//        return branchService.getDtos(locId);
//    }
//    
//    @GetMapping("getbranchs")
//    public List<LocationBranchDto> getAllBranchs() {
//        return branchService.getAllBranchs();
//    }
//
//}
