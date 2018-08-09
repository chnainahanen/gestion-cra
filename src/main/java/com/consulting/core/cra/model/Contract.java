package com.consulting.core.cra.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;


/**
 * A Contract.
 * Created by HanenChnaina on 21/04/2018.
 */
@Entity
//@Getter
//@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Contract {

    @Id
    @GeneratedValue
    private Long id;

    private Long contractId;

    private Long tjm;

    private Date startDate;

    private Date endDate;

    private Long paiementPeriod;

    private String comment;

    //private Company company;

    private Boolean active;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getContractId() {
        return contractId;
    }

    public void setContractId(Long contractId) {
        this.contractId = contractId;
    }

    public Long getTjm() {
        return tjm;
    }

    public void setTjm(Long tjm) {
        this.tjm = tjm;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Long getPaiementPeriod() {
        return paiementPeriod;
    }

    public void setPaiementPeriod(Long paiementPeriod) {
        this.paiementPeriod = paiementPeriod;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
