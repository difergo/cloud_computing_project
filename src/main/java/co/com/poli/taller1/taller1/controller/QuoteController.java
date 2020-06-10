package co.com.poli.taller1.taller1.controller;

import co.com.poli.taller1.taller1.domain.Currency;
import co.com.poli.taller1.taller1.domain.Quote;
import co.com.poli.taller1.taller1.service.MapValidationErrorService;
import co.com.poli.taller1.taller1.service.QuoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/Quote")
public class QuoteController {

    @Autowired
    private QuoteService quoteService;

    @Autowired
    private MapValidationErrorService validationErrorService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Quote> getCurrency(@PathVariable("id") Long id) {
        Quote quote = quoteService.getQuote(id);

        if (quote == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(quote);
    }

    @GetMapping
    public ResponseEntity<List<Quote>> getListquotes(@RequestParam(name = "currency_id", required = false) Long currencyId){
        List<Quote> quotes = new ArrayList<>();
        if(currencyId==null){
            quotes = quoteService.listAllQuotes();
            if(quotes.isEmpty()){
                return ResponseEntity.noContent().build();
            }
        }else{
            quotes = quoteService.findByCurrency(Currency.builder().id(currencyId).build());
            if(quotes.isEmpty()){
                return ResponseEntity.noContent().build();
            }
        }
        return ResponseEntity.ok(quotes);
    }

    @PostMapping
    public ResponseEntity<?> createQuote(@Valid @Positive @RequestBody Quote quote, BindingResult result){
        ResponseEntity<?> errorMap = validationErrorService.MapValidationService(result);
        if(errorMap != null) return errorMap;
        else {
            Quote quoteCreated = quoteService.createQuote(quote);
            return ResponseEntity.status(HttpStatus.CREATED).body(quoteCreated);
        }
    }
}
