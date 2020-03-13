/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vm.qsmart2api.dtos;

/**
 *
 * @author Ashok
 */
public class JwtResponse {
     private final String jwttoken;
     
    public JwtResponse(String jwttoken) {
        this.jwttoken = jwttoken;
    }
   

    /**
     * @return the jwttoken
     */
    public String getJwttoken() {
        return jwttoken;
    }
}
