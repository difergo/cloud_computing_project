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

    ResponseEntity<String> errorMap;

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
    public Quote createQuote(Quote quote) {
        double valorEuro;
        if(quote.getName() != null) {
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
                errorMap = new ResponseEntity<String>("El Nombre " + quote.getName() + " no es valido", HttpStatus.BAD_REQUEST);
                return null;
        }

        Currency currency = currencyService.getCurrencyById(quote.getCurrency().getId());
        for(Quote q:currency.getQuoteList()){
            switch (q.getName()) {
                case "DOLAR":
                    q.setPrice(quote.getPrice() / 1.25);
                    break;

                case "LIBRA":
                    q.setPrice(quote.getPrice() / 1.2);
                    break;

                case "EURO":
                    q.setPrice(valorEuro);
                    break;
            }
        }

        if() {
            Quote saveQuote = quoteRepository.save(quote);
        }

        //updateRanks(quote.getId());



        return saveQuote;
    }





    public ResponseEntity<String> getErrorMap(){
        return errorMap;
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
