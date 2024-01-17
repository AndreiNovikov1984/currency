package com.example.currency;

import com.example.currency.dto.ValCursDto;
import com.example.currency.dto.ValCursDynamicDto;

public interface CurrencyService {
    ValCursDto getCurrencyInfo(String nameCurrency, String date);

    ValCursDto getAllCurrencyInfo(String date);

    ValCursDynamicDto getCurrencyDynamic(String nameCurrency, String dateFrom, String dateTo);

    Double getExchangeCurrency(String nameCurrencyFrom, String nameCurrencyTo, Double value, String date);
}
