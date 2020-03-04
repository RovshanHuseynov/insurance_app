package rovshan.insurance_app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rovshan.insurance_app.entity.Employer;
import rovshan.insurance_app.service.EmployerService;

import javax.validation.Valid;

@RestController
@RequestMapping("/employer")
public class EmployerController {
    private final EmployerService employerService;

    public EmployerController(@Autowired EmployerService employerService) {
        this.employerService = employerService;
    }

    @PostMapping("/create")
    public Employer create(@Valid @RequestBody Employer employer){
        return employerService.create(employer);
    }

    @GetMapping("/read/{employerId}")
    public Employer read(@Valid @PathVariable("employerId") Long employerId_){
        return employerService.read(employerId_);
    }

    @PutMapping("/update")
    public Employer update(@Valid @RequestBody Employer employer){
        return employerService.update(employer);
    }
}