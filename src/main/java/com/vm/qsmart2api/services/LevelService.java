/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vm.qsmart2api.services;

import com.vm.Qsmart.model.Department;
import com.vm.Qsmart.model.FloorData;
import com.vm.Qsmart.model.Users;
import com.vm.Qsmart.utils.LnkMenyTypes;
import com.vm.Qsmart.utils.UserRoles;
import com.vm.qsmart2api.dtos.department.DepartmentDataDto;
import com.vm.qsmart2api.dtos.department.DepartmentListDto;

import com.vm.qsmart2api.dtos.floor.FloorDataDto;
import com.vm.qsmart2api.dtos.floor.FloorListDto;
import com.vm.qsmart2api.dtos.floor.FloorUpdateDto;
import com.vm.qsmart2api.dtos.floor.LevelGDto;
import com.vm.qsmart2api.dtos.floor.LevelGetDto;
import com.vm.qsmart2api.dtos.service.ServiceDataDto;
import com.vm.qsmart2api.dtos.service.ServiceGDto;
import com.vm.qsmart2api.dtos.usersdto.DoctorGetDto;
import com.vm.qsmart2api.mapper.LevelMapper;
import com.vm.qsmart2api.repository.LevelRepository;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Tejasri
 *
 */
@Service
public class LevelService {

    private static final Logger logger = LogManager.getLogger(LevelService.class);

    @Autowired
    LevelRepository levelRepository;

    public void save(int loginId, FloorData floor) {
        floor.setCreatedBy(loginId);
        floor.setStatus((short) 1);
        levelRepository.save(floor);
    }

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public void update(int loginId, FloorUpdateDto floorUdto) {
        FloorData floor = levelRepository.getOne(floorUdto.getFloorId());
        FloorData floorD = LevelMapper.INSTANCE.floorUpDtoToFloorData(floorUdto);
        floorD.setUpdatedBy(loginId);
        levelRepository.save(floorD);
    }

    public LevelGetDto getAllLevelsByOrgId(int loginId, int orgId) {
        FloorData floor = new FloorData();
        logger.info(">>:loginId:[{}]", loginId);
        try {
            List<Object[]> list = levelRepository.getAllLevelsByOrgId(orgId);

            System.out.println("00000---->" + list.size());
            List<LevelGDto> levels = new ArrayList<>();
            if (list != null && !list.isEmpty()) {
                list.forEach(obj -> {
                    LevelGDto levelDto = LevelMapper.INSTANCE.floorDataToLevelGDto((FloorData) obj[0]);

                    if (obj[3] != null) {
                        levelDto.setBuildEngName((String) obj[1]);
                        levelDto.setBuildArbName((String) obj[2]);
                    } else {
                        levelDto.setBuildId(0);
                    }
                    levels.add(levelDto);
                });
            }
            return new LevelGetDto(levels);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("{}Excep:getAllLevelsByOrgId:Error:{}", ExceptionUtils.getRootCauseMessage(e));
            return new LevelGetDto(new ArrayList<>());
        }
    }

    public void updateLevelStatusinDb(int floorId, short status) {
        try {
            // logger.info("{}Enter:updateLevelStatusinDb:FloorId:[{}],Status:[{}]", header, floorId, status);
            levelRepository.updateLevelStatusinDb(floorId, status);
        } catch (Exception e) {
            e.printStackTrace();
//            logger.error("{}Excep:updateLevelStatusinDb:Error:{}", header, ExceptionUtils.getRootCauseMessage(e));
//            throw new RuntimeException("floor.repo.fail.updateStatusFail");
        }
    
    }
    

    public FloorListDto getFloorsAndServicesByFacilitateId(String header, int facilitateId) {
        List<Object[]> floorsInfoList = new ArrayList<>();
        try {
            floorsInfoList = levelRepository.getFloorsAndServicesByFacilitateId(facilitateId);
            List<FloorDataDto> floors = new ArrayList<>();
            if (floorsInfoList != null && floorsInfoList.size() > 0) {
                floorsInfoList.forEach((obj) -> {
                    FloorDataDto flrDto = LevelMapper.INSTANCE.floorDataToFloorDataDto((FloorData) obj[0]);
                    ServiceGDto serviceGDto = LevelMapper.INSTANCE.serviceToServiceGDto((com.vm.Qsmart.model.Service) obj[1]);
                    if (obj[2] != null) {
                        serviceGDto.setBuildId((Integer) obj[2]);
                        serviceGDto.setBuildEngName((String) obj[3]);
                        serviceGDto.setBuildArbName((String) obj[4]);
                    } else {
                        serviceGDto.setBuildId(0);
                    }
                    Optional<FloorDataDto> matchingObject = floors.stream().
                            filter(floorObj -> Objects.equals(floorObj.getFloorId(), flrDto.getFloorId())).findFirst();
                    FloorDataDto existFlrObj = matchingObject.orElse(null);
                    if (existFlrObj != null) {
                        floors.remove(existFlrObj);
                        Optional<ServiceGDto> matchingServ = existFlrObj.getServices().stream().
                                filter(servObj -> Objects.equals(servObj.getServiceId(), serviceGDto.getServiceId())).
                                findFirst();
                        ServiceGDto existObjServ = matchingServ.orElse(null);
                        if (existObjServ != null) {
                            existFlrObj.getServices().remove(existObjServ);
                            existFlrObj.addServ(existObjServ);
                        } else {
                            existFlrObj.addServ(serviceGDto);
                        }
                        floors.add(existFlrObj);
                    } else {
                        flrDto.addServ(serviceGDto);
                        floors.add(flrDto);
                    }
                });
            }
            return new FloorListDto(floors);
        } catch (Exception e) {
            logger.error("{}Excep:getFloorsAndServicesByFacilitateId:Error:{}", header, ExceptionUtils.getRootCauseMessage(e));
            return new FloorListDto(new ArrayList<>());
        }
    }

    public DepartmentListDto getDeptsWithServicesAndDoctorsByFloorId(String header, int floorId) {

        List<Object[]> deptInfoList = new ArrayList<>();
        List<DepartmentDataDto> departments = new ArrayList<>();
        deptInfoList = levelRepository.getDeptsWithServicesAndDoctorsByFloorId(floorId,LnkMenyTypes.LNK_SERVICE_DOCTOR.getValue(),UserRoles.DOCTOR.getValue(),UserRoles.RESOURCE.getValue());
        
        try {
            if (deptInfoList != null && deptInfoList.size() > 0) {
                for (Object[] obj : deptInfoList) {
                    DepartmentDataDto deptGDto = LevelMapper.INSTANCE.departmentDtoToDepartment((Department) obj[0]);
                    ServiceDataDto serviceGDto = LevelMapper.INSTANCE.serviceDataDtoToService((com.vm.Qsmart.model.Service) obj[1]);
                    DoctorGetDto dctrGDto = null;
                    if (obj[2] != null) {
                        dctrGDto = LevelMapper.INSTANCE.doctorGetDtoToUsers((Users) obj[2]);
                    }

                    Optional<DepartmentDataDto> matchingObject = departments.stream().
                            filter(deptObj -> Objects.equals(deptObj.getDeptId(), deptGDto.getDeptId())).findFirst();
                    DepartmentDataDto existDeptObj = matchingObject.orElse(null);

                    if (existDeptObj != null) {
                        departments.remove(existDeptObj);
                        Optional<ServiceDataDto> matchingService = existDeptObj.getServices().stream().
                                filter(servObj -> Objects.equals(servObj.getServiceId(), serviceGDto.getServiceId())).
                                findFirst();
                        ServiceDataDto existObjServ = matchingService.orElse(null);
                        if (existObjServ != null) {
                            existDeptObj.getServices().remove(existObjServ);
                            if (dctrGDto != null) {
                                existObjServ.addDoctor(dctrGDto);
                            }
                            existDeptObj.addService(existObjServ);
                        } else {
                            if (dctrGDto != null) {
                                serviceGDto.addDoctor(dctrGDto);
                            }
                            existDeptObj.addService(serviceGDto);
                        }
                        departments.add(existDeptObj);
                    } else {
                        if (dctrGDto != null) {
                            serviceGDto.addDoctor(dctrGDto);
                        }
                        deptGDto.addService(serviceGDto);
                        departments.add(deptGDto);
                    }
                }
            }
            return new DepartmentListDto(departments);
        } catch (Exception e) {
            logger.error("{}Excep:getDeptsWithServicesAndDoctorsByFloorId:Error:{}", header, ExceptionUtils.getRootCauseMessage(e));
            return new DepartmentListDto(new ArrayList<>());

        }
    }
}
