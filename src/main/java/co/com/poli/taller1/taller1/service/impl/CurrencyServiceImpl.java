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
        try {
            return currencyRepository.save(currency);
        } catch (CurrencyUniqueNameException e) {
            throw new CurrencyUniqueNameException("Currency name: " + currency.getName() + " is already in use.");
        }
    }

    @Override
    public Currency getCurrency(Long id) {
        return currencyRepository.findById(id).orElse(null);
    }


}
