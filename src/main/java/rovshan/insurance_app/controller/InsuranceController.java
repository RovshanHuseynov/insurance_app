package rovshan.insurance_app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rovshan.insurance_app.entity.Insurance;
import rovshan.insurance_app.service.InsuranceService;

import javax.validation.Valid;
import java.util.List;

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

    @GetMapping("/read/{insuranceId}")
    public Insurance read(@Valid @PathVariable("insuranceId") Long insuranceId_){
        return insuranceService.read(insuranceId_);
    }

    @GetMapping("/readAll")
    public List<Insurance> readAll(){
        return insuranceService.readAll();
    }

    @PutMapping("/update")
    public Insurance update(@Valid @RequestBody Insurance insurance){
        return insuranceService.update(insurance);
    }
}
