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
public class ProfileUpdateDto {

    @ApiModelProperty(required = true, notes = "login should not be empty", example = "33")
    @NotNull(message = "{user.dto.nulluserid}")
    private Integer userId;

    @ApiModelProperty(required = true, notes = "login should not be empty", example = "vectra")
    @NotNull(message = "{user.dto.nullfirst}")
    private String firstname;

    @ApiModelProperty(required = true, notes = "login should not be empty", example = "mind")
    @NotNull(message = "{user.dto.nulllast}")
    private String lastname;

    @ApiModelProperty(required = true, notes = "login should not be empty", example = "1234567")
    @NotNull(message = "{user.dto.nullnumber}")
    private String contactNo;

    @ApiModelProperty(required = true, notes = "language should not be empty", example = "en")
    @NotNull(message = "{user.dto.nulllanguage}")
    private String language;
    
    @ApiModelProperty(required = true, notes = "currentProfile should not be empty", example = "1")
    private Short currentProfile;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Short getCurrentProfile() {
        return currentProfile;
    }

    public void setCurrentProfile(Short currentProfile) {
        this.currentProfile = currentProfile;
    }

    @Override
    public String toString() {
        return "ProfileUpdateDto{" + "userId=" + userId + ", firstname=" + firstname + ", lastname=" + lastname + ", contactNo=" + contactNo + ", language=" + language + ", currentProfile=" + currentProfile + '}';
    }
    
    

   
    
}
