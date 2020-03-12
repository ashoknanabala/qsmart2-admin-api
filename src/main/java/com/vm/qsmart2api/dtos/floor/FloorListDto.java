/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vm.qsmart2api.dtos.floor;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

/**
 *
 * @author sitaram
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class FloorListDto {

    private List<FloorDataDto> floors;

    public FloorListDto(List<FloorDataDto> floors) {
        this.floors = floors;
    }

    public FloorListDto() {
    }

  

    public List<FloorDataDto> getFloors() {
        return floors;
    }

    public void setFloors(List<FloorDataDto> floors) {
        this.floors = floors;
    }

    @Override
    public String toString() {
        return "FloorListDto{" + "floors=" + floors + '}';
    }

}
