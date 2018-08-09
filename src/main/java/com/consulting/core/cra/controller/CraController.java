package com.consulting.core.cra.controller;

import com.consulting.core.cra.model.Cra;
import com.consulting.core.cra.repository.CraRepository;
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
 * Created by HanenChnaina on 22/07/2018.
 */

@RestController
@RequestMapping("/api/")
public class CraController {

    private CraRepository repository;

    public CraController(CraRepository repository) {
        this.repository = repository;
    }

    @RequestMapping(value = "cras", method = RequestMethod.GET)
    public Collection<Cra> getcras() {
        return repository.findAll().stream()
                .collect(Collectors.toList());
    }

    @RequestMapping(value = "cra", method = RequestMethod.POST)
    public Cra addCra (@Valid @RequestBody Cra cra) {
        return repository.save(cra);
    }

    @RequestMapping("cras/{id}")
    public Cra getCraById(@PathVariable(value = "id") Long craId) {
        return repository.findById(craId)
                .orElseThrow(() -> new ResourceNotFoundException("craId"));
    }

    @RequestMapping(value = "cra/{id}", method = RequestMethod.DELETE)
    public void deleteCra(@PathVariable("id") long id) {
        Optional<Cra> currentCra = null;
        currentCra = repository.findById(id);
        if (!currentCra.equals("null")) {
            repository.deleteById(id);
        }
    }

    @RequestMapping(value = "cra/{id}", method = RequestMethod.PUT)
    public Cra updateCra(@PathVariable(value = "id") String craId,
                         @Valid @RequestBody Cra craDetails) {

        Cra cra = repository.findById(Long.parseLong(craId))
                .orElseThrow(() -> new ResourceNotFoundException("craId"));
        System.out.println(cra);
        cra.setId(craDetails.getId());
        cra.setYear(craDetails.getYear());
        cra.setMonth(craDetails.getMonth());
        cra.setDays(craDetails.getDays());
        cra.setStatus(craDetails.getStatus());


        Cra updatedCra = repository.save(cra);
        System.out.println(updatedCra);

        return updatedCra;
    }


}