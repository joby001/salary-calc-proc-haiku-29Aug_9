package com.loom.salaryproc.service;

import com.loom.salaryproc.model.SalaryCalculationRequestEvent;
import com.loom.salaryproc.model.SalaryCalculationResponseEvent;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class SalaryCalculationService {

    public SalaryCalculationResponseEvent calculateSalary(SalaryCalculationRequestEvent requestEvent) {
        SalaryCalculationResponseEvent responseEvent = new SalaryCalculationResponseEvent();
        responseEvent.setEmployeeId(requestEvent.getEmployeeId());
        responseEvent.setDaysWorked(requestEvent.getDaysWorked());
        responseEvent.setDailyRate(requestEvent.getDailyRate());
        
        BigDecimal totalSalary = requestEvent.getDailyRate()
            .multiply(BigDecimal.valueOf(requestEvent.getDaysWorked()));
        
        responseEvent.setTotalSalary(totalSalary);
        return responseEvent;
    }
}