/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vm.qsmart2api.dtos.usersdto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.vm.qsmart2api.dtos.roles.RoleDto;
//import com.vm.qsmart2api.dto.roles.RoleDto;
import java.util.List;

/**
 *
 * @author VMHDCLAP21
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class DoctorGetDto {

    private Integer userId;
    private String login;
    private String firstname;
    private String lastname;
    private String contactNo;
    private short isactive;
    private String drSegmentId;
    private String medicalService;

    private List<RoleDto> roles;

    public DoctorGetDto() {
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
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

    public short getIsactive() {
        return isactive;
    }

    public void setIsactive(short isactive) {
        this.isactive = isactive;
    }

    public List<RoleDto> getRoles() {
        return roles;
    }

    public void setRoles(List<RoleDto> roles) {
        this.roles = roles;
    }

    public String getDrSegmentId() {
        return drSegmentId;
    }

    public void setDrSegmentId(String drSegmentId) {
        this.drSegmentId = drSegmentId;
    }

    public String getMedicalService() {
        return medicalService;
    }

    public void setMedicalService(String medicalService) {
        this.medicalService = medicalService;
    }

    @Override
    public String toString() {
        return "DoctorGetDto{" + "userId=" + userId + ", login=" + login + ", firstname=" + firstname + ", lastname=" + lastname + ", contactNo=" + contactNo + ", isactive=" + isactive + ", drSegmentId=" + drSegmentId + ", medicalService=" + medicalService + ", roles=" + roles + '}';
    }
  

}
