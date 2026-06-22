package com.ACB.SubRA.Controller;

import com.ACB.SubRA.Repository.EmployeeRepository;
import com.ACB.SubRA.Request.EmployeeCreationRequest;
import com.ACB.SubRA.Response.ApiReponse;
import com.ACB.SubRA.Service.EmployeeService;
import com.ACB.SubRA.Service.Login;
import com.ACB.SubRA.entity.Employee;
import com.bkav.crypto.util.DataUtils;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Random;
import com.bkav.crypto.Cms;


/**
 * @author ThucCD
 */
@RequestMapping("/login")
@RestController
public class LoginController {
    private  static  final Logger log = LoggerFactory.getLogger(LoginController.class);
    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    EmployeeService employeeService;

    @PostMapping("/signData1")
    public ApiReponse<Employee> createEmployee(@RequestBody @Valid EmployeeCreationRequest request){
        log.info("request = {}", request);

        ApiReponse<Employee> employeeApiReponse = new ApiReponse<>();

        employeeApiReponse.setResutl(employeeService.createEmployee(request));

        return employeeApiReponse;
    }
    @GetMapping("/listEmployee")
    public List<Employee> listEmployee (){

        return employeeService.getAllUser() ;
    }
    @GetMapping("/listEmployee2")
    ResponseEntity<?> listEmployee2(){
        return ResponseEntity.ok(employeeService.getAllUser());
    }
    @GetMapping("/{employeeID}")
    ResponseEntity<?> getEmployeeID(@PathVariable("employeeID")int employeeID){
        return ResponseEntity.ok(employeeService.getEmployeeID(employeeID));
    }
    @PutMapping("/{employeeID}")
    ResponseEntity<?> updateEmployee (@PathVariable int employeeID , @RequestBody EmployeeCreationRequest request){
        return ResponseEntity.ok(employeeService.updateEmployee(employeeID, request));
    }
    @DeleteMapping("/{employeeID}")
    ResponseEntity<?> delete (@PathVariable int employeeID){
        return ResponseEntity.ok("Employee has been deleted >>"+employeeService.deleteEmployee(employeeID));
    }

}
