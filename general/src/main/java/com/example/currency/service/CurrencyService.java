package com.example.currency.service;

import com.example.currency.dto.ValCursDto;
import com.example.currency.dto.ValCursDynamicDto;

import java.time.LocalDate;

public interface CurrencyService {
    ValCursDto getAllCurrencyInfo(LocalDate date);
    ValCursDto getCurrencyInfo(String nameCurrency, LocalDate date);

    ValCursDynamicDto getCurrencyDynamic(String nameCurrency, String dateFrom, String dateTo);

    Double getExchangeCurrency(String nameCurrencyFrom, String nameCurrencyTo, Double value, LocalDate date);
}
