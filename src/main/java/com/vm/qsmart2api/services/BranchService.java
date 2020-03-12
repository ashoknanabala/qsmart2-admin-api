///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.vm.qsmart2api.services;
//
//import com.vm.Qsmart.model.TblBranch;
//import com.vm.qsmart2api.dtos.BranchDto;
//import com.vm.qsmart2api.dtos.LocationBranchDto;
//import com.vm.qsmart2api.mapper.BranchMapper;
//import com.vm.qsmart2api.repository.BranchRepository;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.Objects;
//import java.util.Optional;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
///**
// *
// * @author Ashok
// */
//@Service
//public class BranchService {
//
//    private static final Logger logger = LogManager.getLogger(BranchService.class);
//
//    @Autowired
//    private BranchRepository branchRepository;
//
//    BranchMapper branchMapper = BranchMapper.INSTANCE;
//
//    public void save(TblBranch branch) {
//        try {
//            branchRepository.save(branch);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//    }
//
//    public Optional<TblBranch> findById(int id) {
//        return branchRepository.findById(id);
//    }
//
//    public List<TblBranch> findAllBranch() {
//        return branchRepository.findAll();
//    }
//
//    public LocationBranchDto getDtos(int locId) {
//        List<Object[]> obj = branchRepository.getBranchesByLocId(locId);
//        System.out.println("asasasassas" + obj.get(0).toString());
//        LocationBranchDto locationBranchDto = new LocationBranchDto();
//        List<BranchDto> bDtos = new ArrayList<BranchDto>();
//        for (Object[] obj1 : obj) {
//            BranchDto bDto = branchMapper.branchToBranchDto((TblBranch) obj1[3]);
//            System.out.println("asasasassas" + bDto.getBranchNameAr());
//            locationBranchDto.setLocId((Integer) obj1[0]);
//            locationBranchDto.setLocNameEn((String) obj1[1]);
//            locationBranchDto.setLocNameAr((String) obj1[2]);
//            bDtos.add(bDto);
//        }
//        locationBranchDto.setBranchDto(bDtos);
//        return locationBranchDto;
//    }
//
//    public List<LocationBranchDto> getAllBranchs() {
//        System.out.println(">>>>>>>>>1"+"first");
////        List<Object[]> obj = branchRepository.getBranchesByLoc();
////        Map<String, LocationBranchDto> map = new HashMap<String, LocationBranchDto>();
////        for (Object[] obj1 : obj) {
////            String string = obj1[1].toString();
////            System.out.println(">>>>>>" + string);
////            if (map.containsKey(string)) {
////                BranchDto bDto = branchMapper.branchToBranchDto((TblBranch) obj1[3]);
////                             	LocationBranchDto dto = map.get(string);
////                        dto.addBranch(bDto);
////            } else {
////                LocationBranchDto locationBranchDto = new LocationBranchDto();
////                BranchDto bDto = branchMapper.branchToBranchDto((TblBranch) obj1[3]);
////                locationBranchDto.setLocId((Integer) obj1[0]);
////                locationBranchDto.setLocNameEn((String) obj1[1]);
////                locationBranchDto.setLocNameAr((String) obj1[2]);
////                locationBranchDto.addBranch(bDto);
////                
////                map.put(obj1[1].toString(), locationBranchDto);
////            }
////
////        }
////        return new ArrayList<LocationBranchDto>(map.values());
//
//        List<Object[]> obj = branchRepository.getBranchesByLoc();
//        List<LocationBranchDto> locBranchdto = new ArrayList<>();
//        
//        if (obj != null && obj.size() > 0) {
//            try{
//        for (Object[] obj1 : obj) {
//            LocationBranchDto matchingObject = locBranchdto.stream().
//                    filter(locObj -> Objects.equals(locObj.getLocId(), obj1[0])).findFirst().orElse(null);
//            if (matchingObject != null) {
//                locBranchdto.remove(matchingObject);
//                BranchDto bDto = branchMapper.branchToBranchDto((TblBranch) obj1[3]);
//                matchingObject.addBranch(bDto);
//                locBranchdto.add(matchingObject);
//            } else {
//                LocationBranchDto locationBranchDto = new LocationBranchDto();
//                locationBranchDto.setLocId((Integer) obj1[0]);
//                locationBranchDto.setLocNameEn((String) obj1[1]);
//                locationBranchDto.setLocNameAr((String) obj1[2]);
//                BranchDto bDto = branchMapper.branchToBranchDto((TblBranch) obj1[3]);
//                locationBranchDto.addBranch(bDto);
//                locBranchdto.add(locationBranchDto);
//            }
//        }
//            }catch(Exception e){
//             e.printStackTrace();
//            }
//        }else{
//            List<LocationBranchDto> locBranchdto1 = new ArrayList<>();
//              return locBranchdto1;
//        }
//        return locBranchdto;
//    
//    }
//
//}
