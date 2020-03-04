package rovshan.insurance_app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rovshan.insurance_app.entity.Employee;
import rovshan.insurance_app.service.EmployeeService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(@Autowired EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/create")
    public Employee create(@Valid @RequestBody Employee employee){
        return employeeService.create(employee);
    }

    @GetMapping("/read/{employeeId}")
    public Employee read(@Valid @PathVariable("employeeId") Long employeeId_){
        return employeeService.read(employeeId_);
    }

    @GetMapping("/readAll")
    public List<Employee> readAll(){
        return employeeService.readAll();
    }

    @PutMapping("/update")
    public Employee update(@Valid @RequestBody Employee employee){
        return employeeService.update(employee);
    }

    @DeleteMapping("/delete/{employeeId}")
    public Employee delete(@Valid @PathVariable("employeeId") Long employeeId_){
        return employeeService.delete(employeeId_);
    }
}