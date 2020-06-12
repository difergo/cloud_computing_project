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
    public Currency getCurrencyByName(String name) {
        return currencyRepository.findByName(name);
    }

    @Override
    public List<Currency> findAllOrderByRank() {
        return currencyRepository.finAllOrderByRank();
    }

    @Override
    public List<Currency> listAllCurrencies() {
        return currencyRepository.findAll();
    }

    @Override
    public void updateRanks(Currency currency, double valorEnEuros) {
        List<Currency> currencies = findAllOrderByRank();
        int previousRank = 0;
        boolean found = false;
        if (currency.getRank() > 0) {
            for (int i = 0; i < currencies.size(); i++) {
                if (currencies.get(i).getRank() > 0) {
                    if (currencies.get(i).getId() == currency.getId()) {
                        currencies.get(i).setRank(0);
                        found = true;
                    } else {
                        if (found) {
                            currencies.get(i).setRank(currencies.get(i).getRank() - 1);
                            currencyRepository.save(currencies.get(i));
                        }
                    }
                }
            }
        }

        for (int i = 0; i < currencies.size(); i++) {
            if (currencies.get(i).getRank() > 0) {
                if (valorEnEuros < getsEuroValueFor(currencies.get(i))) {
                    currencies.get(i).setRank(currencies.get(i).getRank() + 1);
                    currencyRepository.save(currencies.get(i));
                } else {
                    previousRank = currencies.get(i).getRank();
                }
            }
        }

        currency.setRank(previousRank + 1);
        currencyRepository.save(currency);

    }

    private double getsEuroValueFor(Currency currency) {
        double euroValue = 0;

            switch (currency.getQuoteList().get(0).getName()) {
                case "DOLAR":
                    euroValue = currency.getQuoteList().get(0).getPrice() / 1.25;
                    break;

                case "LIBRA":
                    euroValue = currency.getQuoteList().get(0).getPrice() / 1.2;
                    break;

                case "EURO":
                    euroValue = currency.getQuoteList().get(0).getPrice() * 1;
                    break;
            }

        return euroValue;
    }
}
