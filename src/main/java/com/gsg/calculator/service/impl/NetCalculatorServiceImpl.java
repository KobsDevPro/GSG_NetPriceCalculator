package com.gsg.calculator.service.impl;

import com.gsg.calculator.enums.CountryIso;
import com.gsg.calculator.service.NetCalculatorService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;

@Service
public class NetCalculatorServiceImpl implements NetCalculatorService {

        public static Map<CountryIso, Double> taxRateProvider = new HashMap<>();

    /*
     * Adding valued to the map which will provide the tax according to each country.
     */
    static {
            taxRateProvider.put(CountryIso.DE, 0.19);
            taxRateProvider.put(CountryIso.FR, 0.20);
            taxRateProvider.put(CountryIso.IN, 0.12);
            taxRateProvider.put(CountryIso.AU, 0.10);
        }

    @Override
    public BigDecimal calculateNetPriceFromGrossByCountry(BigDecimal grossPrice, CountryIso countryIso) {
        BigDecimal tax = BigDecimal.valueOf(taxRateProvider.get(countryIso));

        /*
         * Calculating net price from gross and tax percentage;
         */
        BigDecimal netPrice = grossPrice.subtract(tax.multiply(grossPrice));
        return netPrice.round(new MathContext(2, RoundingMode.CEILING));
    }

}
