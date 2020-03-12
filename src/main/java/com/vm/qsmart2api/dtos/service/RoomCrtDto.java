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
public class RoomCrtDto {

    @ApiModelProperty(required = true, notes = "roomType should't be empty", example = "1")
    @NotNull(message = "{service.dto.rooms.notnull}")
    private Integer roomType;

    @ApiModelProperty(required = false, notes = "rooms should't be empty")
    @NotNull(message = "{service.dto.rooms.notnull}")
    private List<Integer> rooms;

    public Integer getRoomType() {
        return roomType;
    }

    public void setRoomType(Integer roomType) {
        this.roomType = roomType;
    }

    public List<Integer> getRooms() {
        return rooms;
    }

    public void setRooms(List<Integer> rooms) {
        this.rooms = rooms;
    }

    public RoomCrtDto() {
    }

    @Override
    public String toString() {
        return "RoomCrtDto{" + "roomType=" + roomType + ", rooms=" + rooms + '}';
    }

  


}
