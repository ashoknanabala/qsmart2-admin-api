/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vm.qsmart2api.contoller;

import com.vm.qsmart2api.dtos.JwtRequest;
import com.vm.qsmart2api.dtos.JwtResponse;
import com.vm.qsmart2api.dtos.UserDetails;
import com.vm.qsmart2api.security.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Ashok
 */
@RestController
public class JwtAuthenticationController {
    
    @Autowired 
    JwtTokenUtil jwtTokenUtil;
    
    @PostMapping("/login")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {

		final UserDetails userDetails = new UserDetails();
                userDetails.setUsername(authenticationRequest.getUsername());
                userDetails.setPassword(authenticationRequest.getPassword());
		final String token = jwtTokenUtil.generateToken(userDetails);

		//return ResponseEntity.ok(new JwtResponse(token));
          return ResponseEntity.status(HttpStatus.OK).header("token", token).body(userDetails);

	}
}
