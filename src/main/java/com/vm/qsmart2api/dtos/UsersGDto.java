/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vm.qsmart2api.dtos;

import java.util.List;

/**
 *
 * @author Phani
 */
public class UsersGDto {
    
    public List<UserDto> user;

    public List<UserDto> getUser() {
        return user;
    }

    public void setUser(List<UserDto> user) {
        this.user = user;
    }

    public UsersGDto() {
    }

    public UsersGDto(List<UserDto> user) {
        this.user = user;
    }
    
}
