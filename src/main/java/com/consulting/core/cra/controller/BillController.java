package com.consulting.core.cra.controller;


import com.consulting.core.cra.model.Bill;
import com.consulting.core.cra.repository.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by HanenChnaina on 20/07/2018.
 */

@RestController
@RequestMapping("/api")
public class BillController {

    @Autowired
    BillRepository repository;

    @RequestMapping(value = "bills", method = RequestMethod.GET)
    public Collection<Bill> getbills() {
        return repository.findAll().stream()
                .collect(Collectors.toList());
    }

    @RequestMapping(value = "bill", method = RequestMethod.POST)
    public Bill addBill(@Valid @RequestBody Bill bill) {
        return repository.save(bill);
    }

    @RequestMapping("bills/{id}")
    public Bill getBillById(@PathVariable(value = "id") Long billId) {
        return repository.findById(billId)
                .orElseThrow(() -> new ResourceNotFoundException("billId"));
    }

    @RequestMapping(value = "bill/{id}", method = RequestMethod.DELETE)
    public void deleteBill(@PathVariable("id") long id) {
        Optional<Bill> currentBill = null;
        currentBill = repository.findById(id);
        if (!currentBill.equals("null")) {
            repository.deleteById(id);
        }
    }

    @RequestMapping(value = "bill/{id}", method = RequestMethod.PUT)
    public Bill updateBill(@PathVariable(value = "id") String billId,
                                 @Valid @RequestBody Bill billDetails) {

        Bill bill = repository.findById(Long.parseLong(billId))
                .orElseThrow(() -> new ResourceNotFoundException("billId"));
        System.out.println(bill);
        bill.setId(billDetails.getId());
        bill.setTva(billDetails.getTva());
        bill.setPaid(billDetails.getPaid());
        bill.setGlobalAmount(billDetails.getGlobalAmount());



        Bill updatedBill = repository.save(bill);
        System.out.println(updatedBill);

        return updatedBill;
    }
}

