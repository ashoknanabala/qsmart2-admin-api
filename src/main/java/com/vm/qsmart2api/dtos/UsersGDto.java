/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vm.qsmart2api.dtos;

import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Phani
 */
public class UsersGDto {
    
  private Integer userId;

    private String login;

    private String hashedPassword;

    private String firstname;

    private String lastname;

    private Short manualToken;

    private String contactNo;

    private int orgId;

    private String orgName;

    private int levelId;

    private Short isactive;

    private String levelName;

    private String language;

    private String emailId;

    private char userType;

    private short orgStatus;

    boolean isManualPage;

    private boolean isAuthenticated = true;

    private String drSegmentId;
    
        private String medicalService;

    @ApiModelProperty(required = false, notes = "depts should not be empty")
    private List<DeptDto> depts = new ArrayList<>();

    @ApiModelProperty(required = false, notes = "roles should not be empty")
    private List<RoleDto> roles;

    private List<ServiceDto> services = new ArrayList<>();
    private List<DoctorGetDto> doctors;

    @ApiModelProperty(required = false, notes = "startTime should not be empty", example = "10:00:00")
    private String startTime;

    @ApiModelProperty(required = false, notes = "endTime should not be empty", example = "12:00:00")
    private String endTime;

    private Short currentProfile;

    private Short secondProfile;

    private int buildId;

    private String buildEngName;

    private String buildArbName;

    public boolean isIsAuthenticated() {
        return isAuthenticated;
    }

    public void setIsAuthenticated(boolean isAuthenticated) {
        this.isAuthenticated = isAuthenticated;
    }

    public boolean isIsManualPage() {
        return isManualPage;
    }

    public void setIsManualPage(boolean isManualPage) {
        this.isManualPage = isManualPage;
    }

    public short getOrgStatus() {
        return orgStatus;
    }

    public void setOrgStatus(short orgStatus) {
        this.orgStatus = orgStatus;
    }

    public void addDept(DeptDto dept) {
        depts.add(dept);
    }

    public String getDrSegmentId() {
        return drSegmentId;
    }

    public void setDrSegmentId(String drSegmentId) {
        this.drSegmentId = drSegmentId;
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

    public String getHashedPassword() {
        return hashedPassword;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public char getUserType() {
        return userType;
    }

    public void setUserType(char userType) {
        this.userType = userType;
    }

    public void setHashedPassword(String hashedPassword) {
        this.hashedPassword = hashedPassword;
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

    public int getOrgId() {
        return orgId;
    }

    public void setOrgId(int orgId) {
        this.orgId = orgId;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public int getLevelId() {
        return levelId;
    }

    public void setLevelId(int levelId) {
        this.levelId = levelId;
    }

    public String getLevelName() {
        return levelName;
    }

    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }

    public List<DeptDto> getDepts() {
        return depts;
    }

    public void setDepts(List<DeptDto> depts) {
        this.depts = depts;
    }

    public List<RoleDto> getRoles() {
        return roles;
    }

    public void setRoles(List<RoleDto> roles) {
        this.roles = roles;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public Short getIsactive() {
        return isactive;
    }

    public void setIsactive(Short isactive) {
        this.isactive = isactive;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public void addService(ServiceDto service) {
        services.add(service);
    }

    public List<ServiceDto> getServices() {
        return services;
    }

    public void setServices(List<ServiceDto> services) {
        this.services = services;
    }

    public List<DoctorGetDto> getDoctors() {
        return doctors;
    }

    public void setDoctors(List<DoctorGetDto> doctors) {
        this.doctors = doctors;
    }

    public Short getCurrentProfile() {
        return currentProfile;
    }

    public void setCurrentProfile(Short currentProfile) {
        this.currentProfile = currentProfile;
    }

    public Short getSecondProfile() {
        return secondProfile;
    }

    public void setSecondProfile(Short secondProfile) {
        this.secondProfile = secondProfile;
    }

    public int getBuildId() {
        return buildId;
    }

    public void setBuildId(int buildId) {
        this.buildId = buildId;
    }

    public String getBuildEngName() {
        return buildEngName;
    }

    public void setBuildEngName(String buildEngName) {
        this.buildEngName = buildEngName;
    }

    public String getBuildArbName() {
        return buildArbName;
    }

    public void setBuildArbName(String buildArbName) {
        this.buildArbName = buildArbName;
    }

    public Short getManualToken() {
        return manualToken;
    }

    public void setManualToken(Short manualToken) {
        this.manualToken = manualToken;
    }

    public String getMedicalService() {
        return medicalService;
    }

    public void setMedicalService(String medicalService) {
        this.medicalService = medicalService;
    }

    
    @Override
    public String toString() {
        return "UsersGDto{" + "userId=" + userId + ", login=" + login + ", hashedPassword=" + hashedPassword + ", firstname=" + firstname + ", lastname=" + lastname + ", manualToken=" + manualToken + ", contactNo=" + contactNo + ", orgId=" + orgId + ", orgName=" + orgName + ", levelId=" + levelId + ", isactive=" + isactive + ", levelName=" + levelName + ", language=" + language + ", emailId=" + emailId + ", userType=" + userType + ", orgStatus=" + orgStatus + ", isManualPage=" + isManualPage + ", isAuthenticated=" + isAuthenticated + ", drSegmentId=" + drSegmentId + ", depts=" + depts + ", roles=" + roles + ", services=" + services + ", doctors=" + doctors + ", startTime=" + startTime + ", endTime=" + endTime + ", currentProfile=" + currentProfile + ", secondProfile=" + secondProfile + ", buildId=" + buildId + ", buildEngName=" + buildEngName + ", buildArbName=" + buildArbName + '}';
    }

    
}
