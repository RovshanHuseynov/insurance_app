package rovshan.insurance_app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rovshan.insurance_app.entity.Insurance;
import rovshan.insurance_app.service.InsuranceService;

import javax.validation.Valid;

@RestController
@RequestMapping("insurance")
public class InsuranceController {
    private final InsuranceService insuranceService;

    public InsuranceController(@Autowired InsuranceService insuranceService) {
        this.insuranceService = insuranceService;
    }

    @PostMapping("/create")
    public Insurance create(@Valid @RequestBody Insurance insurance){
        return insuranceService.create(insurance);
    }
}
