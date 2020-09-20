package com.example.springbootrabbitmq.api;

import com.example.springbootrabbitmq.message.RabbitMQSender;
import com.example.springbootrabbitmq.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/example-rabbitmq")
public class RabbitMQWebController {

    @Autowired
    RabbitMQSender rabbitMQSender;

    // http://localhost:8080/example-rabbitmq/producer?empName=emp1Name&empId=emp001&empSurname=emp1Surname
    @GetMapping(value = "/producer")
    public String producer(@RequestParam("empName") String empName,
                           @RequestParam("empId") String empId,
                           @RequestParam("empSurname") String empSurname) {

        Employee emp=new Employee();
        emp.setId(empId);
        emp.setName(empName);
        emp.setSurname(empSurname);
        rabbitMQSender.send(emp);

        return "Message sent to the RabbitMQ example Successfully";
    }
}
