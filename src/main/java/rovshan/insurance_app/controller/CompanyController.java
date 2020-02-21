package rovshan.insurance_app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rovshan.insurance_app.entity.Company;
import rovshan.insurance_app.service.CompanyService;

@RestController
@RequestMapping("/company")
public class CompanyController {
    private final CompanyService companyService;

    public CompanyController(@Autowired CompanyService companyService) {
        this.companyService = companyService;
    }

    @PostMapping("/add")
    public Company create(@RequestBody Company company){
        return companyService.create(company);
    }

    @GetMapping("get/{companyId}")
    public Company getCompany(@PathVariable("companyId") Long companyId_){
        return companyService.getCompany(companyId_);
    }

    @PutMapping("/edit")
    public Company editCompany(@RequestBody Company company){
        return companyService.editCompany(company);
    }

    @DeleteMapping("/delete/{companyId}")
    public Company deleteCompany(@PathVariable Long companyId){
        return companyService.deleteCompany(companyId);
    }
}
