package rovshan.insurance_app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rovshan.insurance_app.entity.Company;
import rovshan.insurance_app.exception.Exception;
import rovshan.insurance_app.repository.CompanyRepository;

import java.util.ArrayList;
import java.util.List;
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
                new Exception("CREATE COMPANY operation could not be executed. Input data is invalid")));
    }

    public Company read(Long companyId_) {
        return companyRepository.findById(companyId_).orElseThrow(() ->
                new Exception(String.format("READ COMPANY operation could not be executed. COMPANY with %d id could not found", companyId_)));
    }

    public List<Company> readAll() {
        ArrayList<Company> companies = new ArrayList<>();

        for(Company c : companyRepository.findAll()){
            companies.add(c);
        }

        if(companies.size() == 0){
            throw new Exception("READ ALL COMPANIES operation could not be executed. There are no any companies.");
        }
        else {
            return companies;
        }
    }

    public Company update(Company company) {
        Optional<Company> companyOP = Optional.ofNullable(company);
        return companyRepository.save(companyOP.orElseThrow(() ->
                new Exception("UPDATE COMPANY operation could not be executed. Input data is invalid")));
    }

    public Company delete(Long companyId_) {
        Optional<Company> companyOP = companyRepository.findById(companyId_);

        if(companyOP.isPresent()){
            companyRepository.delete(companyOP.get());
            return companyOP.get();
        }
        else{
            throw new Exception(String.format("DELETE COMPANY operation could not be executed. COMPANY with %s id could not found", companyId_));
        }
    }
}
