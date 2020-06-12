package co.com.poli.taller1.taller1.domain;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.List;

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
        @NotEmpty(message = "El Nombre no debe ser vacio")
        @NotBlank(message="El Nombre es incorrecto")
        @Column(updatable = false, unique = true)
        private String name;
        @NotEmpty(message = "El Nombre no debe ser vacio")
        @NotBlank(message="El Nombre es incorrecto")
        @Column(updatable = false, unique = true)
        private String symbol;
        private int rank;

        @OneToMany(cascade = CascadeType.MERGE, mappedBy = "currency")
        @JsonManagedReference
        private List<Quote> quoteList;
}