package rovshan.insurance_app.service;

import org.springframework.stereotype.Service;
import rovshan.insurance_app.entity.Company;
import rovshan.insurance_app.repository.CompanyRepository;

@Service
public class CompanyService {
    private final CompanyRepository companyRepository;

    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public Company create(Company company) {
        return companyRepository.save(company);
    }

    public Company getCompany(long companyId_) {
        if(companyRepository.findById(companyId_).isPresent()){
            return companyRepository.findById(companyId_).get();
        }
        return null;
    }

    public Company editCompany(Company company) {
        return companyRepository.save(company);
    }

    public Company deleteCompany(long companyId) {
        companyRepository.deleteById(companyId);
        return null;
    }
}
