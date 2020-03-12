/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vm.qsmart2api.dtos.usersdto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.vm.qsmart2api.dtos.department.DeptDto;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.validation.constraints.Size;

/**
 *
 * @author SOMANADH PHANI
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class LevelDto {
private Integer floorId;

    private String floorName;

    private String floorArbName;

    private List<UsersGDto> users =new ArrayList<>();

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

    public String getFloorArbName() {
        return floorArbName;
    }

    public void setFloorArbName(String floorArbName) {
        this.floorArbName = floorArbName;
    }

    public List<UsersGDto> getUsers() {
        return users;
    }

    public void setUsers(List<UsersGDto> users) {
        this.users = users;
    }

    public void addUser(UsersGDto existuserdts) {
     users.add(existuserdts);
    }
}
