package com.example.site.ems.service;
import com.example.site.ems.domain.Employee;

import java.util.Date;
import java.util.List;

public interface EmployeeService {

    Employee findById(int id);

    List<Employee> findALl();

    void add(Employee employee);

    void update(int id, int employeeId, String fname, String lname, String department, String email, int salary, Date date);

    void delete(int id);

}