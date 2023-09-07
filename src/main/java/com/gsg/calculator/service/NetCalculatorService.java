package com.gsg.calculator.service;

import com.gsg.calculator.enums.CountryIso;

import java.math.BigDecimal;

public interface NetCalculatorService {
    BigDecimal calculateNetPriceFromGrossByCountry(BigDecimal grossPrice, CountryIso countryIso);
}
