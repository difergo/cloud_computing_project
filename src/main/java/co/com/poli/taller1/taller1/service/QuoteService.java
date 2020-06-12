package co.com.poli.taller1.taller1.service;

import co.com.poli.taller1.taller1.domain.Currency;
import co.com.poli.taller1.taller1.domain.Quote;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface QuoteService {
    public List<Quote>  listAllQuotes();
    public Quote getQuote(Long id);
    public void createQuote(Quote quote);
    public Quote updateQuote(Quote quote);
    public Quote deleteQuote(Long id);
    public List<Quote> findByCurrency(Currency currency);
    public ResponseEntity<?> getResultMap();
}
