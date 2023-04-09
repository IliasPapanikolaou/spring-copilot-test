package com.ipap.springcopilottest.controller;

import com.ipap.springcopilottest.Employee;
import com.ipap.springcopilottest.config.TestConfig;
import com.ipap.springcopilottest.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.*;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withStatus;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

@ExtendWith(SpringExtension.class)
@RestClientTest({EmployeeController.class, EmployeeService.class})
@Import(TestConfig.class)
class EmployeeControllerTest {

    private static final String GET_ALL_EMPLOYEES =
            "[{\"id\":1,\"name\":\"John\",\"surname\":\"Doe\",\"age\":25}," +
                    "{\"id\":2,\"name\":\"Jane\",\"surname\":\"Doe\",\"age\":30}," +
                    "{\"id\":3,\"name\":\"John\",\"surname\":\"Smith\",\"age\":35}," +
                    "{\"id\":4,\"name\":\"Jane\",\"surname\":\"Smith\",\"age\":40}]";

    @Autowired
    MockRestServiceServer mockServer;

    @Autowired
    private EmployeeController employeeController;

    @Autowired
    RestTemplate restTemplate;

    @Test
    void getAllEmployees() {
        this.mockServer.expect(requestTo("/employee/all"))
                .andRespond(withSuccess(GET_ALL_EMPLOYEES, MediaType.APPLICATION_JSON));

        ResponseEntity<List<Employee>> employees = employeeController.getAllEmployees();
        assertThat(employees.getBody()).hasSize(5);
        assertThat(employees.getBody().get(0).getName()).isEqualTo("John");
    }

    @Test
    void getEmployeeById() {
        this.mockServer.expect(requestTo("/employee/1"))
                .andRespond(withSuccess("[{\"id\":1,\"name\":\"John\",\"surname\":\"Doe\",\"age\":25}]",
                        MediaType.APPLICATION_JSON));

        ResponseEntity<Employee> employee = employeeController.getEmployeeById(1);
        assertThat(Objects.requireNonNull(employee.getBody()).getName()).isEqualTo("John");
        assertThat(employee.getBody().getSurname()).isEqualTo("Doe");
        assertThat(employee.getBody().getAge()).isEqualTo(25);
        assertThat(employee.getBody().getId()).isEqualTo(1);
    }

    @Test
    void getEmployeeByName() {
        this.mockServer.expect(requestTo("/employee/name/John"))
                .andRespond(withSuccess("[{\"id\":1,\"name\":\"John\",\"surname\":\"Doe\",\"age\":25}," +
                                "{\"id\":3,\"name\":\"John\",\"surname\":\"Smith\",\"age\":35}]",
                        MediaType.APPLICATION_JSON));
        ResponseEntity<Employee> employee = employeeController.getEmployeeByName("John");
        assertThat(Objects.requireNonNull(employee.getBody()).getName()).isEqualTo("John");
        assertThat(employee.getBody().getSurname()).isEqualTo("Doe");
        assertThat(employee.getBody().getAge()).isEqualTo(25);
        assertThat(employee.getBody().getId()).isEqualTo(1);
    }

    @Test
    void addEmployee() {
        Employee employee = new Employee(5, "Mike", "Smith", 40);
        this.mockServer.expect(requestTo("/employee/add"))
                .andExpect(method(HttpMethod.POST))
                .andExpect(content().json("{\"id\":5,\"name\":\"Mike\",\"surname\":\"Smith\",\"age\":40}"))
                .andRespond(withStatus(HttpStatus.CREATED));

        restTemplate.postForEntity("/employee/add", employee, Employee.class);

        ResponseEntity<Employee> response = employeeController.addEmployee(employee);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
        assertThat(response.getBody()).isEqualTo(employee);
        assertThat(Objects.requireNonNull(response.getBody()).getId()).isEqualTo(5);
        assertThat(response.getBody().getName()).isEqualTo("Mike");
        assertThat(response.getBody().getSurname()).isEqualTo("Smith");
    }

    @Test
    void updateEmployee() {
        Employee employee = new Employee(5, "Michael", "Smith", 40);
        this.mockServer.expect(requestTo("/employee/update"))
                .andExpect(method(HttpMethod.PUT))
                .andExpect(content().json("{\"id\":5,\"name\":\"Michael\",\"surname\":\"Smith\",\"age\":40}"))
                .andRespond(withStatus(HttpStatus.OK));

        restTemplate.put("/employee/update", employee);

        ResponseEntity<Employee> response = employeeController.updateEmployee(employee);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isEqualTo(employee);
        assertThat(Objects.requireNonNull(response.getBody()).getId()).isEqualTo(5);
        assertThat(response.getBody().getName()).isEqualTo("Michael");
        assertThat(response.getBody().getSurname()).isEqualTo("Smith");
    }
}