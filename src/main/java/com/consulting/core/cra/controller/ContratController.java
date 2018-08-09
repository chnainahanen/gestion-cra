package com.consulting.core.cra.controller;

import com.consulting.core.cra.model.Contract;
import com.consulting.core.cra.repository.ContratRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by hanen on 14/07/2018.
 */

@RestController
@RequestMapping("/api/contrat")
public class ContratController {

    private ContratRepository repository;

    public ContratController(ContratRepository repository) {
        this.repository = repository;
    }


    @RequestMapping(value = "contracts", method = RequestMethod.GET)
    public Collection<Contract> getContracts() {
        return repository.findAll().stream()
                .collect(Collectors.toList());
    }

    @RequestMapping(value = "contract", method = RequestMethod.POST)
    public Contract addContat(@Valid @RequestBody Contract contract) {
        return repository.save(contract);
    }

    @RequestMapping("clients/{id}")
    public Contract getContractById(@PathVariable(value = "id") Long contractId) {
        return repository.findById(contractId)
                .orElseThrow(() -> new ResourceNotFoundException("contractId"));
    }

    @RequestMapping(value = "client/{id}", method = RequestMethod.DELETE)
    public void deleteContract(@PathVariable("id") long id) {
        Optional<Contract> currentContract = null;
        currentContract = repository.findById(id);
        if (currentContract !=null ) {
            repository.deleteById(id);
        }
    }

    @RequestMapping(value = "contract/{id}", method = RequestMethod.PUT)
    public Contract updateContract(@PathVariable(value = "id") String contratId,
                              @Valid @RequestBody Contract contractDetails) {

        Contract contrat = repository.findById(Long.parseLong(contratId))
                .orElseThrow(() -> new ResourceNotFoundException("contractId"));
        System.out.println(contrat);
        contrat.setContractId(contractDetails.getContractId());
          Contract updatedContract = repository.save(contrat);
        System.out.println(updatedContract);

        return updatedContract;
    }

}