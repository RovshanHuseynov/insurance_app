package rovshan.insurance_app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rovshan.insurance_app.entity.Employee;
import rovshan.insurance_app.exception.Exception;
import rovshan.insurance_app.repository.EmployeeRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeService(@Autowired EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee create(Employee employee) {
        Optional<Employee> employeeOP = Optional.ofNullable(employee);
        return employeeRepository.save(employeeOP.orElseThrow(() ->
                new Exception("CREATE EMPLOYEE operation could not be executed. Input data is invalid")));
    }

    public Employee read(Long employeeId_) {
        return employeeRepository.findById(employeeId_).orElseThrow(() ->
                new Exception(String.format("READ EMPLOYEE operation could not be executed. EMPLOYEE with %d id could not be found", employeeId_)));
    }

    public List<Employee> readAll() {
        List<Employee> employees = new ArrayList<>();
        for(Employee e : employeeRepository.findAll()){
            employees.add(e);
        }

        if(employees.size() == 0){
            throw new Exception("READ ALL EMPLOYEES operation could not be executed. There are no any employees.");
        }
        else {
            return employees;
        }
    }

    public Employee update(Employee employee) {
        Optional<Employee> employeeOP = Optional.ofNullable(employee);
        return employeeRepository.save(employeeOP.orElseThrow(() ->
                new Exception("UPDATE EMPLOYEE operation could not be executed. EMPLOYEE could not found")));
    }

    public Employee delete(Long employeeId_) {
        Optional<Employee> employerOP = employeeRepository.findById(employeeId_);

        if(employerOP.isPresent()){
            employeeRepository.delete(employerOP.get());
            return employerOP.get();
        }
        else{
            throw new Exception(String.format("DELETE EMPLOYEE operation could not be executed. EMPLOYEE with %s id could not found", employeeId_));
        }
    }
}