package in.sritaj.jpaandhibernate.entity.customids.compositekeys;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

/**
 * Staff Entity defining the Table structure and relevant mappings with dependent entities
 */
@Getter
@Setter
@NoArgsConstructor
@Entity
@IdClass(StaffID.class)
public class Staff {

    @Id
    @Column(nullable = false)
    private int id;

    @Id
    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String name;
}
