package rovshan.insurance_app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rovshan.insurance_app.entity.Employer;
import rovshan.insurance_app.exception.Exception;
import rovshan.insurance_app.repository.EmployerRepository;

import java.util.Optional;

@Service
public class EmployerService {
    private final EmployerRepository employerRepository;

    public EmployerService(@Autowired EmployerRepository employerRepository) {
        this.employerRepository = employerRepository;
    }

    public Employer create(Employer employer) {
        Optional<Employer> employerOP = Optional.ofNullable(employer);
        return employerRepository.save(employerOP.orElseThrow(() ->
                new Exception("CREATE EMPLOYER operation could not be executed. EMPLOYER could not found")));
    }

    public Employer read(Long employerId_) {
        return employerRepository.findById(employerId_).orElseThrow(() ->
                new Exception(String.format("READ EMPLOYER operation could not be executed. %d could not be found", employerId_)));
    }

    public Employer update(Employer employer) {
        Optional<Employer> employerOP = Optional.ofNullable(employer);
        return employerRepository.save(employerOP.orElseThrow(() ->
                new Exception("UPDATE EMPLOYER operation could not be executed. employer could not found")));
    }

    public Employer delete(Long employerId_) {
        Optional<Employer> employerOP = employerRepository.findById(employerId_);

        if(employerOP.isPresent()){
            employerRepository.delete(employerOP.get());
            return employerOP.get();
        }
        else{
            throw new Exception(String.format("DELETE EMPLOYER operation could not be executed. EMPLOYER with %s id could not found", employerId_));
        }
    }
}