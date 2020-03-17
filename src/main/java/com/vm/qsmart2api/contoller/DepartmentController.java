/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vm.qsmart2api.contoller;

import com.vm.Qsmart.model.Department;
import static com.vm.qsmart2api.contoller.DepartmentController.logger;
import com.vm.qsmart2api.dtos.CustomResponse;
import com.vm.qsmart2api.dtos.Response;
import com.vm.qsmart2api.dtos.department.DepartmentFloorGetDto;
import com.vm.qsmart2api.dtos.department.DepartmentGtDto;
import com.vm.qsmart2api.dtos.department.DepartmentNewCrtDto;
import com.vm.qsmart2api.dtos.department.DepartmentNewUpDto;
import com.vm.qsmart2api.dtos.department.DeptPharmType;
import com.vm.qsmart2api.dtos.department.DeptPharmTypeGetDto;
import com.vm.qsmart2api.dtos.department.DeptType;
import com.vm.qsmart2api.dtos.department.DeptTypeGetDto;
import com.vm.qsmart2api.mapper.DepartmentMapper;
import com.vm.qsmart2api.repository.DepartmentRepository;
import com.vm.qsmart2api.services.DepartmentService;
import com.vm.qsmart2api.utils.DBConstants;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
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
@RequestMapping("Department/")
public class DepartmentController {

    public static final Logger logger = LogManager.getLogger(DepartmentController.class);

    @Autowired
    @PersistenceContext(name = DBConstants.JPA_UNIT_NAME_QSMART)
    EntityManager entityManager;

    @Autowired
    DepartmentRepository departmentRepository;

    @Autowired
    DepartmentService departmentService;

    @GetMapping(path = "{loginId}/dept-type", produces = {"application/json", "application/xml"})
    public ResponseEntity<DeptType> getDepartmentTypes(@RequestHeader(value = "Accept-Language", required = false)
            @PathVariable("loginId") int loginId) {
        StringBuilder sb = new StringBuilder();
        sb.append("[LOGIN_ID_:").append(loginId).append("]");
        String header = sb.toString();
        List<DeptTypeGetDto> dto = null;
        try {
            logger.info("{}>>:getDepartmentTypes():{}", header);
            dto = new ArrayList<DeptTypeGetDto>() {
                {
                    add(new DeptTypeGetDto(1, "GENERAL", "GN"));
                    add(new DeptTypeGetDto(2, "PHARMACY", "PH3"));
                    add(new DeptTypeGetDto(3, "LAB", "LB"));
                    add(new DeptTypeGetDto(4, "REGISTRATION", "RG"));
                }
            };
            return new ResponseEntity(new DeptType(dto), HttpStatus.OK);
        } catch (Exception e) {
            logger.error("Excep:getDepartmentTypes():{}", e);
            return new ResponseEntity(new DeptType(), HttpStatus.INTERNAL_SERVER_ERROR);
        } finally {
            sb = null;
            header = null;
            dto = null;
        }

    }

    @GetMapping(path = "{loginId}/dept-pharm-type", produces = {"application/json", "application/xml"})
    public ResponseEntity<DeptPharmType> getDeptPharmacyTypes(@RequestHeader(value = "Accept-Language", required = false)
            @PathVariable("loginId") int loginId) {
        StringBuilder sb = new StringBuilder();
        sb.append("[LOGIN_ID_:").append(loginId).append("]");
        String header = sb.toString();
        List<DeptPharmTypeGetDto> dto = null;
        try {
            logger.info("{}>>:getDeptPharmacyTypes():{}", header);
            dto = new ArrayList<DeptPharmTypeGetDto>() {
                {
                    add(new DeptPharmTypeGetDto(1, "REGULAR"));
                    add(new DeptPharmTypeGetDto(2, "EMERGENCY"));
                    add(new DeptPharmTypeGetDto(3, "GENERAL"));
                }
            };
            return new ResponseEntity(new DeptPharmType(dto), HttpStatus.OK);
        } catch (Exception e) {
            logger.error("Excep:getDeptPharmacyTypes():{}", e);
            return new ResponseEntity(new DeptPharmType(), HttpStatus.INTERNAL_SERVER_ERROR);
        } finally {
            sb = null;
            header = null;
            dto = null;
        }
    }

    @PostMapping(path = "{loginid}/create",
            produces = {"application/json", "application/xml"})
    public ResponseEntity<CustomResponse> createDepartment(@RequestHeader(value = "Accept-Language", required = false)
            @PathVariable("loginid") int loginId,
            @Valid @RequestBody DepartmentNewCrtDto departmentCrtDto) {
        StringBuilder sb = new StringBuilder();
        sb.append("[LOGIN_ID_:").append(loginId).append("]");
        String header = sb.toString();
        CustomResponse sResponse = null;
        try {
            logger.info("{}>>:loginId:{}:{}", header, loginId, (departmentCrtDto != null));
            logger.debug("{}>>:loginId:{}:{}", header, loginId, (departmentCrtDto != null));

            if (departmentService.validateFloorIdAndDeptName(header, departmentCrtDto.getFloorId(), departmentCrtDto.getDeptName())) {
                if (departmentService.validateDeptArbNameByFloorId(header, departmentCrtDto.getFloorId(), departmentCrtDto.getDeptArbName())) {
                    if (departmentCrtDto.getDeptType() == 2) {
                        if (departmentCrtDto.getPharmaType() == 3) {
                            departmentCrtDto.setPharmaIndex(-1);
                            departmentCrtDto.setPharmaLocation("-1");
                            int deptId = departmentService.saveDepartment(header, loginId, departmentCrtDto);
                            if (deptId != 0) {
                                sResponse = new CustomResponse(true, "Department Created Succesfully", deptId);
                                logger.info("{}<<:createDepartment:Response:{}", header, sResponse);
                                return ResponseEntity.status(HttpStatus.CREATED).body(sResponse);
                            } else {
                                sResponse = new CustomResponse(false, "department failed to create");
                                logger.info("{}<<:createDepartment:Response:[{}]", header, sResponse);
                                return ResponseEntity.status(HttpStatus.OK).body(sResponse);
                            }
                        }

                        if (departmentService.validatePharmaLocationByOrgIdInDb(header, departmentCrtDto.getOrgId(), departmentCrtDto.getPharmaLocation(), departmentCrtDto.getDeptType())) {
                            if (departmentService.validatePharmaIndexByOrgIdInDb(header, departmentCrtDto.getOrgId(), departmentCrtDto.getPharmaIndex(), departmentCrtDto.getDeptType())) {
                                int deptId = departmentService.saveDepartment(header, loginId, departmentCrtDto);
                                if (deptId != 0) {
                                    sResponse = new CustomResponse(true, "Department Created Succesfully", deptId);
                                    logger.info("{}<<:createDepartment:Response:{}", header, sResponse);
                                    return ResponseEntity.status(HttpStatus.CREATED).body(sResponse);
                                } else {
                                    sResponse = new CustomResponse(false, "department failed to create");
                                    logger.info("{}<<:createDepartment:Response:[{}]", header, sResponse);
                                    return ResponseEntity.status(HttpStatus.OK).body(sResponse);
                                }
                            } else {
                                sResponse = new CustomResponse(false, "Department Index Already Exists");
                                logger.info("{}<<:createDepartment:Response:{}", header, sResponse);
                                return ResponseEntity.status(HttpStatus.OK).body(sResponse);
                            }
                        } else {
                            sResponse = new CustomResponse(false, "Department Location Already Exits");
                            logger.info("{}<<:createDepartment:Response:{}", header, sResponse);
                            return ResponseEntity.status(HttpStatus.OK).body(sResponse);
                        }
                    } else {

                        int deptId = departmentService.saveDepartment(header, loginId, departmentCrtDto);
                        if (deptId != 0) {
                            sResponse = new CustomResponse(true, "Department Created Succesfully", deptId);
                            logger.info("{}<<:createDepartment:Response:{}", header, sResponse);
                            return ResponseEntity.status(HttpStatus.CREATED).body(sResponse);
                        } else {
                            sResponse = new CustomResponse(false, "department failed to create");
                            logger.info("{}<<:createDepartment:Response:[{}]", header, sResponse);
                            return ResponseEntity.status(HttpStatus.OK).body(sResponse);
                        }

                    }
                } else {
                    sResponse = new CustomResponse(false, "Department ArabName Already Exists");
                    logger.info("{}<<:createDepartment:Response:{}", header, sResponse);
                    return ResponseEntity.status(HttpStatus.OK).body(sResponse);
                }

            } else {
                sResponse = new CustomResponse(false, "Department EnglishNameAlready Exists");
                logger.info("{}<<:createDepartment:Response:{}", header, sResponse);
                return ResponseEntity.status(HttpStatus.OK).body(sResponse);
            }
        } catch (Exception e) {
            logger.error("{}Excep:createDepartment:Error:{}", header, e.getMessage());
            sResponse = new CustomResponse(false, "department failed to create");
            logger.info("{}<<:createDepartment:Response:[{}]", header, sResponse);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(sResponse);
        } finally {
            sb = null;
            header = null;
            sResponse = null;
        }
    }

    @PutMapping(path = "{loginid}/update",
            produces = {"application/json", "application/xml"})
    public ResponseEntity<CustomResponse> updateDepartment(@RequestHeader(value = "Accept-Language", required = false)
            @PathVariable("loginid") int loginId,
            @Valid @RequestBody DepartmentNewUpDto departmenttUpDto) {
        StringBuilder sb = new StringBuilder();
        sb.append("[LOGIN_ID_:").append(loginId).append("]");
        String header = sb.toString();
        CustomResponse sResponse = null;
        try {
            logger.info("{}>>:updateDepartment:LoignId:{},RequestBody:{}", header, loginId, (departmenttUpDto != null));
            logger.debug("{}>>:updateDepartment:LoignId:{},RequestBody:{}", header, loginId, (departmenttUpDto != null));
            if (departmentService.validateDeptEngNameByFloorId(header, departmenttUpDto)) {
                if (departmentService.validateDeptArbNameById(header, departmenttUpDto)) {
                    if (departmenttUpDto.getDeptType() == 2) {
                        if (departmenttUpDto.getPharmaType() == 3) {
                            int deptId = departmentService.updateDepartment(header, loginId, departmenttUpDto);
                            if (deptId != 0) {
                                sResponse = new CustomResponse(true, "Department updated Successfully", deptId);
                                logger.info("{}<<:updateDepartment:Response:{}", header, sResponse);
                                return ResponseEntity.status(HttpStatus.OK).body(sResponse);
                            } else {
                                sResponse = new CustomResponse(false, "Department failed to update");
                                logger.info("{}<<:updateDepartment:Response:[{}]", header, sResponse);
                                return ResponseEntity.status(HttpStatus.OK).body(sResponse);
                            }
                        }
                        if (departmentService.validatePharmaLocationUpdateByOrgIdInDb(header, departmenttUpDto.getOrgId(), departmenttUpDto.getPharmaLocation(), departmenttUpDto.getDeptId(), departmenttUpDto.getDeptType())) {
                            if (departmentService.validatePharmaIndexUpdateByOrgIdInDb(header, departmenttUpDto.getOrgId(), departmenttUpDto.getPharmaIndex(), departmenttUpDto.getDeptId(), departmenttUpDto.getDeptType())) {
                                int deptId = departmentService.updateDepartment(header, loginId, departmenttUpDto);
                                if (deptId != 0) {
                                    sResponse = new CustomResponse(true, "Department updated Successfully", deptId);
                                    logger.info("{}<<:updateDepartment:Response:{}", header, sResponse);
                                    return ResponseEntity.status(HttpStatus.OK).body(sResponse);
                                } else {
                                    sResponse = new CustomResponse(false, "Department failed to update");
                                    logger.info("{}<<:updateDepartment:Response:[{}]", header, sResponse);
                                    return ResponseEntity.status(HttpStatus.OK).body(sResponse);
                                }
                            } else {
                                sResponse = new CustomResponse(false, "Department PharmaIndex Already Exists");
                                logger.info("{}Exit:updateDepartment:Response:{}", header, sResponse);
                                return ResponseEntity.status(HttpStatus.OK).body(sResponse);
                            }
                        } else {
                            sResponse = new CustomResponse(false, "Department PharmaLocation already Exists");
                            logger.info("{}Exit:updateDepartment:Response:{}", header, sResponse);
                            return ResponseEntity.status(HttpStatus.OK).body(sResponse);
                        }
                    } else {
                        int deptId = departmentService.updateDepartment(header, loginId, departmenttUpDto);
                        if (deptId != 0) {
                            sResponse = new CustomResponse(true, "Department updated Successfully", deptId);
                            logger.info("{}<<:updateDepartment:Response:{}", header, sResponse);
                            return ResponseEntity.status(HttpStatus.OK).body(sResponse);
                        } else {
                            sResponse = new CustomResponse(false, "Department failed to update");
                            logger.info("{}<<:updateDepartment:Response:[{}]", header, sResponse);
                            return ResponseEntity.status(HttpStatus.OK).body(sResponse);
                        }
                    }
                } else {
                    sResponse = new CustomResponse(false, "Department Arabname already exists");
                    logger.info("{}<<:updateDepartment:Response:{}", header, sResponse);
                    return ResponseEntity.status(HttpStatus.OK).body(sResponse);
                }
            } else {
                sResponse = new CustomResponse(false, "Department Englishname Already exists");
                logger.info("{}<<:updateDepartment:Response:{}", header, sResponse);
                return ResponseEntity.status(HttpStatus.OK).body(sResponse);
            }
        } catch (Exception e) {
            logger.error("{}Excep:updateDepartment:Error:{}", header, e.getMessage());
            sResponse = new CustomResponse(false, "Department failed to update");
            logger.info("{}<<:updateDepartment:Response:[{}]", header, sResponse);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(sResponse);
        } finally {
            sb = null;
            header = null;
            sResponse = null;
        }
    }

    @GetMapping(path = "{loginId}/getdeptsByfloorId/{floorId}",
            produces = {"application/json", "application/xml"})
    public ResponseEntity<DepartmentFloorGetDto> findByFloorId(@RequestHeader(value = "Accept-Language", required = false)
            @PathVariable("loginId") int loginId,
            @PathVariable("floorId") int floorId) {
        StringBuilder sb = new StringBuilder();
        sb.append("[USER_:").append(loginId).append("]");
        String header = sb.toString().toUpperCase();
        DepartmentFloorGetDto deptList = new DepartmentFloorGetDto();
        try {
            logger.info("{}>>:getdeptsByfloorId:LoignId:{}:floorId:{}", header, loginId, floorId);
            List<Department> dept = departmentRepository.findDepartmentsByFloorId(floorId);
            System.out.println(">>>>>>>>>>>>>>>>>>>>" + dept.size());
            List<DepartmentGtDto> dto = DepartmentMapper.INSTANCE.departmentFloorGetDtoToDepartment(dept);

            deptList.setDepartments(dto);
            logger.info("{}<<:getdeptsByfloorId:Response:{}", header, (deptList != null));
            logger.debug("{}<<:getdeptsByfloorId:Response:{}", header, deptList);
            return ResponseEntity.status(HttpStatus.OK).body(deptList);
        } catch (Exception e) {
            logger.error("{}Excep:getdeptsByfloorId:Error:{}", header, e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new DepartmentFloorGetDto(new ArrayList<>()));
        } finally {
            sb = null;
            header = null;
        }
    }

    @GetMapping(path = "{loginId}/get-deptsBy-floorId/{floorId}",
            produces = {"application/json", "application/xml"})
    public ResponseEntity<DepartmentFloorGetDto> findDepartmentsByFloorId1(@RequestHeader(value = "Accept-Language", required = false)
            @PathVariable("loginId") int loginId,
            @PathVariable("floorId") int floorId) {
        StringBuilder sb = new StringBuilder();
        sb.append("[USER_:").append(loginId).append("]");
        String header = sb.toString().toUpperCase();
        DepartmentFloorGetDto deptList = new DepartmentFloorGetDto();
        try {
            logger.info("{}>>:getdeptsByfloorId:LoignId:{}:floorId:{}", header, loginId, floorId);
            deptList = departmentService.findDepartmentsByFloorId1(floorId);
            logger.info("{}<<:getdeptsByfloorId:Response:{}", header, (deptList != null));
            logger.debug("{}<<:getdeptsByfloorId:Response:{}", header, deptList);
            return ResponseEntity.status(HttpStatus.OK).body(deptList);
        } catch (Exception e) {
            logger.error("{}Excep:getdeptsByfloorId:Error:{}", header, e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new DepartmentFloorGetDto(new ArrayList<>()));
        } finally {
            sb = null;
            header = null;
        }
    }

    @DeleteMapping(path = "{loginid}/department/{deptId}",
            produces = {"application/json", "application/xml"})
    public ResponseEntity<Response> deleteBydeptId(@RequestHeader(value = "Accept-Language", required = false)
            @PathVariable("deptId") int deptId, @PathVariable("loginid") int loginId) {
        StringBuilder sb = new StringBuilder();
        sb.append("[LOGIN_ID_").append(loginId).append("]");
        String header = sb.toString();
        Response response;
        try {
            logger.info("{}>>Request:[{}]", header, deptId);
            departmentRepository.deleteById(deptId);
            response = new Response(true, "Department succesfully deleted");
            logger.info("<<[{}]:deleteLocation:[{}]", "Exit", response);
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (Exception e) {
            logger.error("{}Excep:deleteLocation:Error:{}", e.getMessage());
            response = new Response(false, "Failed to delete department");
            logger.info("{}<<Response:[{}]", response);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        } finally {
            sb = null;
            header = null;

        }
    }
}
