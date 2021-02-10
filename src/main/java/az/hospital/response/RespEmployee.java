package az.hospital.response;

import lombok.Data;

import java.util.Date;
@Data
public class RespEmployee {

    private Long employeeId;
    private String name;
    private String surname;
    private String phone;
    private String address;
    private Date dob;
    private Float salary;
    private String currency;

}
