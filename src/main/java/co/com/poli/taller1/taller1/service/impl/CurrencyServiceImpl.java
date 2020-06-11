package co.com.poli.taller1.taller1.service.impl;


import co.com.poli.taller1.taller1.domain.Currency;
import co.com.poli.taller1.taller1.domain.Quote;
import co.com.poli.taller1.taller1.exceptions.CurrencyUniqueNameException;
import co.com.poli.taller1.taller1.repository.CurrencyRepository;
import co.com.poli.taller1.taller1.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CurrencyServiceImpl implements CurrencyService {

    @Autowired
    private CurrencyRepository currencyRepository;

    @Override
    public Currency createCurrency(Currency currency) {
        if (currency.getName() != null) {
            currency.setName(currency.getName().toUpperCase());
        }
        currency.setId(0);
        try {
            return currencyRepository.save(currency);
        } catch (Exception e) {
            throw new CurrencyUniqueNameException("Currency Name/Symbol is already in use.");
        }
    }

    @Override
    public Currency getCurrencyById(Long id) {
        return currencyRepository.findById(id).orElse(null);
    }

    @Override
    public Currency getCurrencyByName(String name) { return currencyRepository.findByName(name); }

    @Override
    public List<Currency> listAllCurrencies() {
        return currencyRepository.findAll();
    }
}
