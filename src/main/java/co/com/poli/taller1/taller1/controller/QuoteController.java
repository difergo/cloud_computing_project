package co.com.poli.taller1.taller1.controller;

import co.com.poli.taller1.taller1.domain.Currency;
import co.com.poli.taller1.taller1.domain.Quote;
import co.com.poli.taller1.taller1.service.QuoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/Quote")
public class QuoteController {

    @Autowired
    private QuoteService quoteService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Quote> getProduct(@PathVariable("id") Long id) {
        Quote quote = quoteService.getQuote(id);

        if (quote == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(quote);
    }

    @GetMapping
    public ResponseEntity<String> test() {
        return ResponseEntity.ok("WORKING");
    }

}
