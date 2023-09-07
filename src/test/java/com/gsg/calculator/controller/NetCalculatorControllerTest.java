package com.gsg.calculator.controller;

import com.gsg.calculator.enums.CountryIso;
import com.gsg.calculator.service.NetCalculatorService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.math.BigDecimal;

@WebMvcTest(NetCalculatorController.class)
public class NetCalculatorControllerTest {

    @MockBean
    NetCalculatorService netCalculatorService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldReturnOkStatusForNetPriceCalculation() throws Exception {
        BigDecimal result = new BigDecimal(81);
        //given
        Mockito.when(netCalculatorService.calculateNetPriceFromGrossByCountry(BigDecimal.valueOf(100), CountryIso.DE)).thenReturn(result);
        // when
        MockHttpServletResponse response =
                mockMvc.perform(MockMvcRequestBuilders.get("/getNetPrice?grossPrice=100&countryIso=DE")).andReturn().getResponse();

        // then
        Assertions.assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        Assertions.assertThat(response.getContentAsString()).isEqualTo(result.toString());
    }

    @Test
    public void shouldReturnErrorStatusForNetPriceCalculation() throws Exception {
        BigDecimal result = new BigDecimal(81);
        //given
        Mockito.when(netCalculatorService.calculateNetPriceFromGrossByCountry(BigDecimal.valueOf(100), CountryIso.DE)).thenReturn(result);
        // when
        MockHttpServletResponse response =
                mockMvc.perform(MockMvcRequestBuilders.get("/getNetPrice?grossPrice=100&countryIso=RE")).andReturn().getResponse();

        // then
        Assertions.assertThat(response.getStatus()).isEqualTo(HttpStatus.BAD_REQUEST.value());
    }
}
