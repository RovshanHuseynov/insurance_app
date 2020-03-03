package rovshan.insurance_app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rovshan.insurance_app.entity.Company;
import rovshan.insurance_app.entity.Employer;
import rovshan.insurance_app.service.CompanyService;
import rovshan.insurance_app.service.UserService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/company")
public class CompanyController {
    private final CompanyService companyService;
    private final UserService userService;

    public CompanyController(@Autowired CompanyService companyService, @Autowired UserService userService) {
        this.companyService = companyService;
        this.userService = userService;
    }

    @PostMapping("/add")
    public Company create(@Valid @RequestBody Company company){
        return companyService.create(company);
    }

    @GetMapping("/get/{companyId}")
    public Company get(@Valid @PathVariable("companyId") Long companyId_){
        return companyService.get(companyId_);
    }

    @GetMapping("/{companyId}/users")
    public List<Employer> getUsersByCompanyId(@Valid @PathVariable("companyId") Long companyId_){
        return userService.getUsersByCompanyId(companyId_);
    }

    @PutMapping("/edit")
    public Company editCompany(@Valid @RequestBody Company company){
        return companyService.editCompany(company);
    }

    @DeleteMapping("/delete/{companyId}")
    public Company deleteCompany(@Valid @PathVariable Long companyId){
        return companyService.deleteCompany(companyId);
    }
}
