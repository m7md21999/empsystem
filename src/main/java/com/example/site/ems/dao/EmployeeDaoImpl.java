package com.example.site.ems.dao;

import com.example.site.ems.domain.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

    @Autowired
    EmployeeRepository repository;


    @Override
    public Employee findById(int id) {

        Optional<Employee> employee = repository.findById(id);
        if (employee.isPresent()) {
            return employee.get();
        } else {
            return null;
        }
    }

    @Override
    public List<Employee> findALl() {
        Iterable<Employee> employeeIterable = repository.findAll();

        List<Employee> employeeList = new ArrayList<>();
        if (employeeIterable != null) {

            for (Employee employee : employeeIterable) {
                employeeList.add(employee);
            }
            return employeeList;
        } else {
            return null;

        }
    }

    @Override
    public void add(Employee employee) {
        repository.save(employee);

    }

    @Override
    public void update(int id, int employeeId, String fname, String lname, String department, String email, int salary, Date date) {

//        Optional<Employee> employee = repository.findById(id);
//        if (employee.isPresent()){
//            employee.get().setFirstName(fname);
//            employee.get().setLastName(lname);
//            employee.get().setDepartment(department);
//            employee.get().setEmail(email);
//            employee.get().setDate(date);
//            employee.get().setSalary(salary);
//            repository.save(employee.get());
//        }

        if (repository.findById(id).isPresent()) {
            Employee emp = repository.findById(id).get();
            emp.setEmployeeId(employeeId);
            emp.setFirstName(fname);
            emp.setLastName(lname);
            emp.setDepartment(department);
            emp.setEmail(email);
            emp.setDate(date);
            emp.setSalary(salary);
            repository.save(emp);

        }

    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);

    }
}
