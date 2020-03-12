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
//import javax.validation.constraints.NotNull;
//
///**
// *
// * @author VMHDCLAP21
// */
//@JsonIgnoreProperties(ignoreUnknown = true)
//public class UserUpdateDto {
//
//    @ApiModelProperty(required = true, notes = "userId should not be empty", example = "33")
//    @NotNull(message = "{user.dto.nulluserid}")
//    private Integer userId;
//
//    @ApiModelProperty(required = true, notes = "login should not be empty", example = "xxxx@xx.com")
//    @NotNull(message = "{user.dto.nulllogin}")
//    private String login;
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
//    @ApiModelProperty(required = false, notes = "depts should not be empty")
//    private List<Integer> depts;
//
//    @ApiModelProperty(required = false, notes = "services should not be empty")
//    private List<Integer> services;
//
////    @ApiModelProperty(required = false, notes = "rooms should not be empty")
////    private List<Integer> rooms;
//    @ApiModelProperty(required = false, notes = "doctors should not be empty")
//    private List<Integer> doctors;
//
//    @ApiModelProperty(required = false, notes = "roles should not be empty")
//    private List<RoleDto> roles;
//
//    @ApiModelProperty(required = false, notes = "startTime should not be empty", example = "10:00:00")
//    private String startTime;
//
//    @ApiModelProperty(required = false, notes = "endTime should not be empty", example = "12:00:00")
//    private String endTime;
//
//    @ApiModelProperty(required = false, notes = "Language is optional", example = "en")
//    private String language;
//
//    @ApiModelProperty(required = true, notes = "isactive should not be empty", example = "1")
//    @NotNull(message = "{user.dto.nullisactive}")
//    private Short isactive;
//    
////    @ApiModelProperty(required = false, notes = "emailId should not be empty", example = "xxx@xx.com")
//    private String emailId;
//    
//     private Short manualToken=0;
//     
//      private String medicalService;
//
//    public String getDrSegmentId() {
//        return drSegmentId;
//    }
//
//    public void setDrSegmentId(String drSegmentId) {
//        this.drSegmentId = drSegmentId;
//    }
//    
//    
//
//    public String getEmailId() {
//        return emailId;
//    }
//
//    public void setEmailId(String emailId) {
//        this.emailId = emailId;
//    }
//    
//    public Short getIsactive() {
//        return isactive;
//    }
//
//    public void setIsactive(Short isactive) {
//        this.isactive = isactive;
//    }
//
//    public String getLanguage() {
//        return language;
//    }
//
//    public void setLanguage(String language) {
//        this.language = language;
//    }
//
//    public Integer getUserId() {
//        return userId;
//    }
//
//    public void setUserId(Integer userId) {
//        this.userId = userId;
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
//    public String getFirstname() {
//        return firstname;
//    }
//
//    public void setFirstname(String firstname) {
//        this.firstname = firstname;
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
////    public List<Integer> getRooms() {
////        return rooms;
////    }
////
////    public void setRooms(List<Integer> rooms) {
////        this.rooms = rooms;
////    }
//    public List<Integer> getDoctors() {
//        return doctors;
//    }
//
//    public void setDoctors(List<Integer> doctors) {
//        this.doctors = doctors;
//    }
//
//    public String getStartTime() {
//        return startTime;
//    }
//
//    public void setStartTime(String startTime) {
//        this.startTime = startTime;
//    }
//
//    public String getEndTime() {
//        return endTime;
//    }
//
//    public void setEndTime(String endTime) {
//        this.endTime = endTime;
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
//        return "UserUpdateDto{" + "userId=" + userId + ", login=" + login + ", firstname=" + firstname + ", lastname=" + lastname + ", contactNo=" + contactNo + ", orgId=" + orgId + ", levelId=" + levelId + ", drSegmentId=" + drSegmentId + ", depts=" + depts + ", services=" + services + ", doctors=" + doctors + ", roles=" + roles + ", startTime=" + startTime + ", endTime=" + endTime + ", language=" + language + ", isactive=" + isactive + ", emailId=" + emailId + ", manualToken=" + manualToken + ", medicalService=" + medicalService + '}';
//    }
//
//    
//    
//
//
//}
