package br.com.ms.hrpayroll.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

public class Payment implements Serializable {
    private static final long serialVersionUID = -8149335479317371349L;

    private String name;
    private BigDecimal dailyIncome;
    private Integer days;

    public Payment() {
    }

    public Payment(String name, BigDecimal dailyIncome, Integer days) {
        this.name = name;
        this.dailyIncome = dailyIncome;
        this.days = days;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getDailyIncome() {
        return dailyIncome;
    }

    public void setDailyIncome(BigDecimal dailyIncome) {
        this.dailyIncome = dailyIncome;
    }

    public Integer getDays() {
        return days;
    }

    public void setDays(Integer days) {
        this.days = days;
    }

    public BigDecimal getTotal(){
        return dailyIncome.multiply(BigDecimal.valueOf(days));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Payment payment = (Payment) o;
        return name.equals(payment.name) && dailyIncome.equals(payment.dailyIncome) && days.equals(payment.days);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, dailyIncome, days);
    }
}