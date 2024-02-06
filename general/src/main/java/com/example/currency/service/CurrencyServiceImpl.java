package com.example.currency.service;

import com.example.currency.CurrencyMapper;
import com.example.currency.model.dto.ValCursDto;
import com.example.currency.model.dto.ValCursDynamicDto;
import com.example.model.ValCurs;
import com.example.model.Valute;
import com.example.service.DictionaryService;
import com.example.service.ReaderXML;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CurrencyServiceImpl implements CurrencyService {
    private final ReaderXML readerXML;
    private final CurrencyMapper currencyMapper;
    private final DictionaryService dictionaryService;

    @Override
    public ValCursDto getAllCurrencyInfo(@Nullable LocalDate date) {
        return currencyMapper.convertValCursToDto(readerXML.getAllCurrency(date));
    }

    @Override
    public ValCursDto getCurrencyInfo(String nameCurrency, @Nullable LocalDate date) {
        ValCurs valCurs = readerXML.getAllCurrency(date);
        List<Valute> currency = valCurs.getValute().stream()
                .filter(p -> p.getCharCode().equalsIgnoreCase(nameCurrency))
                .collect(Collectors.toList());
        valCurs.setValute(currency);
        return currencyMapper.convertValCursToDto(valCurs);
    }

    @Override
    public ValCursDynamicDto getCurrencyDynamic(String nameCurrency, LocalDate dateFrom, LocalDate dateTo) {
        String currencyCode = dictionaryService.getDictionaryMap().get(nameCurrency).getId();
        return currencyMapper.convertValCursDynamicToDto(readerXML.getCurrencyDynamic(currencyCode, dateFrom,
                dateTo));
    }

    @Override
    public Double getExchangeCurrency(String nameCurrencyFrom, String nameCurrencyTo, Double value, @Nullable LocalDate date) {
        Double exchangeCurrnecyFrom =  getCurrencyInfo(nameCurrencyFrom, date).getValute().get(0).getValue();
        Double exchangeCurrnecyTo =  getCurrencyInfo(nameCurrencyTo, date).getValute().get(0).getValue();
        return  value * (exchangeCurrnecyFrom / exchangeCurrnecyTo);
    }
}
