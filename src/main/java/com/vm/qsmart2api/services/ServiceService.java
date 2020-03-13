/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vm.qsmart2api.services;

import com.vm.Qsmart.model.Service;
import com.vm.qsmart2api.dtos.ServiceGDto;
import com.vm.qsmart2api.dtos.ServiceGetDto;
import com.vm.qsmart2api.mapper.ServiceMapper;
import com.vm.qsmart2api.repository.ServiceRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;



/**
 *
 * @author Ashok
 */
public class ServiceService {
    
    
    @Autowired
    ServiceRepository serivceRepository;

    public void updateStatusInDb(String header, int loginId, int serviceId, short status) {
    serivceRepository.update(serviceId, status);
    }

    public ServiceGetDto getServicesByDeptId(int deptId) {
      List<Object[]> obj=  serivceRepository.getServicesByDeptId(deptId);
      List<ServiceGDto> servicesList = new ArrayList<>();
               for(Object[] obj1:obj){
               ServiceGDto serviceGDto=  ServiceMapper.INSTANCE.serivceToServiceGDto((Service) obj1[0]);
              serviceGDto.setFloorName((String) obj1[1]);
                    serviceGDto.setDeptName((String) obj1[2]);
                    serviceGDto.setBuildId((Integer) obj1[3]);
                    serviceGDto.setBuildEngName((String) obj1[4]);
                    serviceGDto.setBuildArbName((String) obj1[5]);
                    servicesList.add(serviceGDto);
               }
        return new ServiceGetDto(servicesList);
    }

    public Page<Service> getServicesByaPagenation(Pageable pageRequest) {
       return serivceRepository.findAllByPagenation(pageRequest);
    }
    
}
