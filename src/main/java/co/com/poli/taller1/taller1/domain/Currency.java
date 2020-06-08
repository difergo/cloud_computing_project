package co.com.poli.taller1.taller1.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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

    private String name;
    private String symbol;
    private int rank;
}