package co.com.poli.taller1.taller1.repository;

import co.com.poli.taller1.taller1.domain.Currency;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyRepository extends JpaRepository<Currency,Long> {
}
