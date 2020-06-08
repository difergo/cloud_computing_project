package co.com.poli.taller1.taller1.service.impl;

import co.com.poli.taller1.taller1.domain.Currency;
import co.com.poli.taller1.taller1.domain.Quote;
import co.com.poli.taller1.taller1.repository.QuoteRepository;
import co.com.poli.taller1.taller1.service.QuoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuoteServiceImpl implements QuoteService {

    @Autowired
    private QuoteRepository quoteRepository;

    @Override
    public List<Quote> listAllQuotes() {
        return quoteRepository.findAll();
    }

    @Override
    public Quote getQuote(Long id) {
        return quoteRepository.findById(id).orElse(null);
    }

    @Override
    public Quote createQuote(Quote quote) {
        return quoteRepository.save(quote);
    }

    @Override
    public Quote updateQuote(Quote quote) {
        return null;
    }

    @Override
    public Quote deleteQuote(Long id) {
        return null;
    }

    @Override
    public List<Quote> findByCurrency(Currency currency) {
        return quoteRepository.findByCurrency(currency);
    }
}
