/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vm.qsmart2api.dtos.floor;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.vm.qsmart2api.dtos.service.ServiceDataDto;
import com.vm.qsmart2api.dtos.service.ServiceGDto;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author VMLAP25
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class FloorDataDto {

    private Integer floorId;
    private String floorName;
    private int orgId;
    private String floorArbName;

    private List<ServiceGDto> services = new ArrayList<>();

    public void addServ(ServiceGDto service) {
        services.add(service);
    }

    public Integer getFloorId() {
        return floorId;
    }

    public void setFloorId(Integer floorId) {
        this.floorId = floorId;
    }

    public String getFloorName() {
        return floorName;
    }

    public void setFloorName(String floorName) {
        this.floorName = floorName;
    }

    public int getOrgId() {
        return orgId;
    }

    public void setOrgId(int orgId) {
        this.orgId = orgId;
    }

    public String getFloorArbName() {
        return floorArbName;
    }

    public void setFloorArbName(String floorArbName) {
        this.floorArbName = floorArbName;
    }

    public List<ServiceGDto> getServices() {
        return services;
    }

    public void setServices(List<ServiceGDto> services) {
        this.services = services;
    }

    @Override
    public String toString() {
        return "FloorDataDto{" + "floorId=" + floorId + ", floorName=" + floorName + ", orgId=" + orgId + ", floorArbName=" + floorArbName + ", services=" + services + '}';
    }

}
