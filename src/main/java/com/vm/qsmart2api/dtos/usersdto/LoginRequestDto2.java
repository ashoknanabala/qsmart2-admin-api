/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vm.qsmart2api.dtos.usersdto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;

/**
 *
 * @author VMHDCLAP21
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class LoginRequestDto2 {

    @ApiModelProperty(required = true, notes = "Email should not be empty  ", example = "xxx@xx.com")
    @NotNull(message = "{login.dto.notnull}")
    private String login;

//    @ApiModelProperty(required = true, notes = "Password should not be empty ", example = "123456")
//    @NotNull(message = "{password.dto.notnull}")
    //   private String password;
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
    @Override
    public String toString() {
        return "LoginRequestDto2{" + "login=" + login + '}';
    }

}
