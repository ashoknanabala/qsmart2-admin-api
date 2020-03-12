/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vm.qsmart2api.dtos;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ashok
 */
public class LocationBranchDto {
    
    private Integer locId;
    private String locNameEn;
    private String locNameAr;
    List<BranchDto> branchDto= new ArrayList<>();

  public void addBranch(BranchDto branchdto){
      branchDto.add(branchdto);
  }

    public Integer getLocId() {
        return locId;
    }

    public void setLocId(Integer locId) {
        this.locId = locId;
    }

    public String getLocNameEn() {
        return locNameEn;
    }

    public void setLocNameEn(String locNameEn) {
        this.locNameEn = locNameEn;
    }

    public String getLocNameAr() {
        return locNameAr;
    }

    public void setLocNameAr(String locNameAr) {
        this.locNameAr = locNameAr;
    }

    public List<BranchDto> getBranchDto() {
        return branchDto;
    }

    public void setBranchDto(List<BranchDto> branchDto) {
        this.branchDto = branchDto;
    }
    
    
    
}
