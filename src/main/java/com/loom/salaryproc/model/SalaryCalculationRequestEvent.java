package com.loom.salaryproc.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class SalaryCalculationRequestEvent {
    private Long employeeId;
    private Integer daysWorked;
    private BigDecimal dailyRate;
}