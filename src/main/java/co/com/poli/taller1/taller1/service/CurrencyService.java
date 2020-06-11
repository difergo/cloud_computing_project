package co.com.poli.taller1.taller1.service;

import co.com.poli.taller1.taller1.domain.Currency;
import co.com.poli.taller1.taller1.domain.Quote;

import java.util.List;

public interface CurrencyService {
    public List<Currency>  listAllCurrencies();
    public Currency createCurrency(Currency currency);
    public Currency getCurrencyById(Long id);
    public Currency getCurrencyByName(String name);
}
