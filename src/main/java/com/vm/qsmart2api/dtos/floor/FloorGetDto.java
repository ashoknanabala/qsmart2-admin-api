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
 * @author Phani
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class FloorGetDto {
    
    
    private List<FloorGDto> floors;

    public FloorGetDto() {
    }

    public FloorGetDto(List<FloorGDto> floors) {
        this.floors = floors;
    }
    
    public List<FloorGDto> getFloors() {
        return floors;
    }

    public void setFloors(List<FloorGDto> floors) {
        this.floors = floors;
    }

    @Override
    public String toString() {
        return "FloorGetDto{" + "floors=" + floors + '}';
    }
    
}
