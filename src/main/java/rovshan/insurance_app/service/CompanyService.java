package rovshan.insurance_app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rovshan.insurance_app.entity.Company;
import rovshan.insurance_app.exception.Exception;
import rovshan.insurance_app.repository.CompanyRepository;

import java.util.Optional;

@Service
public class CompanyService {
    private final CompanyRepository companyRepository;

    public CompanyService(@Autowired CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public Company create(Company company) {
        Optional<Company> companyOP = Optional.ofNullable(company);
        return companyRepository.save(companyOP.orElseThrow(() ->
                new Exception("CREATE COMPANY operation could not be executed. Company could not found")));
    }

    public Company read(Long companyId_) {
        return companyRepository.findById(companyId_).orElseThrow(() ->
                new Exception(String.format("READ COMPANY operation could not be executed. Company with %d id could not found", companyId_)));
    }
}
