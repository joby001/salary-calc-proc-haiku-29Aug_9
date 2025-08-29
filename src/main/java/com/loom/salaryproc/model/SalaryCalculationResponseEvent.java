package com.loom.salaryproc.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class SalaryCalculationResponseEvent {
    private Long employeeId;
    private Integer daysWorked;
    private BigDecimal dailyRate;
    private BigDecimal totalSalary;
}