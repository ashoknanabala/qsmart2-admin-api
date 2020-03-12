/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vm.qsmart2api.dtos;

/**
 *
 * @author SOMANADH PHANI
 */
public class CustomResponse extends Response{
    
    
    private int id;

    public CustomResponse() {
    }
    
    public CustomResponse(boolean status, String messages) {
        super(status, messages);
    }

    public CustomResponse(boolean status, String messages, int id) {
        super(status, messages);
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "CustomResponse{" + "id=" + id + "," + super.toString()+'}';
    }

    
}
