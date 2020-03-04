package rovshan.insurance_app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rovshan.insurance_app.entity.Company;
import rovshan.insurance_app.service.CompanyService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/company")
public class CompanyController {
    private final CompanyService companyService;

    public CompanyController(@Autowired CompanyService companyService) {
        this.companyService = companyService;
    }

    @PostMapping("/create")
    public Company create(@Valid @RequestBody Company company){
        return companyService.create(company);
    }

    @GetMapping("/read/{companyId}")
    public Company read(@Valid @PathVariable("companyId") Long companyId_){
        return companyService.read(companyId_);
    }

    @GetMapping("/readAll")
    public List<Company> readAll(){
        return companyService.readAll();
    }

    @PutMapping("/update")
    public Company update(@Valid @RequestBody Company company){
        return companyService.update(company);
    }

    @DeleteMapping("/delete/{companyId}")
    public Company delete(@Valid @PathVariable("companyId") Long companyId_){
        return companyService.delete(companyId_);
    }
}