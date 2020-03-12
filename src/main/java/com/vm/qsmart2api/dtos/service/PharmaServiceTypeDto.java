/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vm.qsmart2api.dtos.service;

/**
 *
 * @author swathi
 */
public class PharmaServiceTypeDto {
  
    private Integer psTypeId;
   
    private String name;
    
    private String typeCode;
    
    private Integer pharmaType;
   
    private Integer dhlService;
  
    private Integer menuType;

    public Integer getPsTypeId() {
        return psTypeId;
    }

    public void setPsTypeId(Integer psTypeId) {
        this.psTypeId = psTypeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name.trim();
    }

    public String getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }

    public Integer getPharmaType() {
        return pharmaType;
    }

    public void setPharmaType(Integer pharmaType) {
        this.pharmaType = pharmaType;
    }

    public Integer getDhlService() {
        return dhlService;
    }

    public void setDhlService(Integer dhlService) {
        this.dhlService = dhlService;
    }

    public Integer getMenuType() {
        return menuType;
    }

    public void setMenuType(Integer menuType) {
        this.menuType = menuType;
    }

    @Override
    public String toString() {
        return "PharmaServiceTypeDto{" + "psTypeId=" + psTypeId + ", name=" + name + ", typeCode=" + typeCode + ", pharmaType=" + pharmaType + ", dhlService=" + dhlService + ", menuType=" + menuType + '}';
    }
     
}
