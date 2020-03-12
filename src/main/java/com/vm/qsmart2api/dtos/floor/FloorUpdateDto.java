/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vm.qsmart2api.dtos.floor;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;

/**
 *
 * @author VMHDCLAP21
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class FloorUpdateDto {

    @ApiModelProperty(required = true, notes = "Floor Id should't be empty ", example = "1")
    @NotNull(message = "{floor.dto.idnull}")
    private Integer floorId;

    @ApiModelProperty(required = true, notes = "Floor name should't be empty and size must be 100 characters", example = "First floor")
    @NotNull(message = "{floor.dto.floornull}")
    private String floorName;

    @ApiModelProperty(required = true, notes = "Status should't be empty ", example = "0")
    @NotNull(message = "{floor.dto.statusnull}")
    private Short status;

    @ApiModelProperty(required = true, notes = "organization should't be empty ", example = "1")
    @NotNull(message = "{floor.dto.orgIdnull}")
    private int orgId;

    @ApiModelProperty(required = false, notes = "Floor name optional and size must be 100 characters", example = "الطابق الاول")
//    @NotNull(message = "{floor.dto.floornull}")
    private String floorArbName;

    public String getFloorArbName() {
        return floorArbName;
    }

    public void setFloorArbName(String floorArbName) {
        this.floorArbName = floorArbName;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
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
        return "FloorUpdateDto{" + "floorId=" + floorId + ", floorName=" + floorName + ", status=" + status + ", orgId=" + orgId + ", floorArbName=" + floorArbName + '}';
    }

}
