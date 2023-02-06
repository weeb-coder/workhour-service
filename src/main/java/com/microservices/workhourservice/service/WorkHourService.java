package com.microservices.workhourservice.service;

import com.microservices.workhourservice.db.entity.EmployeeLeaveEntity;
import com.microservices.workhourservice.db.repository.WorkHourRepo;
import com.microservices.workhourservice.model.EmployeeDetails;
import com.microservices.workhourservice.model.Leave;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WorkHourService {

    @Autowired
    WorkHourRepo repo;

    public String saveData(EmployeeLeaveEntity empLeave) {
        repo.save(empLeave);
        return "Employee Leave details saved successfully";
    }

    public Leave getEmployeeLeaveDetail(EmployeeDetails emp) {
        int count = getEmployeeLeaveCount(emp.getEmpId());
        int daysInMonth = getDaysInMont(emp.getYearMonth());
        return new Leave
                .LeaveBuilder()
                .setCount(count)
                .setDaysInMonth(daysInMonth)
                .build();
    }

    public Leave getEmployeeLeaveDetails(String empId) {
        int count = getEmployeeLeaveCount(empId);
        int daysInMonth = getDaysInMonth(empId);
        return new Leave
                .LeaveBuilder()
                .setCount(count)
                .setDaysInMonth(daysInMonth)
                .build();
    }

    private int getEmployeeLeaveCount(String id) {
        return repo.findById(id).orElseThrow().getCount();
    }

    private int getDaysInMonth(String id) {
        int yearMonth = repo.findById(id).orElseThrow().getYearMonth();
        int year = Integer.parseInt(("" + yearMonth).substring(0, 4));
        int month = yearMonth % 100;
        if (month == 2) {
            if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0)
                return 29;
            return 28;
        }
        if (month == 4 || month == 6 || month == 9 || month == 11)
            return 30;
        return 31;
    }

    private int getDaysInMont(int yearMonth) {
        int year = Integer.parseInt(("" + yearMonth).substring(0, 4));
        int month = yearMonth % 100;
        if (month == 2) {
            if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0)
                return 29;
            return 28;
        }
        if (month == 4 || month == 6 || month == 9 || month == 11)
            return 30;
        return 31;
    }
}
