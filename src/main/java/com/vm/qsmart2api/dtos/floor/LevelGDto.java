/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vm.qsmart2api.dtos.floor;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 *
 * @author VMHDCLAP21
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class LevelGDto {

    private Integer floorId;
    private String floorName;
    private Short status;
    private String floorArbName;
    
      private int buildId;
    private String buildEngName;
    private String buildArbName;

    public String getFloorArbName() {
        return floorArbName;
    }

    public void setFloorArbName(String floorArbName) {
        this.floorArbName = floorArbName;
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

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public int getBuildId() {
        return buildId;
    }

    public void setBuildId(int buildId) {
        this.buildId = buildId;
    }


    public String getBuildEngName() {
        return buildEngName;
    }

    public void setBuildEngName(String buildEngName) {
        this.buildEngName = buildEngName;
    }

    public String getBuildArbName() {
        return buildArbName;
    }

    public void setBuildArbName(String buildArbName) {
        this.buildArbName = buildArbName;
    }

    
    

}
