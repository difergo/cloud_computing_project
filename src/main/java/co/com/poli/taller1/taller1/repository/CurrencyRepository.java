package co.com.poli.taller1.taller1.repository;

import co.com.poli.taller1.taller1.domain.Currency;
import co.com.poli.taller1.taller1.domain.Quote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CurrencyRepository extends JpaRepository<Currency,Long> {

    @Query("SELECT c FROM Currency c WHERE c.name = ?1")
    Currency findByName(String name);

    @Query("SELECT c FROM Currency c ORDER by c.rank ASC")
    List<Currency> finAllOrderByRank();
}

