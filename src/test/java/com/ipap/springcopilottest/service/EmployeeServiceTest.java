package com.ipap.springcopilottest.service;

import com.ipap.springcopilottest.Employee;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeServiceTest {

    EmployeeService employeeService;

    @BeforeEach
    void setUp() {
        employeeService = new EmployeeService();
    }

    @AfterEach
    void tearDown() {
        employeeService = null;
    }

    @Test
    void getEmployees() {
        assertEquals(4, employeeService.getEmployees().size());
        assertNotEquals(5, employeeService.getEmployees().size());
    }

    @Test
    void getEmployeesByName() {
        assertEquals(2, employeeService.getEmployeesByName("John").size());
        assertNotEquals(3, employeeService.getEmployeesByName("John").size());
    }

    @Test
    void getEmployeesBySurname() {
        assertEquals(2, employeeService.getEmployeesBySurname("Doe").size());
        assertNotEquals(3, employeeService.getEmployeesBySurname("Doe").size());
    }

    @Test
    void getEmployeesByAge() {
        assertEquals(1, employeeService.getEmployeesByAge(30).size());
        assertNotEquals(3, employeeService.getEmployeesByAge(30).size());
    }

    @Test
    void getEmployeesByNameAndSurname() {
        assertEquals(1, employeeService.getEmployeesByNameAndSurname("John", "Doe").size());
        assertNotEquals(2, employeeService.getEmployeesByNameAndSurname("John", "Doe").size());
    }

    @Test
    void getEmployeesByNameAndAge() {
        assertEquals(1, employeeService.getEmployeesByNameAndAge("John", 25).size());
        assertNotEquals(2, employeeService.getEmployeesByNameAndAge("John", 25).size());
    }

    @Test
    void getEmployeesBySurnameAndAge() {
        assertEquals(1, employeeService.getEmployeesBySurnameAndAge("Doe", 25).size());
        assertNotEquals(2, employeeService.getEmployeesBySurnameAndAge("Doe", 25).size());
    }

    @Test
    void getEmployeeById() {
        assertEquals(1, employeeService.getEmployeeById(1).getId());
        assertNotEquals(2, employeeService.getEmployeeById(1).getId());
    }

    @Test
    void addEmployee() {
        employeeService.addEmployee(new Employee(5, "John", "Doe", 25));
        assertEquals(5, employeeService.getEmployees().size());
        assertNotEquals(4, employeeService.getEmployees().size());
    }

    @Test
    void updateEmployee() {
        Employee employee = employeeService.getEmployeeById(1);
        employee.setName("Mike");
        employeeService.updateEmployee(employee);
        assertEquals("Mike", employeeService.getEmployeeById(1).getName());
        assertNotEquals("John", employeeService.getEmployeeById(1).getName());
    }

    @Test
    void deleteEmployee() {
        employeeService.deleteEmployee(1);
        assertEquals(3, employeeService.getEmployees().size());
        assertNotEquals(4, employeeService.getEmployees().size());
    }

    @Test
    void deleteAllEmployees() {
        employeeService.deleteAllEmployees();
        assertEquals(0, employeeService.getEmployees().size());
        assertNotEquals(4, employeeService.getEmployees().size());
    }

    @Test
    void getEmployeeByName() {
        assertEquals("John", employeeService.getEmployeeByName("John").getName());
        assertNotEquals("Mike", employeeService.getEmployeeByName("John").getName());
    }
}