package co.com.poli.taller1.taller1.service.impl;


import co.com.poli.taller1.taller1.domain.Currency;
import co.com.poli.taller1.taller1.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CurrencyServiceImpl implements CurrencyService {

    @Autowired
    private co.com.poli.taller1.taller1.repository.CurrencyRepository CurrencyRepository;

    @Override
    public Currency createCurrency(Currency currency) {
        return CurrencyRepository.save(currency);
    }

}
