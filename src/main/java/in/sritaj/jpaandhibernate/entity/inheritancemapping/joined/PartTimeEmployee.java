package in.sritaj.jpaandhibernate.entity.inheritancemapping.joined;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.math.BigDecimal;

/**
 * PartTimEmployee Entity defining the Table structure and relevant mappings with dependent entities
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@DiscriminatorValue(value = "PTE")
public class PartTimeEmployee extends Employee {

    @Column(name = "hourly_wage")
    private BigDecimal hourlyWage;

    public PartTimeEmployee(String name, BigDecimal hourlyWage) {
        super(name);
        this.hourlyWage = hourlyWage;
    }
}
