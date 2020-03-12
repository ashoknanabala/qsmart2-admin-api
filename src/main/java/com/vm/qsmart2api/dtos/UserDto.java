/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vm.qsmart2api.dtos;

/**
 *
 * @author Phani
 */
public class UserDto {
   
    public String userName;
    public String email;
    public String moibileNo;

    public UserDto() {
    }

    public UserDto(String userName, String email, String moibileNo) {
        this.userName = userName;
        this.email = email;
        this.moibileNo = moibileNo;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMoibileNo() {
        return moibileNo;
    }

    public void setMoibileNo(String moibileNo) {
        this.moibileNo = moibileNo;
    }

    
}
