package com.example.site.ems.controller;

import com.example.site.ems.domain.Employee;
import com.example.site.ems.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/ems")
public class EmployeeControllerImpl implements EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/employeesList")
    @Override
    public String findALl(Model model) {
        List<Employee> employeeList = employeeService.findALl();
        model.addAttribute("employeeList", employeeList);
        return "mainPage";
    }
    @PostMapping("/create")
    public String create(Employee employee) {
        employeeService.add(employee);
        return "redirect:/ems/employeesList";
    }

    @GetMapping("/add")
    @Override
    public String add(Model model) {
        Employee employee = new Employee();
        System.out.println("Employee: " + employee);
        model.addAttribute("employee", employee);
        return "addPage";
    }

    @GetMapping("/{id}")
    @Override
    public String findById(@PathVariable int id,
                           Model model) {
        Employee employee = employeeService.findById(id);
        model.addAttribute("employee", employee);
        // TODO: ADD THE HTML PAGE :
        return "";
    }

    @GetMapping("updateForm/{id}")
    public String updateForm(@PathVariable int id, Model model) {
        Employee employee = employeeService.findById(id);
        model.addAttribute("employee", employee);
        return "updatePage";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/goToList")
    public String goToList() {
        return "redirect:/ems/employeesList";
    }

    @PostMapping("/update")
    @Override
    public String update(Employee employee) {
        System.out.println(employee);
        employeeService.update(employee.getId(),
                employee.getEmployeeId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getDepartment(),
                employee.getEmail(),
                employee.getSalary(),
                employee.getDate());
        return "redirect:/ems/employeesList";
    }

    @GetMapping("/delete/{id}")
    @Override
    public String delete(@PathVariable int id) {
        employeeService.delete(id);
        return "redirect:/ems/employeesList";
    }
}