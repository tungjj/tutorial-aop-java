package com.example.demoaopjava.aspect;

import com.example.demoaopjava.entity.Ticket;
import com.example.demoaopjava.reflection.ReflectionHelper;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
 import org.springframework.stereotype.Component;

@Slf4j
@Component
@Aspect
public class DateAspect {
    @Pointcut(value = "execution(* com.example.demoaopjava.service.TicketService.createNewTicket(..))")
    private void createNewTicketPointcut(){}

    @Before(value = "createNewTicketPointcut()")
    public void beforeExecute(JoinPoint jp) throws NoSuchFieldException {
        String startDate = jp.getArgs()[0].toString();
        String endDate = jp.getArgs()[1].toString();

        String startDateFormat = ReflectionHelper.getValueFromAnnotation(Ticket.class, "startDate" );
        boolean isStartDateCorrect = validateDateTime(startDate, startDateFormat);

        String endDateFormat = ReflectionHelper.getValueFromAnnotation(Ticket.class, "endDate" );
        boolean isEndDateCorrect = validateDateTime(endDate, endDateFormat);



        if (!isStartDateCorrect || !isEndDateCorrect) {
            log.error("Date is not in the right format");
            throw new RuntimeException();
        }
    }

    private boolean validateDateTime(String inputDateTime, String dateFormat) throws NoSuchFieldException {
        if(dateFormat != null) {
            switch (dateFormat) {
                case "yyyy/MM/dd": {
                    String regex = "^\\d{4}/(0[1-9]|1[0-2])/([0-2][0-9]|3[0-1])$";
                    return inputDateTime.matches(regex);
                }
                case "yyyy/MM/dd HH:mm:ss": {
                    String regex = "^\\d{4}/(0[1-9]|1[0-2])/([0-2][0-9]|3[0-1]) (0[0-9]|1[0-9]|2[0-3]):([0-5][0-9]):([0-5][0-9])$";
                    return inputDateTime.matches(regex);
                }
                default:
                    return false;
            }
        }
        return false;
    }
}
