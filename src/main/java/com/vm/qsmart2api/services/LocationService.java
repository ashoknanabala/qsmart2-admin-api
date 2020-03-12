///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.vm.qsmart2api.services;
//
//import com.vm.Qsmart.model.TblBranch;
//import com.vm.Qsmart.model.TblLocation;
//import com.vm.qsmart2api.dtos.branch.BranchDto;
//import com.vm.qsmart2api.dtos.location.LocationBranchDto;
//import com.vm.qsmart2api.dtos.location.LocationDto;
//import com.vm.qsmart2api.dtos.location.LocationGetDto;
//import com.vm.qsmart2api.mapper.BranchMapper;
//import com.vm.qsmart2api.mapper.LocationMapper;
//import com.vm.qsmart2api.repository.LocationRepository;
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.Objects;
//import java.util.Optional;
//import javax.persistence.EntityManager;
//import org.apache.commons.lang.exception.ExceptionUtils;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//import static org.hibernate.annotations.common.util.impl.LoggerFactory.logger;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
///**
// *
// * @author Tejasri
// */
//@Service
//public class LocationService {
//
//    private static final Logger logger = LogManager.getLogger(LocationService.class);
//
//    @Autowired
//    LocationRepository locationRepository;
//
//    public void save(TblLocation location) {
//        locationRepository.save(location);
//    }
//
//    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//
//    public void update(int loginId, LocationDto location) {
//        TblLocation lctn = locationRepository.getOne(location.getLocId());
//        TblLocation locatn = LocationMapper.INSTANCE.locationDtoToTblLocation(location);
//        locatn.setUpdatedBy(loginId);
//        locatn.setUpdatedOn(sdf.format(new Date()));
//        locatn.setLocNameAr(location.getLocNameAr());
//        locatn.setLocNameEn(location.getLocNameEn());
//        locationRepository.save(locatn);
//    }
//
//    public LocationBranchDto getLocationsWithBranches(int loginId) {
//        logger.info(">>:loginId:[{}]", loginId);
//        try {
//            List<Object[]> list = locationRepository.getLocationWithBranches();
//            System.out.println("00000---->" + list.size());
//            List<LocationGetDto> locdto = new ArrayList<>();
//            if (list != null && list.size() > 0) {
//                for (Object[] obj : list) {
//                    LocationGetDto loctns = LocationMapper.INSTANCE.locnDtoToTblLocation((TblLocation) obj[0]);
//                    BranchDto bDto = BranchMapper.INSTANCE.tblLocationToLocationDto((TblBranch) obj[1]);
//
//                    Optional<LocationGetDto> matchingObject = locdto.stream().
//                            filter(locationObj -> Objects.equals(locationObj.getLocId(), loctns.getLocId())).findFirst();
//                    LocationGetDto existLcnObj = matchingObject.orElse(null);
//                    if (existLcnObj != null) {
//                        locdto.remove(existLcnObj);
//                        BranchDto matchingBranch = existLcnObj.getBranches().stream().
//                                filter(brnchObj -> Objects.equals(brnchObj.getBranchId(), bDto.getBranchId())).
//                                findFirst().orElse(null);
//                        // BranchDto existObjBrnch = matchingDept.orElse(null);
//                        if (matchingBranch != null) {
//                            existLcnObj.getBranches().remove(matchingBranch);
//                            existLcnObj.addBranch(matchingBranch);
//                        } else {
//                            existLcnObj.addBranch(bDto);
//                        }
//                        locdto.add(existLcnObj);
//                    } else {
//                        loctns.addBranch(bDto);
//                        locdto.add(loctns);
//                    }
//                }
//            }
//            return new LocationBranchDto(locdto);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            logger.error("{}Excep:getFloorsAndServicesByFacilitateId:Error:{}", ExceptionUtils.getRootCauseMessage(e));
//
//            return new LocationBranchDto(new ArrayList<>());
//        }
//    }
//
//    public List<LocationGetDto> getAllLocationsWithBranches2() {
//        List<Object[]> obj = locationRepository.getLocationWithBranches2();
//        List<LocationGetDto> locBranchdto = new ArrayList<>();
//
//        if (obj != null && obj.size() > 0) {
//            try {
//                for (Object[] obj1 : obj) {
//                    LocationGetDto matchingObject = locBranchdto.stream().
//                            filter(locObj -> Objects.equals(locObj.getLocId(), obj1[0])).findFirst().orElse(null);
//                    if (matchingObject != null) {
//                        locBranchdto.remove(matchingObject);
//                        BranchDto bDto = BranchMapper.INSTANCE.tblLocationToLocationDto((TblBranch) obj1[3]);
//                        matchingObject.addBranch(bDto);
//                        locBranchdto.add(matchingObject);
//                    } else {
//                        LocationGetDto locationBranchDto = new LocationGetDto();
//                        locationBranchDto.setLocId((Integer) obj1[0]);
//                        locationBranchDto.setLocNameEn((String) obj1[1]);
//                        locationBranchDto.setLocNameAr((String) obj1[2]);
//                        BranchDto bDto = BranchMapper.INSTANCE.tblLocationToLocationDto((TblBranch) obj1[3]);
//                        locationBranchDto.addBranch(bDto);
//                        locBranchdto.add(locationBranchDto);
//                    }
//                }
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        } else {
//            List<LocationGetDto> locBranchdto1 = new ArrayList<>();
//            return locBranchdto1;
//        }
//        return locBranchdto;
//
//    }
//}
