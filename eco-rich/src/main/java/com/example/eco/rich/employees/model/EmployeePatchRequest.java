package com.example.eco.rich.employees.model;

import com.example.eco.rich.employees.db.Employee;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeePatchRequest {
    private String lastName;

    private String firstName;

    private String email;

    private String phoneNumber;

}
