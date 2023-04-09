package com.ipap.springcopilottest.service;

import com.ipap.springcopilottest.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    private final List<Employee> employees = new ArrayList<>();

    public EmployeeService() {
        employees.add(new Employee(1, "John", "Doe", 25));
        employees.add(new Employee(2, "Jane", "Doe", 30));
        employees.add(new Employee(3, "John", "Smith", 35));
        employees.add(new Employee(4, "Jane", "Smith", 40));
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public List<Employee> getEmployeesByName(String name) {
        List<Employee> result = new ArrayList<>();
        for (Employee employee : employees) {
            if (employee.getName().equals(name)) {
                result.add(employee);
            }
        }
        return result;
    }

    public List<Employee> getEmployeesBySurname(String surname) {
        List<Employee> result = new ArrayList<>();
        for (Employee employee : employees) {
            if (employee.getSurname().equals(surname)) {
                result.add(employee);
            }
        }
        return result;
    }

    public List<Employee> getEmployeesByAge(int age) {
        List<Employee> result = new ArrayList<>();
        for (Employee employee : employees) {
            if (employee.getAge() == age) {
                result.add(employee);
            }
        }
        return result;
    }

    public List<Employee> getEmployeesByNameAndSurname(String name, String surname) {
        List<Employee> result = new ArrayList<>();
        for (Employee employee : employees) {
            if (employee.getName().equals(name) && employee.getSurname().equals(surname)) {
                result.add(employee);
            }
        }
        return result;
    }

    public List<Employee> getEmployeesByNameAndAge(String name, int age) {
        List<Employee> result = new ArrayList<>();
        for (Employee employee : employees) {
            if (employee.getName().equals(name) && employee.getAge() == age) {
                result.add(employee);
            }
        }
        return result;
    }

    public List<Employee> getEmployeesBySurnameAndAge(String surname, int age) {
        List<Employee> result = new ArrayList<>();
        for (Employee employee : employees) {
            if (employee.getSurname().equals(surname) && employee.getAge() == age) {
                result.add(employee);
            }
        }
        return result;
    }

    public Employee getEmployeeById(int id) {
        for (Employee employee : employees) {
            if (employee.getId() == id) {
                return employee;
            }
        }
        return null;
    }

    public Employee addEmployee(Employee employee) {
        employees.add(employee);
        return employees.stream()
                .filter(e -> e.getId() == employee.getId())
                .findFirst()
                .orElse(null);
    }

    public Employee updateEmployee(Employee employee) {
        for (Employee e : employees) {
            if (e.getId() == employee.getId()) {
                e.setName(employee.getName());
                e.setSurname(employee.getSurname());
                e.setAge(employee.getAge());
            }
        }
        return employee;
    }

    public void deleteEmployee(int id) {
        employees.removeIf(employee -> employee.getId() == id);
    }

    public void deleteAllEmployees() {
        employees.clear();
    }

    public Employee getEmployeeByName(String name) {
        for (Employee employee : employees) {
            if (employee.getName().equals(name)) {
                return employee;
            }
        }
        return null;
    }
}
