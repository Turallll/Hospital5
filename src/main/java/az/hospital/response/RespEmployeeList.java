package az.hospital.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class RespEmployeeList {
     @JsonProperty(value = "employeeList")
    private List<RespEmployee> getEmployeeList;
    private RespStatus status;
}
