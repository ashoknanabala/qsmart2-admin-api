///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.vm.qsmart2api.dtos.usersdto;
//
//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//import com.vm.Qsmart.dto.roles.RoleDto;
//import io.swagger.annotations.ApiModelProperty;
//import java.util.List;
//
//import javax.validation.constraints.NotNull;
//
///**
// *
// * @author VMHDCLAP21
// */
//@JsonIgnoreProperties(ignoreUnknown = true)
//public class UserCreateDto {
//
//    @ApiModelProperty(required = true, notes = "login should not be empty", example = "xxxx@xx.com")
//    @NotNull(message = "{user.dto.nulllogin}")
//    private String login;
//
//    @ApiModelProperty(required = true, notes = "password should not be empty", example = "xxxx")
//    @NotNull(message = "{user.dto.nullpswd}")
//    private String hashedPassword;
//
//    @ApiModelProperty(required = true, notes = "firstname should not be empty", example = "vetra")
//    @NotNull(message = "{user.dto.nullfirst}")
//    private String firstname;
//
//    @ApiModelProperty(required = true, notes = "lastname should not be empty", example = "mind")
//    @NotNull(message = "{user.dto.nulllast}")
//    private String lastname;
//
////    @ApiModelProperty(required = true, notes = "contactNo should not be empty", example = "1234567")
////    @NotNull(message = "{user.dto.nullnumber}")
//    private String contactNo;
//
////    @ApiModelProperty(required = false, notes = "email should not be empty", example = "xxxx@xx.com")
//    private String emailId;
//
//    @ApiModelProperty(required = true, notes = "orgId should not be empty")
//    @NotNull(message = "{user.dto.nullorg}")
//    private int orgId;
//
//    @ApiModelProperty(required = false, notes = "levelId should not be empty")
//    private int levelId;
//
//    @ApiModelProperty(required = false, notes = "drSegmentId should not be empty")
//    private String drSegmentId;
//
//    private Short manualToken = 0;
//
//    @ApiModelProperty(required = false, notes = "depts should not be empty")
//    private List<Integer> depts;
//
//    @ApiModelProperty(required = false, notes = "services should not be empty")
//    private List<Integer> services;
//
//    @ApiModelProperty(required = false, notes = "doctors should not be empty")
//    private List<Integer> doctors;
//
//    @ApiModelProperty(required = false, notes = "roles should not be empty")
//    private List<RoleDto> roles;
//
//    private char userType;
//    
//    private String medicalService;
//
//    public char getUserType() {
//        return userType;
//    }
//
//    public void setUserType(char userType) {
//        this.userType = userType;
//    }
//
//    public String getLogin() {
//        return login;
//    }
//
//    public void setLogin(String login) {
//        this.login = login;
//    }
//
//    public String getHashedPassword() {
//        return hashedPassword;
//    }
//
//    public void setHashedPassword(String hashedPassword) {
//        this.hashedPassword = hashedPassword;
//    }
//
//    public String getFirstname() {
//        return firstname;
//    }
//
//    public void setFirstname(String firstname) {
//        this.firstname = firstname;
//    }
//
//    public String getDrSegmentId() {
//        return drSegmentId;
//    }
//
//    public void setDrSegmentId(String drSegmentId) {
//        this.drSegmentId = drSegmentId;
//    }
//
//    public String getLastname() {
//        return lastname;
//    }
//
//    public void setLastname(String lastname) {
//        this.lastname = lastname;
//    }
//
//    public String getContactNo() {
//        return contactNo;
//    }
//
//    public void setContactNo(String contactNo) {
//        this.contactNo = contactNo;
//    }
//
//    public int getLevelId() {
//        return levelId;
//    }
//
//    public void setLevelId(int levelId) {
//        this.levelId = levelId;
//    }
//
//    public List<Integer> getDepts() {
//        return depts;
//    }
//
//    public void setDepts(List<Integer> depts) {
//        this.depts = depts;
//    }
//
//    public List<Integer> getServices() {
//        return services;
//    }
//
//    public void setServices(List<Integer> services) {
//        this.services = services;
//    }
//
//    public List<Integer> getDoctors() {
//        return doctors;
//    }
//
//    public void setDoctors(List<Integer> doctors) {
//        this.doctors = doctors;
//    }
//
//    public String getEmailId() {
//        return emailId;
//    }
//
//    public void setEmailId(String emailId) {
//        this.emailId = emailId;
//    }
//
//    public List<RoleDto> getRoles() {
//        return roles;
//    }
//
//    public void setRoles(List<RoleDto> roles) {
//        this.roles = roles;
//    }
//
//    public int getOrgId() {
//        return orgId;
//    }
//
//    public void setOrgId(int orgId) {
//        this.orgId = orgId;
//    }
//
//    public Short getManualToken() {
//        return manualToken;
//    }
//
//    public void setManualToken(Short manualToken) {
//        this.manualToken = manualToken;
//    }
//
//    public String getMedicalService() {
//        return medicalService;
//    }
//
//    public void setMedicalService(String medicalService) {
//        this.medicalService = medicalService;
//    }
//
//    @Override
//    public String toString() {
//        return "UserCreateDto{" + "login=" + login + ", hashedPassword=" + hashedPassword + ", firstname=" + firstname + ", lastname=" + lastname + ", contactNo=" + contactNo + ", emailId=" + emailId + ", orgId=" + orgId + ", levelId=" + levelId + ", drSegmentId=" + drSegmentId + ", manualToken=" + manualToken + ", depts=" + depts + ", services=" + services + ", doctors=" + doctors + ", roles=" + roles + ", userType=" + userType + ", medicalService=" + medicalService + '}';
//    }
//   
//
//}
