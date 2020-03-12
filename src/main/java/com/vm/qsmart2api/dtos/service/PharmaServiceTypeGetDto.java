/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vm.qsmart2api.dtos.service;

import java.util.List;

/**
 *
 * @author swathi
 */
public class PharmaServiceTypeGetDto {

    private List<PharmaServiceTypeDto> services;

    public PharmaServiceTypeGetDto() {
    }

    public List<PharmaServiceTypeDto> getServices() {
        return services;
    }

    public void setServices(List<PharmaServiceTypeDto> services) {
        this.services = services;
    }

    public PharmaServiceTypeGetDto(List<PharmaServiceTypeDto> services) {
        this.services = services;
    }

}
