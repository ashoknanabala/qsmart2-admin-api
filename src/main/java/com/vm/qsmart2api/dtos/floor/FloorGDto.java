/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vm.qsmart2api.dtos.floor;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.vm.qsmart2api.dtos.department.DepartmentGDto;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Phani
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class FloorGDto {

    private Integer floorId;
    private String floorName;
    private int orgId;
    private String floorArbName;
    private int buildId;
    private String buildName;
    private String buildArbName;

    private List<DepartmentGDto> departments = new ArrayList<>();

    public int getBuildId() {
        return buildId;
    }

    public void setBuildId(int buildId) {
        this.buildId = buildId;
    }

    public String getBuildName() {
        return buildName;
    }

    public void setBuildName(String buildName) {
        this.buildName = buildName;
    }

    public String getBuildArbName() {
        return buildArbName;
    }

    public void setBuildArbName(String buildArbName) {
        this.buildArbName = buildArbName;
    }
    
    public void addDept(DepartmentGDto dept) {
        departments.add(dept);
    }

    public String getFloorArbName() {
        return floorArbName;
    }

    public void setFloorArbName(String floorArbName) {
        this.floorArbName = floorArbName;
    }

    public List<DepartmentGDto> getDepartments() {
        return departments;
    }

    public void setDepartments(List<DepartmentGDto> departments) {
        this.departments = departments;
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

    @Override
    public String toString() {
        return "FloorGDto{" + "floorId=" + floorId + ", floorName=" + floorName + ", orgId=" + orgId + ", departments=" + departments + '}';
    }

}
