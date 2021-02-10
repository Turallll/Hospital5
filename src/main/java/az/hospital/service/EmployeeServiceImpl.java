package az.hospital.service;

import az.hospital.dao.EmployeeDao;
import az.hospital.model.Employee;
import az.hospital.response.RespEmployeeList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    @Override
    public RespEmployeeList getEmployeeList() {
        RespEmployeeList respEmployeeList = new RespEmployeeList();
        try {
            List<Employee> employeeList = employeeDao.getEmployeeList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return respEmployeeList;
    }
}
