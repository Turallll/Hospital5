package az.hospital.model;

import lombok.Data;

import java.util.Date;
@Data
public abstract  class AbstractClass {
    private Long id;
    private Date dataDate;
    private Integer active;
}
