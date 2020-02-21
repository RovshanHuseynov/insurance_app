package rovshan.insurance_app.service;

import org.springframework.stereotype.Service;
import rovshan.insurance_app.entity.Company;
import rovshan.insurance_app.exception.Exception;
import rovshan.insurance_app.repository.CompanyRepository;

import java.util.Optional;

@Service
public class CompanyService {
    private final CompanyRepository companyRepository;

    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public Company create(Company company) {
        Optional<Company> com = Optional.ofNullable(company);
        return companyRepository.save(com.orElseThrow(() -> new Exception("CREATE COMPANY operation could not be executed. Company could not found")));
    }

    public Company getCompany(Long companyId) {
        return companyRepository.findById(companyId).orElseThrow(() ->
                new Exception(String.format("GET COMANY operation could not be executed. Company with %s id could not found", companyId)));
    }

    public Company editCompany(Company company) {
        return companyRepository.save(company);
    }

    public Company deleteCompany(long companyId) {
        companyRepository.deleteById(companyId);
        return null;
    }
}
