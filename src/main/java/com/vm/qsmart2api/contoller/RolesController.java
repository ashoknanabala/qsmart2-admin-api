/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vm.qsmart2api.contoller;

import com.vm.Qsmart.model.Role;
import com.vm.qsmart2api.dtos.CustomResponse;
import com.vm.qsmart2api.dtos.roles.RolesCreateDto;
import com.vm.qsmart2api.dtos.roles.RolesDto;
import com.vm.qsmart2api.mapper.RolesMapper;
import com.vm.qsmart2api.repository.RolesRepository;
import com.vm.qsmart2api.services.RolesService;
import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.NoSuchMessageException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Tejasri
 */
@RestController
@RequestMapping("roles/")
public class RolesController {

    public static final Logger logger = LogManager.getLogger(RolesController.class);

    @Autowired
    RolesService rolesService;

    @Autowired
    RolesRepository rolesRepository;

    @GetMapping(path = "get/{loginId}", produces = {"Application/json", "Application/xml"})
    ResponseEntity<List<RolesDto>> getAllRoles(@RequestHeader(value = "Accept-Language", required = false)
            @PathVariable("loginId") int loginId) {
        StringBuilder sb = new StringBuilder();
        sb.append("[LOGIN_ID_").append(loginId).append("]");
        String header = sb.toString();
        try {
            List<RolesDto> roleDto = new ArrayList<>();
            List<Role> roless = rolesRepository.findAll();
            roleDto = RolesMapper.INSTANCE.rolesToRolesDto(roless);
            return ResponseEntity.status(HttpStatus.OK).body(roleDto);
        } catch (Exception e) {
            logger.error("{}Excep:getAllLocations:Error:{}", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ArrayList<>());
        } finally {
            sb = null;
            header = null;
        }
    }

    @PostMapping(path = "create/{loginId}", produces = {"Application/json", "Application/xml"})
    ResponseEntity<CustomResponse> saveRole(@RequestHeader(value = "Accept-Language", required = false)
            @PathVariable("loginId") int loginId, @Valid @RequestBody RolesCreateDto roleCrtDto) {
        StringBuilder sb = new StringBuilder();
        sb.append("[LOGIN_ID_").append(loginId).append("]");
        String header = sb.toString();
        CustomResponse sResponse = null;
        try {
            rolesService.saveRolesInDb(header, loginId, roleCrtDto);
            sResponse = new CustomResponse(true, "Role created Successfully");
            logger.info("{}Given:addRoleInDB:Response:{}", header, sResponse);
            return ResponseEntity.status(HttpStatus.CREATED).body(sResponse);

        } catch (NoSuchMessageException e) {
            logger.error("{}Excep:addRolesInDB:Error:{}", header, e.getMessage());
            sResponse = new CustomResponse(false, "Failed to create role");
            logger.info("{}Given:addRolesInDB:Response:[{}]", header, sResponse);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(sResponse);
        } finally {
            sb = null;
            header = null;
            sResponse = null;
        }
    }

    @GetMapping(path = "{loginId}/role/validate",
            produces = {"application/json", "application/xml"})
    public ResponseEntity<CustomResponse> validateRoleName(@RequestHeader(value = "Accept-Language", required = false)
            @RequestParam("roleName") String roleName, @PathVariable("loginId") int loginId) {
        StringBuilder sb = new StringBuilder();
        sb.append("[LOGIN_ID_").append(loginId).append("]");
        String header = sb.toString();
        CustomResponse srResponse;
        Role role = null;
        try {
            logger.info("{}Enter:validateRoleName:roleName:[{}]", header, roleName);
            role = rolesRepository.findByRoleName(roleName);
            if (role != null) {
                srResponse = new CustomResponse(false, "Role name already Exist");
            } else {
                srResponse = new CustomResponse(true, "Role name not Exist");
            }
            logger.info("{}Given:validateRoleName:Response:[{}]", header, srResponse);
            return ResponseEntity.status(HttpStatus.OK).body(srResponse);
        } catch (NoSuchMessageException e) {
            e.printStackTrace();
            logger.error("{}Excep:validateRoleName:Error:{}", header, e.getMessage());
            srResponse = new CustomResponse(false, "common wrong message");
            logger.info("{}Given:validateRoleName:Response:[{}]", header, srResponse);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(srResponse);
        } finally {
            sb = null;
            header = null;
            role = null;

        }
    }

    @DeleteMapping(path = "{loginId}/deActivateRole/{roleid}", produces = {"application/json", "application/xml"})
    public ResponseEntity<CustomResponse> deActivateRoleByRoleId(@RequestHeader(value = "Accept-Language", required = false)
            @PathVariable("loginId") int loginId, @PathVariable("roleid") int roleId) {
        StringBuilder sb = new StringBuilder();
        sb.append("[LOGIN_ID_").append(loginId).append("]");
        String header = sb.toString();
        CustomResponse srResponse = null;
        try {

            logger.info("{}Enter:deActivateRoleByRoleId:UserId:[{}],roleid:[{}]", header, loginId, roleId);
            rolesRepository.deleteById(roleId);
            return ResponseEntity.status(HttpStatus.OK).body(srResponse);
        } catch (NoSuchMessageException e) {
            srResponse = new CustomResponse(false, "Failed to delete Role");
            logger.info("{}Given:addRolesInDB:Response:[{}]", header, srResponse);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(srResponse);
        } finally {
            sb = null;
            header = null;
            srResponse = null;
        }
    }

    @GetMapping(path = "{loginId}/all/{roleid}",
            produces = {"application/json", "application/xml"})
    public ResponseEntity<CustomResponse> getRolesByUserRoleId(@PathVariable("loginId") int loginId, @PathVariable("roleid") int parentRoleId) {
        StringBuilder sb = new StringBuilder();
        sb.append("[LOGIN_ID_").append(loginId).append("]");
        String header = sb.toString();
        List<RolesDto> rolesList = new ArrayList<>();
        try {
            logger.info("{}Enter:getRolesByUserRoleId:getRolesByUserRoleId:userId:[{}],RoleId:[{}]", header, parentRoleId);
            List<Role> roless = rolesRepository.getRolesByParentRoleId(parentRoleId);
            rolesList = RolesMapper.INSTANCE.rolesToRolesDto(roless);
            logger.info("{}Given:getRolesByUserRoleId:Response:[{}]", header, rolesList);
            return new ResponseEntity(rolesList, HttpStatus.OK);
        } catch (Exception e) {
            logger.error("{}Excep:getRolesByUserRoleId:Exception:Error:{}", header, e.getMessage());
            logger.info("{}Given:getRolesByUserRoleId:Response:[{}]", header, "[]");
            return new ResponseEntity(new ArrayList<>(), HttpStatus.INTERNAL_SERVER_ERROR);
        } finally {
            sb = null;
            header = null;
            rolesList = null;
        }
    }
}
