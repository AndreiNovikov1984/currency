package com.example.service;

import com.example.dictionaries.ValCursShort;
import com.example.model.ValCurs;
import com.example.model.ValCursDynamic;
import org.springframework.lang.Nullable;

import java.time.LocalDate;


public interface ReaderXML {

    ValCurs getAllCurrency(@Nullable LocalDate date);
    ValCursShort getAllCurrencyShort(@Nullable LocalDate date);

    <T> T getDictionary(Class<T> className);

    ValCursDynamic getCurrencyDynamic(String currency, LocalDate dateFrom, LocalDate dateTo);

}
