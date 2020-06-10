package co.com.poli.taller1.taller1.service;

import co.com.poli.taller1.taller1.domain.Currency;
import co.com.poli.taller1.taller1.domain.Quote;

import java.util.List;

public interface CurrencyService {
    public Currency createCurrency(Currency currency);
    public Currency getCurrency(Long id);
}
