/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vm.qsmart2api.dtos;

/**
 *
 * @author chand
 */
public class Response {
    
    private boolean status;
    private String messages;

    public Response() {
    }
    
    public Response(boolean status, String messages) {
        this.status = status;
        this.messages = messages;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getMessages() {
        return messages;
    }

    public void setMessages(String messages) {
        this.messages = messages;
    }

    @Override
    public String toString() {
        return  "status=" + status + ", messages=" + messages ;
    }
    
}
