package co.com.poli.taller1.taller1.service.impl;


import co.com.poli.taller1.taller1.domain.Currency;
import co.com.poli.taller1.taller1.exceptions.CurrencyUniqueNameException;
import co.com.poli.taller1.taller1.repository.CurrencyRepository;
import co.com.poli.taller1.taller1.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CurrencyServiceImpl implements CurrencyService {

    @Autowired
    private CurrencyRepository CurrencyRepository;

    @Override
    public Currency createCurrency(Currency currency) {
        if (currency.getName() != null) {
            currency.setName(currency.getName().toUpperCase());
        }
        try {
            return CurrencyRepository.save(currency);
        } catch (Exception e) {
            throw new CurrencyUniqueNameException("Currency name: " + currency.getName() + " is already in use.");
        }
    }

}
