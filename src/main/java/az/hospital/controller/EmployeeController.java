package az.hospital.controller;

import az.hospital.response.RespEmployeeList;
import az.hospital.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/employee")
public class EmployeeController {
     @Autowired
    private EmployeeService employeeService;

    @GetMapping(value = "/getEmployeeList")
    public RespEmployeeList getEmployeeList() {
        return employeeService.getEmployeeList();
    }
}
