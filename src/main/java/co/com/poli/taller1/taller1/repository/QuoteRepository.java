package co.com.poli.taller1.taller1.repository;

import co.com.poli.taller1.taller1.domain.Currency;
import co.com.poli.taller1.taller1.domain.Quote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuoteRepository extends JpaRepository<Quote,Long> {
    public List<Quote> findByCurrency(Currency currency);

}
