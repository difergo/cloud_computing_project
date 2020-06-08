package co.com.poli.taller1.taller1.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
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
    @NotEmpty(message = "El nombre no debe ser vacío")
    private String name;
    @NotEmpty(message = "El symbol no debe ser vacío")
    private String symbol;
    @Positive(message = "El stock debe ser mayor de cero")
    private double price;
    private Date lastUpdate;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="currency_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Currency currency;

}
