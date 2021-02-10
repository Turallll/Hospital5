package az.hospital.dao;

import az.hospital.model.Employee;

import java.util.List;

public interface EmployeeDao {

    List<Employee> getEmployeeList() throws Exception;
}
