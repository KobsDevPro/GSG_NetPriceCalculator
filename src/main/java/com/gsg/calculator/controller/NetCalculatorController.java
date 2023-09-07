package com.gsg.calculator.controller;

import com.gsg.calculator.enums.CountryIso;
import com.gsg.calculator.service.NetCalculatorService;
import jakarta.validation.constraints.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@Validated
public class NetCalculatorController {

    @Autowired
    NetCalculatorService netCalculatorService;

    @GetMapping("/getNetPrice")
    public BigDecimal fetchNetPriceFromGrossPriceByCountry(@RequestParam @NotBlank @Positive String grossPrice, @RequestParam @NotBlank String countryIso) {

        return netCalculatorService.calculateNetPriceFromGrossByCountry(new BigDecimal(grossPrice), CountryIso.valueOf(countryIso));
    }
}
