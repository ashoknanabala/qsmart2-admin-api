/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vm.qsmart2api.dtos;

import java.util.List;

/**
 *
 * @author Ashok
 */
public class LocationBranchDtos {

    List<LocationDto> locationDto;
      List<BranchDto> branchDto;

    public List<LocationDto> getLocationDto() {
        return locationDto;
    }

    public void setLocationDto(List<LocationDto> locationDto) {
        this.locationDto = locationDto;
    }

    public List<BranchDto> getBranchDto() {
        return branchDto;
    }

    public void setBranchDto(List<BranchDto> branchDto) {
        this.branchDto = branchDto;
    }
  

}
