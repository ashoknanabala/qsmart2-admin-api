/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vm.qsmart2api.services;

import com.vm.Qsmart.model.Department;
import com.vm.qsmart2api.dtos.department.DepartmentFloorGetDto;
import com.vm.qsmart2api.dtos.department.DepartmentGtDto;
import com.vm.qsmart2api.dtos.department.DepartmentNewCrtDto;
import com.vm.qsmart2api.dtos.department.DepartmentNewUpDto;
import com.vm.qsmart2api.mapper.DepartmentMapper;
import com.vm.qsmart2api.repository.DepartmentRepository;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.NoResultException;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Tejasri
 */
public class DepartmentService {

    public static final Logger logger = LogManager.getLogger(DepartmentService.class);

    @Autowired
    DepartmentRepository departmentRepository;

    public int saveDepartment(String header, int loginId, DepartmentNewCrtDto departmentCrtDto) {
        Department dept = null;
        try {
            logger.info("{}>>:saveDepartment:UserID:[{}]:DepartmentCrtDto:[{}]", header, loginId, departmentCrtDto);
            dept = DepartmentMapper.INSTANCE.departmentCrtDtoToDepartment(departmentCrtDto);
            dept.setCreatedBy(loginId);
            dept.setStatus((short) 1);
            dept.setOrgId(departmentCrtDto.getOrgId());
            dept.setDeptType(departmentCrtDto.getDeptType());

            logger.debug("<<{}saveDepartment:Obj:[{}]", header, dept);
            departmentRepository.save(dept);
            return dept.getDeptId();
        } catch (Exception e) {
            logger.error("{}Excep:saveDepartment:Exception:Error:{}", header, ExceptionUtils.getRootCauseMessage(e));
            throw new RuntimeException("Department create failed");
        } finally {
            dept = null;
        }
    }

    public boolean validateFloorIdAndDeptName(String header, int floorId, String deptName) {
        try {
            logger.info("{}>>:validateFloorIdAndDeptName: levelId:{} deptName:{}", header, floorId, deptName);
            departmentRepository.validateFloorIdAndDeptName(deptName, floorId);
            return true;
        } catch (NoResultException ne) {
            logger.error("{}Excep:validateOrgIdAndDeptName:Error:{}", header, ExceptionUtils.getRootCauseMessage(ne));
            return false;
        } catch (Exception e) {
            logger.error("{}Excep:validateOrgIdAndDeptName:Error:{}", header, ExceptionUtils.getRootCauseMessage(e));
            throw new RuntimeException("common wrong message");
        }
    }

    public boolean validateDeptArbNameByFloorId(String header, int floorId, String deptArbName) {
        try {
            logger.info("{}>>:validateFloorIdAndDeptName: levelId:{} deptName:{}", header, floorId, deptArbName);
            departmentRepository.validateDeptArbNameByFloorId(deptArbName, floorId);
            return true;
        } catch (NoResultException ne) {
            logger.error("{}Excep:validateOrgIdAndDeptName:Error:{}", header, ExceptionUtils.getRootCauseMessage(ne));
            return false;
        } catch (Exception e) {
            logger.error("{}Excep:validateOrgIdAndDeptName:Error:{}", header, ExceptionUtils.getRootCauseMessage(e));
            throw new RuntimeException("common wrong message");
        }
    }

    public boolean validatePharmaLocationByOrgIdInDb(String header, int orgId, String pharmaLocation, short deptType) {

        try {
            logger.info("{}>>:validatePharmaLocationByOrgIdInDb: pharmaLocation:[{}]:", header, orgId, pharmaLocation);
            departmentRepository.validatePharmaLocationByOrgIdInDb(orgId, pharmaLocation, deptType);
            return true;
        } catch (NoResultException ne) {
            logger.error("{}Excep:validatePharmaLocationByOrgIdInDb:Error:{}", header, ExceptionUtils.getRootCauseMessage(ne));
            return false;
        } catch (Exception e) {
            logger.error("{}Excep:validatePharmaLocationByOrgIdInDb:Error:{}", header, ExceptionUtils.getRootCauseMessage(e));
            throw new RuntimeException("common wrong message");
        }
    }

    public boolean validatePharmaLocationUpdateByOrgIdInDb(String header, int orgId, String pharmaLocation, int deptId, int deptType) {
        try {
            departmentRepository.validatePharmaLocationUpdateByOrgIdInDb(orgId, pharmaLocation, deptId, deptType);
            return true;
        } catch (NoResultException ne) {
            logger.error("{}Excep:validatePharmaLocationByOrgIdInDb:Error:{}", header, ExceptionUtils.getRootCauseMessage(ne));
            return false;
        } catch (Exception e) {
            logger.error("{}Excep:validatePharmaLocationByOrgIdInDb:Error:{}", header, ExceptionUtils.getRootCauseMessage(e));
            throw new RuntimeException("common wrong message");
        }
    }

    public boolean validatePharmaIndexUpdateByOrgIdInDb(String header, int orgId, int pharmaIndex, int deptId, int deptType) {
        try {
            departmentRepository.validatePharmaIndexUpdateByOrgIdInDb(orgId, pharmaIndex, deptId, deptType);
            return true;
        } catch (NoResultException ne) {
            logger.error("{}Excep:validatePharmaIndexUpdateByOrgIdInDb:Error:{}", header, ExceptionUtils.getRootCauseMessage(ne));
            return false;
        } catch (Exception e) {
            logger.error("{}Excep:validatePharmaIndexUpdateByOrgIdInDb:Error:{}", header, ExceptionUtils.getRootCauseMessage(e));
            throw new RuntimeException("common wrong message");
        }
    }

    public boolean validatePharmaIndexByOrgIdInDb(String header, int orgId, int pharmaIndex, short deptType) {
        try {
            logger.info("{}>>:validatePharmaIndexByOrgIdInDb: pharmaIndex:[{}]:pharmaType:[{}]", header, orgId, pharmaIndex, deptType);
            departmentRepository.validatePharmaIndexByOrgIdInDb(orgId, pharmaIndex, deptType);
            return true;
        } catch (NoResultException ne) {
            logger.error("{}Excep:validatePharmaIndexByOrgIdInDb:Error:{}", header, ExceptionUtils.getRootCauseMessage(ne));
            return false;
        } catch (Exception e) {
            logger.error("{}Excep:validatePharmaIndexByOrgIdInDb:Error:{}", header, ExceptionUtils.getRootCauseMessage(e));
            throw new RuntimeException("common wrong message");
        }
    }

    public int updateDepartment(String header, int loginId, DepartmentNewUpDto departmenttUpDto) {
        Department deptValid = null;

        try {
            logger.info("{}>>:updateDepartment:loginId:[{}]:departmenttUpDto:[{}]", header, loginId, (departmenttUpDto != null));
            logger.debug("{}>>:updateDepartment:loginId:[{}]:departmenttUpDto:[{}]", header, loginId, departmenttUpDto);

            deptValid = ValidateDepartment(header, loginId, departmenttUpDto.getDeptId());
            if (deptValid != null) {
                deptValid = DepartmentMapper.INSTANCE.departmentUpdateDtoToDepartment(departmenttUpDto);
                deptValid.setUpdatedBy(loginId);
                deptValid.setStatus((short) 1);
                departmentRepository.save(deptValid);
                return deptValid.getDeptId();
            }
            return 0;
        } catch (IndexOutOfBoundsException ie) {
            logger.error("{}warn:updateDepartment:IndexOutOfBoundsException::Error:{}", header, ExceptionUtils.getRootCauseMessage(ie));
            return 0;
        } catch (NoResultException e) {
            logger.error("{}Excep:updateDepartment:NoResultException::Error:{}", header, ExceptionUtils.getRootCauseMessage(e));
            return 0;
        } catch (Exception e) {
            logger.error("{}Excep:updateDepartment:Exception:Error:{}", header, ExceptionUtils.getRootCauseMessage(e));
            return 0;
        } finally {
            deptValid = null;
        }
    }

    public Department ValidateDepartment(String header, int loginId, int deptId) {
        Department dept = new Department();
        try {
            departmentRepository.findByDeptId(deptId);
            return dept;
        } catch (NoResultException ie) {
            logger.error("{}Excep:ValidateDepartment:NoResultException:Error:{}", header, ExceptionUtils.getRootCauseMessage(ie));
            throw new RuntimeException("Department failed to update");
        } catch (Exception e) {
            logger.error("{}Excep:ValidateDepartment:Exception:Error:{}", header, ExceptionUtils.getRootCauseMessage(e));
            throw new RuntimeException("Department failed to update");
        }
    }

    public boolean validateDeptEngNameByFloorId(String header, DepartmentNewUpDto deptUpDto) {
        try {
            logger.info("{}>>:validateDeptEngNameByFloorId: Request:{}", header, (deptUpDto != null));
            logger.trace("{}>>:validateDeptEngNameByFloorId: Request:{}", header, deptUpDto);
            departmentRepository.validateDeptEngNameByFloorId(deptUpDto.getDeptName(), deptUpDto.getFloorId(), deptUpDto.getDeptId());
            return true;
        } catch (NoResultException ne) {
            logger.error("{}Excep:validateDeptEngNameByFloorId:Error:{}", header, ExceptionUtils.getRootCauseMessage(ne));
            return false;
        } catch (Exception e) {
            logger.error("{}Excep:validateDeptEngNameByFloorId:Error:{}", header, ExceptionUtils.getRootCauseMessage(e));
            throw new RuntimeException("common.wrong.message");
        }
    }

    public boolean validateDeptArbNameById(String header, DepartmentNewUpDto deptUpDto) {
        try {
            logger.info("{}>>:validateDeptArbNameById: Request:{}", header, (deptUpDto != null));
            logger.debug("{}>>:validateDeptArbNameById: Request:{}", header, deptUpDto);
            departmentRepository.validateDeptArbNameById(deptUpDto.getFloorId(), deptUpDto.getDeptId(), deptUpDto.getDeptArbName());
            return true;
        } catch (NoResultException ne) {
            logger.error("{}Excep:validateDeptArbNameById:Error:{}", header, ExceptionUtils.getRootCauseMessage(ne));
            return false;
        } catch (Exception e) {
            logger.error("{}Excep:validateDeptNameByFloorId:Error:{}", header, ExceptionUtils.getRootCauseMessage(e));
            throw new RuntimeException("common.wrong.message");
        }
    }


    public DepartmentFloorGetDto findDepartmentsByFloorId1(int floorId) {
        Department dept = new Department();

        try {
            logger.info("{}>>:getDeptsByFloorId :{}", floorId);
            List<DepartmentGtDto> deptG = new ArrayList<>();
            List<Object[]> list = departmentRepository.findDepartmentsByFloorId1(floorId);
            if (list != null && !list.isEmpty()) {
                list.forEach(obj -> {
                    DepartmentGtDto dto = DepartmentMapper.INSTANCE.departmentToDepartmentGtDto((Department) obj[0]);
                    deptG.add(dto);
                });
            }
            return new DepartmentFloorGetDto(deptG);
        } catch (Exception e) {
            logger.error("Excep:getDeptsByFloorId:Exception:Error:{}", ExceptionUtils.getRootCauseMessage(e));
            throw new RuntimeException("no data found");
        }
    }
}
