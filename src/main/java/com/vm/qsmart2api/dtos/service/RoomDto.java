/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vm.qsmart2api.dtos.service;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import javax.validation.constraints.NotNull;

/**
 *
 * @author sitaram
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class RoomDto {

    private List<RoomCrtDto> rooms;
    
    @ApiModelProperty(required = true, notes = "serviceId should't be empty", example = "1")
    @NotNull(message = "{service.dto.serviceId.notnull}")
    private Integer serviceId;
    
    public Integer getServiceId() {
        return serviceId;
    }

    public void setServiceId(Integer serviceId) {
        this.serviceId = serviceId;
    }
    
    public List<RoomCrtDto> getRooms() {
        return rooms;
    }

    public void setRooms(List<RoomCrtDto> rooms) {
        this.rooms = rooms;
    }
    

}
