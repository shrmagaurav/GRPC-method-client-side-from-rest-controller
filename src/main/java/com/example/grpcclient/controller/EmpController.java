package com.example.grpcclient.controller;

import com.example.grpcclient.request.EmployeeCreateRequest;
import com.example.grpcclient.request.EmployeeUpdateRequest;
import com.example.grpcclient.services.GrpcCallsManager;
import com.example.grpcclient.view.EmployeeRepresentation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/EmpController")
public class EmpController {

    @Autowired
    private GrpcCallsManager grpcCallsManager;
    public static final Logger LOGGER = LoggerFactory.getLogger(EmpController.class);

    @PostMapping()
    public EmployeeRepresentation createEmp(@Validated @RequestBody EmployeeCreateRequest data){
        return grpcCallsManager.createEmployee(data);
    }

    @GetMapping("/{id}")
    public EmployeeRepresentation getEmpById(@PathVariable int id){
        return grpcCallsManager.getEmployeeById(id);
    }

    @GetMapping
    public List<EmployeeRepresentation> getAll(){
        return grpcCallsManager.getAllEmployee();
    }

    @DeleteMapping("/{id}")
    public EmployeeRepresentation delEmpById(@PathVariable int id){
        return grpcCallsManager.delEmployeeById(id);
    }

    @PutMapping("/{id}")
    public EmployeeRepresentation updateEmp(@PathVariable int id , @Validated @RequestBody EmployeeUpdateRequest data){
        return  grpcCallsManager.updateEmployee(data,id);
    }


}
