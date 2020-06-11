package co.com.poli.taller1.taller1.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.sql.Date;

@Entity
@Table(name="tbl_quotes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Quote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;
    @NotBlank(message="El Nombre es incorrecto")
    @NotEmpty(message = "El Nombre no debe ser vacio")
    private String name;
    @NotBlank(message="El Symbol es incorrecto")
    @NotEmpty(message = "El Symbol no debe ser vacio")
    private String symbol;
    @Positive(message = "El precio debe ser mayor a cero")
    private double price;
    private Date lastUpdate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="currency_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Currency currency;
}
