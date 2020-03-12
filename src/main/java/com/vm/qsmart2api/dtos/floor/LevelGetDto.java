/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vm.qsmart2api.dtos.floor;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

/**
 *
 * @author VMHDCLAP21
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class LevelGetDto {

    private List<LevelGDto> levels;

    public LevelGetDto() {
    }

    public LevelGetDto(List<LevelGDto> levels) {
        this.levels = levels;
    }

    public List<LevelGDto> getLevels() {
        return levels;
    }

    public void setLevels(List<LevelGDto> levels) {
        this.levels = levels;
    }

    @Override
    public String toString() {
        return "LevelGetDto{" + "levels=" + levels + '}';
    }

}
