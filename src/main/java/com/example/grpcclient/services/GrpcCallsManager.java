package com.example.grpcclient.services;

import com.example.grpcclient.request.EmployeeCreateRequest;
import com.example.grpcclient.request.EmployeeUpdateRequest;
import com.example.grpcclient.view.EmployeeRepresentation;
import com.example.sarvika.grpc.MyServiceGrpc;
import com.example.sarvika.grpc.allEmployeesDetails;
import com.example.sarvika.grpc.createEmployee;
import com.example.sarvika.grpc.deleteEmployee;
import com.example.sarvika.grpc.entity;
import com.example.sarvika.grpc.getSingleEmployee;
import com.example.sarvika.grpc.updateEmployee;
import com.google.protobuf.Empty;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GrpcCallsManager {


    ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost",9090).usePlaintext().build();
    MyServiceGrpc.MyServiceBlockingStub stub = MyServiceGrpc.newBlockingStub(channel);

    public EmployeeRepresentation createEmployee(EmployeeCreateRequest data){
        entity result = stub.createEmployeeRequest(createEmployee.newBuilder()
                .setFirstName(data.getFirstName())
                .setLastName(data.getLastName())
                .setPhoneNo(data.getPhoneNo())
                .setHireDate(Long.parseLong(data.getHireDate()))
                .setSalary(data.getSalary())
                .setDepartment(data.getDepartment())
                .build());
        return createview(result);
    }

    public EmployeeRepresentation getEmployeeById(int id){
        entity data = stub.getEmployeeById(getSingleEmployee.newBuilder().setId(id).build());
        return createview(data);
    }

    public List<EmployeeRepresentation> getAllEmployee(){

        allEmployeesDetails data = stub.getAllEmployeesRequest(Empty.newBuilder().build());

        List<entity> result =data.getDataList();
        return result.stream().map(this::createview).collect(Collectors.toList());
    }

    public EmployeeRepresentation delEmployeeById(int id){
        entity data = stub.deleteEmployeeById(deleteEmployee.newBuilder().setId(id).build());
        return createview(data);
    }


    public EmployeeRepresentation updateEmployee( EmployeeUpdateRequest data, int id){
        entity result = stub.updateEmployeeById(updateEmployee.newBuilder()
                        .setId(id)
                .setPhoneNo(data.getPhoneNo())
                .setSalary(data.getSalary())
                .setDepartment(data.getDepartment())
                .build());
        return createview(result);
    }

    private  EmployeeRepresentation createview( entity data){
        EmployeeRepresentation result = new EmployeeRepresentation();
        result.setEmployeeID(data.getEmployeeId());
        result.setName(data.getName());
        result.setEmail(data.getEmail());
        result.setPhoneNo(data.getPhoneNo());
        result.setHireDate(data.getHireDate());
        result.setSalary(data.getSalary());
        result.setDepartment(data.getDepartment());
        return result;
    }
}
