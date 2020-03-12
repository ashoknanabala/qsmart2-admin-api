/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vm.qsmart2api.dtos.usersdto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author SOMANADH PHANI
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class FloorAndUserDto {

    private List<LevelDto> levels = new ArrayList<>();

    public FloorAndUserDto(List<LevelDto> levels) {
        this.levels = levels;
    }

    public List<LevelDto> getLevels() {
        return levels;
    }

    public void setLevels(List<LevelDto> levels) {
        this.levels = levels;
    }

}
