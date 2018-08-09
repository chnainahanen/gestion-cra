package com.consulting.core.cra.controller;

import com.consulting.core.cra.model.Company;
import com.consulting.core.cra.repository.CompanyRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by HanenChnaina on 16/07/2018.
 */

@RestController
@RequestMapping("/api/compagny")
public class CompanyController {

    private CompanyRepository repository;

    public CompanyController(CompanyRepository repository) {
        this.repository = repository;
    }



    @RequestMapping(value = "clients", method = RequestMethod.GET)
    public Collection<Company> getCompanies() {
        return repository.findAll().stream()
                .collect(Collectors.toList());
    }

    @RequestMapping(value = "client", method = RequestMethod.POST)
    public Company addCompany(@Valid @RequestBody Company company) {
        return repository.save(company);
    }

    @RequestMapping("clients/{id}")
    public Company getCompanyById(@PathVariable(value = "id") Long companyId) {
        return repository.findById(companyId)
                .orElseThrow(() -> new ResourceNotFoundException("companyId"));
    }

    @RequestMapping(value = "client/{id}", method = RequestMethod.DELETE)
    public void deleteCompany(@PathVariable("id") long id) {
        Optional<Company> currentCompany = null;
        currentCompany = repository.findById(id);
        if (!currentCompany.equals("null")) {
            repository.deleteById(id);
        }
    }

    @RequestMapping(value = "client/{id}", method = RequestMethod.PUT)
    public Company updateCompany(@PathVariable(value = "id") String companyId,
                              @Valid @RequestBody Company companyDetails) {

        Company company = repository.findById(Long.parseLong(companyId))
                .orElseThrow(() -> new ResourceNotFoundException("companyId"));
        System.out.println(company);
        company.setCompanyId(companyDetails.getCompanyId());
        company.setName(companyDetails.getName());
        company.setPhone(companyDetails.getPhone());
        company.setEmailBill(companyDetails.getEmailBill());
        company.setEmailContrat(companyDetails.getEmailContrat());


        Company updatedCompany = repository.save(company);
        System.out.println(updatedCompany);

        return updatedCompany;
    }

}