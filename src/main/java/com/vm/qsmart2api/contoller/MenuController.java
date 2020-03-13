/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vm.qsmart2api.contoller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.databind.type.TypeFactory;

import com.vm.Q2.models.SubMenu;
import com.vm.qsmart2api.dtos.MenuResponseDTO;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.lang3.RandomStringUtils;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Ashok
 */
@RestController
@RequestMapping("/menu")
public class MenuController {
    
    @Autowired
    ObjectMapper objectMapper;
    
    @GetMapping("/{id}")
    @SuppressWarnings("unchecked")
    public List<MenuResponseDTO> menus(@PathVariable("id") Long id) throws FileNotFoundException, ParseException{
      //TypeFactory typeFactory = null;
      //typeFactory = objectMapper.getTypeFactory();
            CollectionType collectionType =objectMapper.getTypeFactory().constructCollectionType(
                    List.class, MenuResponseDTO.class);
         List<MenuResponseDTO> menuDTO = new ArrayList<MenuResponseDTO>();
        try {
         List<MenuResponseDTO> list = new ArrayList<MenuResponseDTO>();
         list =  objectMapper.readValue(new File("config/menus/menu_" + id + ".json"),collectionType);
         for (MenuResponseDTO menu:list){
             menu.setId(RandomStringUtils.randomNumeric(6));
             for(SubMenu submenu:menu.getSubmenu()){
                 submenu.setId(RandomStringUtils.randomNumeric(6));
             }
             menuDTO.add(menu);
         }
        } catch (IOException ex) {
            Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return menuDTO;
//         try {
//            List<MenuResponseDTO> list = new ArrayList<MenuResponseDTO>();
//            list = objectMapper.readValue(new File("config/menus/menu_" + id + ".json"), collectionType);
//             int i = 1;
//            for (MenuResponseDTO menu : list) {
//                menu.setId(String.valueOf(i));
//                i = i + 1;
//                int j=1;
//                for (SubMenu submenu : menu.getSubmenu()) {
//                    submenu.setId(String.valueOf(j));
//                     j  = j+1;
//                }
//                menuDTO.add(menu);
//            }
//        } catch (IOException ex) {
//            Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return menuDTO;
    }
    
}
