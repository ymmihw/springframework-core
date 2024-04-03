package com.ymmihw.springframework.objectprovider;

import com.ymmihw.springframework.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmployeeBeanUsingObjectProvider {

    @Autowired
    private org.springframework.beans.factory.ObjectProvider<Employee> objectProvider;

    public Employee getEmployee(String name) {
        Employee employee = objectProvider.getObject(name);
        return employee;
    }
}
