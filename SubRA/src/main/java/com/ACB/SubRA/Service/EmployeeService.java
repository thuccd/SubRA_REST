package com.ACB.SubRA.Service;

import com.ACB.SubRA.Exception.AppException;
import com.ACB.SubRA.Exception.ErrorCode;
import com.ACB.SubRA.Repository.EmployeeRepository;
import com.ACB.SubRA.Repository.GroupRepository;
import com.ACB.SubRA.Repository.RoleRepository;
import com.ACB.SubRA.Request.EmployeeCreationRequest;
import com.ACB.SubRA.entity.Employee;
import com.ACB.SubRA.entity.Group;
import com.ACB.SubRA.entity.Role;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    GroupRepository groupRepository;
    @Autowired
    RoleRepository roleRepository;
    private  static  final Logger log = LoggerFactory.getLogger(EmployeeService.class);

    public Employee createEmployee(EmployeeCreationRequest request){
        log.info("Service create employee");
        Employee employee = new Employee();
        if(employeeRepository.existsByUserName(request.getUserName()))
            throw  new RuntimeException("ErrorCode.USER_EXIT");


        employee.setUserName(request.getUserName());
        employee.setFullName(request.getFullName());
        employee.setEmail(request.getEmail());
        employee.setPhoneNumber(request.getPhoneNumber());
        employee.setIpAddress(request.getIpAddress());
        employee.setActive(request.isActive());
        employee.setPassword(request.getPassword());
        Date date = new Date();
        employee.setCreatedTime(date);
        // 1 employee_certificate
        // 2 employee_menu
        // 3 employee_work_type
        // 4 group
        Group group = new Group();
        group = groupRepository.findGroupByCode(request.getGroupName());
        log.info("NameGroup:>>"+group.getGroupName());
        employee.setGroup(group);

        // 5 menu
        // 6 parent
        // 7 role
        Role role = new Role();
        role = roleRepository.findByRoleName(request.getRoleName());
        log.info("roleName:>>"+role.getRoleName());
        employee.setRole(role);
        // 8 sharework
        // 9 workType
        //10 parrent
        log.info("RequestParent:>>"+request.getUserParent());
        Employee userParent = employeeRepository.findByuserName(request.getUserParent());
        log.info("parent:>>"+userParent.getFullName());

        employee.setParent(userParent);


        return employeeRepository.save(employee);
    }
    public List<Employee> getAllUser(){
        return employeeRepository.findAll();
    }
    public Optional<Employee> getEmployeeID (Integer employeeID){
        return employeeRepository.findById(employeeID);
    }

    public Employee updateEmployee(int employeeID, EmployeeCreationRequest request){

        Employee employee = employeeRepository.findByEmployeeID(employeeID);
        employee.setUserName(request.getUserName());
        employee.setFullName(request.getFullName());
        employee.setEmail(request.getEmail());
        employee.setPhoneNumber(request.getPhoneNumber());
        employee.setIpAddress(request.getIpAddress());
        employee.setActive(request.isActive());
        employee.setPassword(request.getPassword());
        Date date = new Date();
        employee.setCreatedTime(date);
        // 1 employee_certificate
        // 2 employee_menu
        // 3 employee_work_type
        // 4 group
        Group group = new Group();
        group = groupRepository.findGroupByCode(request.getGroupName());
        log.info("NameGroup:>>"+group.getGroupName());
        employee.setGroup(group);

        // 5 menu
        // 6 parent
        // 7 role
        Role role = new Role();
        role = roleRepository.findByRoleName(request.getRoleName());
        log.info("roleName:>>"+role.getRoleName());
        employee.setRole(role);
        // 8 sharework
        // 9 workType
        //10 parrent
        log.info("RequestParent:>>"+request.getUserParent());
        Employee userParent = employeeRepository.findByuserName(request.getUserParent());
        log.info("parent:>>"+userParent.getFullName());

        employee.setParent(userParent);


        return employeeRepository.save(employee);
    }

    public int deleteEmployee (int employeeID){
        return employeeRepository.deleteEmployeeID(employeeID);
    }



}
