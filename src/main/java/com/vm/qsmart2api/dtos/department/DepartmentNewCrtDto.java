/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vm.qsmart2api.dtos.department;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Administrator
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class DepartmentNewCrtDto {

    @ApiModelProperty(required = true, notes = "Organization id should't be empty", example = "16")
    @NotNull(message = "{dept.dto.orgid.notnull}")
    private Integer orgId;

    @ApiModelProperty(required = true, notes = "Department name should't be empty and size must be 50 characters", example = "Dept1")
    @NotNull(message = "{dept.dto.deptname.notnull}")
    private String deptName;

    @ApiModelProperty(required = true, notes = "Floor id should't be empty", example = "1")
    @NotNull(message = "{floor.dto.idnull}")
    private Integer floorId;

    @ApiModelProperty(required = false, notes = "Department arabic name optional and size must be 100 characters", example = "الطابق الاول")
//    @NotNull(message = "{dept.dto.deptname.notnull}")
    private String deptArbName;

    @ApiModelProperty(required = true, notes = "Department Multiple Token should't be empty", example = "1")
    @NotNull(message = "{dept.dto.dept_Multiple_Token.notnull}")
    private short dept_Multiple_Token;

    @ApiModelProperty(required = true, notes = "Department DeptType  should't be empty", example = "1")
    @NotNull(message = "{dept.dto.dept_Type.notnull}")
    private Short deptType;

//    @ApiModelProperty(required = true, notes = "Department pharmaLocation  should't be empty", example = "Location")
//    @NotNull(message = "{dept.dto.pharma_Location.notnull}")
    private String pharmaLocation;

//    @ApiModelProperty(required = true, notes = "Department pharmaIndex  should't be empty", example = "1")
//    @NotNull(message = "{dept.dto.pharma_Index.notnull}")
    private Integer pharmaIndex;

//    @ApiModelProperty(required = true, notes = "Department pharmaType should't be empty", example = "1")
//    @NotNull(message = "{dept.dto.pharma_Type.notnull}")
    private Integer pharmaType;
    private Integer print_waiting_token;

    public String getDeptArbName() {
        return deptArbName;
    }

    public void setDeptArbName(String deptArbName) {
        this.deptArbName = deptArbName;
    }

    public Integer getOrgId() {
        return orgId;
    }

    public void setOrgId(Integer orgId) {
        this.orgId = orgId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public Integer getFloorId() {
        return floorId;
    }

    public void setFloorId(Integer floorId) {
        this.floorId = floorId;
    }

    public short getDept_Multiple_Token() {
        return dept_Multiple_Token;
    }

    public void setDept_Multiple_Token(short dept_Multiple_Token) {
        this.dept_Multiple_Token = dept_Multiple_Token;
    }

    public String getPharmaLocation() {
        return pharmaLocation;
    }

    public void setPharmaLocation(String pharmaLocation) {
        this.pharmaLocation = pharmaLocation;
    }

    public Short getDeptType() {
        return deptType;
    }

    public void setDeptType(Short deptType) {
        this.deptType = deptType;
    }

    public Integer getPharmaIndex() {
        return pharmaIndex;
    }

    public void setPharmaIndex(Integer pharmaIndex) {
        this.pharmaIndex = pharmaIndex;
    }

    public Integer getPharmaType() {
        return pharmaType;
    }

    public void setPharmaType(Integer pharmaType) {
        this.pharmaType = pharmaType;
    }

    public Integer getPrint_waiting_token() {
        return print_waiting_token;
    }

    public void setPrint_waiting_token(Integer print_waiting_token) {
        this.print_waiting_token = print_waiting_token;
    }

    @Override
    public String toString() {
        return "DepartmentNewCrtDto{" + "orgId=" + orgId + ", deptName=" + deptName + ", floorId=" + floorId + ", deptArbName=" + deptArbName + ", dept_Multiple_Token=" + dept_Multiple_Token + ", deptType=" + deptType + ", pharmaLocation=" + pharmaLocation + ", pharmaIndex=" + pharmaIndex + ", pharmaType=" + pharmaType + ", print_waiting_token=" + print_waiting_token + '}';
    }

}
