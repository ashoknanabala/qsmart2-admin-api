/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vm.Qsmart.dto.usersdto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.vm.qsmart2api.dtos.Response;
import com.vm.qsmart2api.dtos.UsersGDto;

/**
 *
 * @author VMHDCLAP21
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class LoginResponseDto extends Response {

    private UsersGDto usersGDto;

    public LoginResponseDto() {
    }

    public LoginResponseDto(UsersGDto usersGDto) {
        this.usersGDto = usersGDto;
    }

    public LoginResponseDto( boolean status, String messages,UsersGDto usersGDto) {
        super(status, messages);
        this.usersGDto = usersGDto;
    }

    public LoginResponseDto(boolean status, String messages) {
        super(status, messages);
    }

    public UsersGDto getUsersGDto() {
        return usersGDto;
    }

    public void setUsersGDto(UsersGDto usersGDto) {
        this.usersGDto = usersGDto;
    }

    @Override
    public String toString() {
        return "LoginResponseDto{" + "usersGDto=" + usersGDto + '}';
    }

}
