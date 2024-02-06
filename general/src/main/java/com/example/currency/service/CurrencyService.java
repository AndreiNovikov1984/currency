package com.example.currency.service;

import com.example.currency.model.dto.ValCursDto;
import com.example.currency.model.dto.ValCursDynamicDto;

import java.time.LocalDate;

public interface CurrencyService {
    ValCursDto getAllCurrencyInfo(LocalDate date);
    ValCursDto getCurrencyInfo(String nameCurrency, LocalDate date);

    ValCursDynamicDto getCurrencyDynamic(String nameCurrency, LocalDate dateFrom, LocalDate dateTo);

    Double getExchangeCurrency(String nameCurrencyFrom, String nameCurrencyTo, Double value, LocalDate date);
}
