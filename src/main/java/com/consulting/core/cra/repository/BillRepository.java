package com.consulting.core.cra.repository;

import com.consulting.core.cra.model.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by HanenChnaina .
 */
@RepositoryRestResource
public interface BillRepository extends JpaRepository<Bill, Long> {
}
