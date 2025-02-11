package co.com.poli.taller1.taller1.service;

import co.com.poli.taller1.taller1.domain.Currency;
import co.com.poli.taller1.taller1.domain.Quote;

import java.util.List;

public interface QuoteService {
    public List<Quote>  listAllQuotes();
    public Quote getQuote(Long id);
    public Quote createQuote(Quote quote);
    public Quote updateQuote(Quote quote);
    public Quote deleteQuote(Long id);
    public List<Quote> findByCurrency(Currency currency);



}
