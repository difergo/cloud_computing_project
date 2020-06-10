package co.com.poli.taller1.taller1.controller;

import co.com.poli.taller1.taller1.domain.Currency;
import co.com.poli.taller1.taller1.domain.Quote;
import co.com.poli.taller1.taller1.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/Currency")
public class CurrencyController {

    @Autowired
    private CurrencyService currencyService;


    @PostMapping
    public ResponseEntity<Currency> createCurrency(@RequestBody Currency currency){
        Currency currencyCreated = currencyService.createCurrency(currency);
        return ResponseEntity.status(HttpStatus.CREATED).body(currencyCreated);
    }


    @GetMapping(value = "/{id}")
    public ResponseEntity<Currency> getCurrency(@PathVariable("id") Long id) {
        Currency currency = currencyService.getCurrency(id);

        if (currency == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(currency);
    }

    @GetMapping
    public ResponseEntity<String> test() {
        return ResponseEntity.ok("WORKING");
    }

}
