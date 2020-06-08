package co.com.poli.taller1.taller1.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.NotFound;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="tbl_currencies")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Currency {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;
    @NotEmpty(message = "El nombre no debe ser vacío")
    private String name;
    @NotEmpty(message = "El symbol no debe ser vacío")
    private String symbol;
    private int rank;
}