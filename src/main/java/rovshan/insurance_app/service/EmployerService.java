package rovshan.insurance_app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rovshan.insurance_app.repository.EmployerRepository;

@Service
public class EmployerService {
    private final EmployerRepository employerRepository;

    public EmployerService(@Autowired EmployerRepository employerRepository) {
        this.employerRepository = employerRepository;
    }
}