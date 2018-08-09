package com.consulting.core.cra.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.Month;

/**
 * A CRA
 * Created by HanenChnaina on 21/04/2018.
 */
@Entity
//@Getter
//@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Cra {

    @Id
    @GeneratedValue
    private Long id;

    private Long year;

    private Month month;

    private Long days;

    private Long status;

    //private Contract contract;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getYear() {
        return year;
    }

    public void setYear(Long year) {
        this.year = year;
    }

    public Month getMonth() {
        return month;
    }

    public void setMonth(Month month) {
        this.month = month;
    }

    public Long getDays() {
        return days;
    }

    public void setDays(Long days) {
        this.days = days;
    }

    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }
}
