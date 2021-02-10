package az.hospital.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee extends  AbstractClass{

    private String name;
    private String surname;
    private String phone;
    private String address;
    private Date dob;
    private Float salary;
    private String currency;


}
