package rovshan.insurance_app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rovshan.insurance_app.entity.Insurance;
import rovshan.insurance_app.exception.Exception;
import rovshan.insurance_app.repository.InsuranceRepository;

import java.util.Optional;

@Service
public class InsuranceService {
    private final InsuranceRepository insuranceRepository;

    public InsuranceService(@Autowired InsuranceRepository insuranceRepository) {
        this.insuranceRepository = insuranceRepository;
    }

    public Insurance create(Insurance insurance) {
        Optional<Insurance> insuranceOP = Optional.ofNullable(insurance);
        return insuranceRepository.save(insuranceOP.orElseThrow(() ->
                new Exception("CREATE INSURANCE operation could not be executed. Input data is invalid")));
    }
}
