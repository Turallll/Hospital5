package az.hospital.dao;

import az.hospital.dao.EmployeeDao;
import az.hospital.model.Employee;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@AllArgsConstructor
@Repository
public class EmployeeDaoImpl implements EmployeeDao {
// Fuad

    public DataSource dataSource;

    public List<Employee> getEmployeeList() throws Exception {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        String sql = "SELECT * FROM hospitaldb.employee\n" +
                "where activ = 1";
        List<Employee> employeeList = (List<Employee>) jdbcTemplate.query(sql, new BeanPropertyRowMapper(Employee.class));
        return employeeList;
    }

    public Employee getEmployeeById(Long employeeId) throws Exception {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        String sql = "SELECT * FROM hospitaldb.employee\n" +
                "where activ = 1 and id = ?";
        List<Employee> employeeList = jdbcTemplate.query(sql, new Object[]{employeeId}, new BeanPropertyRowMapper(Employee.class));
        if (employeeList.size() > 0) {
            return employeeList.get(0);
        }
        return null;
    }

    public void addEmployee(Employee employee) throws Exception {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        String sql = "insert into employee(name,surname,phone,address,dob,salary,currency)\n" +
                "values(?,?,?,?,?,?,?)";

        jdbcTemplate.update(sql, new Object[]{employee.getName(), employee.getSurname(), employee.getPhone()
                , employee.getAddress(), employee.getDob(), employee.getSalary(), employee.getCurrency()});
    }

    public void updateEmployee(Employee employee) throws Exception {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        String sql = "update employee set name = ?,surname = ?,phone =?,address = ?,dob = ?,salary = ?,currency = ? \n" +
                "where id = ?";

        jdbcTemplate.update(sql, new Object[]{employee.getName(), employee.getSurname(), employee.getPhone()
                , employee.getAddress(), employee.getDob(), employee.getSalary(), employee.getCurrency(), employee.getId()});
    }

    public void deleteEmployee(Long employeeId) throws Exception {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        String sql = "update employee set activ = 0 \n" +
                "where id = ?";
        jdbcTemplate.update(sql, new Object[]{employeeId});
    }

    public Integer employeeCount() throws Exception {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        String sql = "SELECT count(*) FROM hospitaldb.employee";
        Integer count = jdbcTemplate.queryForObject(sql, Integer.class);
        return count;
    }
}

