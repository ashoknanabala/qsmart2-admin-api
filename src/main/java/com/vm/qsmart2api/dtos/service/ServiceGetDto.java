/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vm.qsmart2api.dtos.service;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

/**
 *
 * @author Phani
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ServiceGetDto {
    
    public List<ServiceGDto> services;

    public List<ServiceGDto> getServices() {
        return services;
    }

    public void setServices(List<ServiceGDto> services) {
        this.services = services;
    }

    @Override
    public String toString() {
        return "ServiceGetDto{" + "services=" + services + '}';
    }

    public ServiceGetDto() {
    }

    public ServiceGetDto(List<ServiceGDto> services) {
        this.services = services;
    }
    
    
}
