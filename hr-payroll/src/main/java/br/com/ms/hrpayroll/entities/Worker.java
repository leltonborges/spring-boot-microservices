package br.com.ms.hrpayroll.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

public class Worker implements Serializable {
    private static final long serialVersionUID = -4298349125063766104L;

    private Long id;
    private String name;
    private BigDecimal dailyIncome;

    public Worker() {
    }

    public Worker(Long id, String name, BigDecimal dailyIncome) {
        this.id = id;
        this.name = name;
        this.dailyIncome = dailyIncome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Worker worker = (Worker) o;
        return id.equals(worker.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
