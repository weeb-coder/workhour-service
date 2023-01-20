package com.microservices.workhourservice.controller;

import com.microservices.workhourservice.db.entity.EmployeeLeaveEntity;
import com.microservices.workhourservice.model.Leave;
import com.microservices.workhourservice.service.WorkHourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employeeLeave")
public class WorkHourController {

    @Autowired
    WorkHourService workHourService;

    @PostMapping("/addEmployee")
    public String saveDate(@RequestBody EmployeeLeaveEntity empLeave) {
        return workHourService.saveData(empLeave);
    }

    @GetMapping("/{empId}")
    public Leave getEmployeeLeaveDetails(@PathVariable String empId) {
        return workHourService.getEmployeeLeaveDetails(empId);
    }
}
