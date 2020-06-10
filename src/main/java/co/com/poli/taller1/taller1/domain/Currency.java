package co.com.poli.taller1.taller1.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.NotFound;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="tbl_currencies")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Currency {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotEmpty(message = "El nombre no debe ser vacío")
    @NotNull(message="El nombre no debe ser null")
    @NotBlank(message="Currency name is required")
    @Column(updatable = false, unique = true, nullable = false)
    private String name;
    @NotEmpty(message = "El symbol no debe ser vacío")
    private String symbol;
    private int rank;
}