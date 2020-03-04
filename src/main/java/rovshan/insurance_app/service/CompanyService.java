package rovshan.insurance_app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rovshan.insurance_app.repository.CompanyRepository;

@Service
public class CompanyService {
    private final CompanyRepository companyRepository;

    public CompanyService(@Autowired CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }
}
