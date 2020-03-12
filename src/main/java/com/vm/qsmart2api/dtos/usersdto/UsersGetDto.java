/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vm.qsmart2api.dtos.usersdto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

/**
 *
 * @author Phani
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class UsersGetDto {
    
    private List<UsersGDto> users;

    public List<UsersGDto> getUsers() {
        return users;
    }

    public void setUsers(List<UsersGDto> users) {
        this.users = users;
    }

    public UsersGetDto() {
    }

    public UsersGetDto(List<UsersGDto> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "UsersGetDto{" + "users=" + users + '}';
    }
    
    
    
    
}
