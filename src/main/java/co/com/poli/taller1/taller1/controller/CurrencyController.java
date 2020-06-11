package co.com.poli.taller1.taller1.controller;

import co.com.poli.taller1.taller1.domain.Currency;
import co.com.poli.taller1.taller1.service.CurrencyService;
import co.com.poli.taller1.taller1.service.MapValidationErrorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/Currency")
public class CurrencyController {

    @Autowired
    private CurrencyService currencyService;

    @Autowired
    private MapValidationErrorService validationErrorService;

    @PostMapping
    public ResponseEntity<?> createCurrency(@Valid @RequestBody Currency currency, BindingResult result) {
        ResponseEntity<?> errorMap = validationErrorService.MapValidationService(result);
        if (errorMap != null) return errorMap;
        else {
            Currency currencyCreated = currencyService.createCurrency(currency);
            return ResponseEntity.status(HttpStatus.CREATED).body(currencyCreated);
        }
    }

    @GetMapping(value = "/id/{id}")
    public ResponseEntity<Currency> getCurrencyId(@PathVariable("id") Long id) {
        Currency currency = currencyService.getCurrencyById(id);

        if (currency == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(currency);
    }

    @GetMapping(value = "/{name}")
    public ResponseEntity<Currency> getCurrencyByName(@PathVariable("name") String name) {
        Currency currency = currencyService.getCurrencyByName(name.toUpperCase());

        if (currency == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(currency);
    }


    @GetMapping
    public ResponseEntity<List<Currency>> getListCurrecies() {
        List<Currency> currencies = new ArrayList<>();

        currencies = currencyService.listAllCurrencies();
        if (currencies.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(currencies);
    }
}
