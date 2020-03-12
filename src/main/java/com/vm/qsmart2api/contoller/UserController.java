/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vm.qsmart2api.contoller;

import com.vm.qsmart2api.dtos.UserDto;
import com.vm.qsmart2api.dtos.UsersGDto;
import com.vm.qsmart2api.utils.DBConstants;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Phani
 */
@RestController
@RequestMapping("user/")
public class UserController {
    
     private static final Logger logger = LogManager.getLogger(UserController.class);
    
    @Autowired
    @PersistenceContext(name = DBConstants.JPA_UNIT_NAME_QSMART)
    EntityManager entityManager;

    public UserController() {
    }
    
    
    
   @PostMapping("/create")
   public String createUser(UserDto user){
       return "User created successfully";
   }
    
   
   @PutMapping("/update")
   public String updateUser(UserDto user){
       return "User updated successfully";
   }
   
   @GetMapping("/create")
   public UsersGDto getUser(){
       //String userName, String email, String moibileNo
       logger.info(">>[{}]", "Enter");
       List<UserDto> users = new ArrayList(){
           {
               add(new UserDto("Phani", "phani.bethanabotla@vectramind.com", "9652577984"));
           }
           {
               add(new UserDto("Somanadh", "somanadh.bethanabotla@vectramind.com", "9652577985"));
           }
       };
       logger.info("<<[{}]:Data:[{}]", "Exit", users);
       return new UsersGDto(users);
   }
}
