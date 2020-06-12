package co.com.poli.taller1.taller1.service.impl;

import co.com.poli.taller1.taller1.domain.Currency;
import co.com.poli.taller1.taller1.domain.Quote;
import co.com.poli.taller1.taller1.repository.QuoteRepository;
import co.com.poli.taller1.taller1.service.CurrencyService;
import co.com.poli.taller1.taller1.service.QuoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuoteServiceImpl implements QuoteService {

    ResponseEntity<?> resultMap;

    @Autowired
    private CurrencyService currencyService;

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
    public void createQuote(Quote quote) {
        double valorEuro = 0;
        boolean correctName = true;

        if (quote.getName() != null) {
            quote.setName(quote.getName().toUpperCase());
        }

        switch (quote.getName()) {
            case "DOLAR":
                valorEuro = quote.getPrice() / 1.25;
                break;

            case "LIBRA":
                valorEuro = quote.getPrice() / 1.2;
                break;

            case "EURO":
                valorEuro = quote.getPrice();
                break;

            default:
                resultMap = new ResponseEntity<String>("El Nombre " + quote.getName() + " no es valido", HttpStatus.BAD_REQUEST);
                correctName = false;
        }

        if(correctName) {
            Currency currency = currencyService.getCurrencyById(quote.getCurrency().getId());
            boolean alreadyExists = false;
            for (Quote q : currency.getQuoteList()) {
                switch (q.getName()) {
                    case "DOLAR":
                        alreadyExists = "DOLAR".equals(quote.getName());
                        q.setPrice(valorEuro * 1.25);
                        break;

                    case "LIBRA":
                        alreadyExists = "LIBRA".equals(quote.getName());
                        q.setPrice(valorEuro * 1.2);
                        break;

                    case "EURO":
                        alreadyExists = "EURO".equals(quote.getName());
                        q.setPrice(valorEuro);
                        break;
                }
                quoteRepository.save(q);
            }

            Quote saveQuote;
            System.out.println(alreadyExists);
            if (!alreadyExists) {
                saveQuote = quoteRepository.save(quote);
                resultMap = new ResponseEntity<Quote>(saveQuote, HttpStatus.CREATED);
            } else {
                resultMap = new ResponseEntity<Quote>(quote, HttpStatus.ACCEPTED);
            }
            currencyService.updateRanks(currencyService.getCurrencyById(quote.getCurrency().getId()), valorEuro);
        }
    }

    @Override
    public ResponseEntity<?> getResultMap() {
        return resultMap;
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
