package in.sritaj.jpaandhibernate.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
public class PartTimEmployee extends Employee {

    @Column(name = "hourly_wage")
    private BigDecimal hourlyWage;

    PartTimEmployee() {
    }

    public PartTimEmployee(String name, BigDecimal hourlyWage) {
        super(name);
        this.hourlyWage = hourlyWage;
    }
}