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
 * @author VMHDCLAP21
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class DoctorGDto {

    private List<DoctorGetDto> doctors;

    public DoctorGDto() {
    }

    public DoctorGDto(List<DoctorGetDto> doctors) {
        this.doctors = doctors;
    }

    public List<DoctorGetDto> getDoctors() {
        return doctors;
    }

    public void setDoctors(List<DoctorGetDto> doctors) {
        this.doctors = doctors;
    }

    @Override
    public String toString() {
        return "DoctorGDto{" + "doctors=" + doctors + '}';
    }

}
