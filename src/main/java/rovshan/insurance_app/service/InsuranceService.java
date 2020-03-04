package rovshan.insurance_app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rovshan.insurance_app.entity.Insurance;
import rovshan.insurance_app.exception.Exception;
import rovshan.insurance_app.repository.InsuranceRepository;

import java.util.ArrayList;
import java.util.List;
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

    public Insurance read(Long insuranceId_) {
        return insuranceRepository.findById(insuranceId_).orElseThrow(() ->
                new Exception(String.format("READ INSURANCE operation could not be executed. INSURANCE with %d id could not be found", insuranceId_)));
    }

    public List<Insurance> readAll() {
        ArrayList<Insurance> insurances = new ArrayList<>();

        for(Insurance i : insuranceRepository.findAll()){
            insurances.add(i);
        }

        if(insurances.size() == 0){
            throw new Exception("READ ALL INSURANCES operation could not be executed. There are no any products.");
        }
        else{
            return insurances;
        }
    }

    public Insurance update(Insurance insurance) {
        Optional<Insurance> insuranceOP = Optional.ofNullable(insurance);
        return insuranceRepository.save(insuranceOP.orElseThrow(() ->
                new Exception("UPDATE INSURANCE operation could not be executed. Input data is invalid")));
    }

    public Insurance delete(Long insuranceId_) {
        Optional<Insurance> insuranceOP = insuranceRepository.findById(insuranceId_);

        if(insuranceOP.isPresent()){
            insuranceRepository.delete(insuranceOP.get());
            return insuranceOP.get();
        }
        else{
            throw new Exception(String.format("DELETE INSURANCE operation could not be executed. INSURANCE with %s id could not found", insuranceId_));
        }
    }
}
