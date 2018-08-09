package com.consulting.core.cra.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**

 * Created by hanen chnaina.
 */
@Entity
//@Getter
//@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Bill {

    @Id
    @GeneratedValue
    private Long id;

    //private Cra cra;
    private Long tva;
    private Boolean paid;
    private Long globalAmount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTva() {
        return tva;
    }

    public void setTva(Long tva) {
        this.tva = tva;
    }

    public Boolean getPaid() {
        return paid;
    }

    public void setPaid(Boolean paid) {
        this.paid = paid;
    }

    public Long getGlobalAmount() {
        return globalAmount;
    }

    public void setGlobalAmount(Long globalAmount) {
        this.globalAmount = globalAmount;
    }
}
