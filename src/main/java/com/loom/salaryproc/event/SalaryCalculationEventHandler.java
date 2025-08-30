package com.loom.salaryproc.event;

import com.loom.salaryproc.model.SalaryCalculationRequestEvent;
import com.loom.salaryproc.model.SalaryCalculationResponseEvent;
import com.loom.salaryproc.service.SalaryCalculationService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;

import java.util.function.Function;

@Configuration
public class SalaryCalculationEventHandler {

    private final SalaryCalculationService salaryCalculationService;

    public SalaryCalculationEventHandler(SalaryCalculationService salaryCalculationService) {
        this.salaryCalculationService = salaryCalculationService;
    }

    @Bean
    public Function<Message<SalaryCalculationRequestEvent>, Message<SalaryCalculationResponseEvent>> processSalaryCalculation() {
        return requestMessage -> {
            SalaryCalculationRequestEvent requestEvent = requestMessage.getPayload();
            SalaryCalculationResponseEvent responseEvent = salaryCalculationService.calculateSalary(requestEvent);
            
            return MessageBuilder.withPayload(responseEvent)
                .setHeader("employeeId", responseEvent.getEmployeeId())
                .build();
        };
    }
}