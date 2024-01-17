package com.example.currency;

import com.example.ReaderXML;
import com.example.currency.dto.ValCursDto;
import com.example.currency.dto.ValCursDynamicDto;
import com.example.model.ValCurs;
import com.example.model.Valute;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CurrencyServiceImpl implements CurrencyService {
    private final ReaderXML readerXML;
    private final CurrencyMapper currencyMapper;
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    @Override
    public ValCursDto getCurrencyInfo(String nameCurrency, @Nullable String date) {
        ValCurs valCurs = getAllCurrency(date);
        List<Valute> currency = valCurs.getValute().stream()
                .filter(p -> p.getCharCode().equalsIgnoreCase(nameCurrency))
                .collect(Collectors.toList());
        valCurs.setValute(currency);
        return currencyMapper.convertValCursToDto(valCurs);
    }

    @Override
    public ValCursDto getAllCurrencyInfo(String date) {
        return currencyMapper.convertValCursToDto(getAllCurrency(date));
    }

    @Override
    public ValCursDynamicDto getCurrencyDynamic(String nameCurrency, String dateFrom, String dateTo) {
        return currencyMapper.convertValCursDynamicToDto(readerXML.getCurrencyDynamic(nameCurrency, dateFrom, dateTo));
    }

    @Override
    public Double getExchangeCurrency(String nameCurrencyFrom, String nameCurrencyTo, Double value, String date) {
        Double exchangeCurrnecyFrom =  getCurrencyInfo(nameCurrencyFrom, date).getValute().get(0).getValue();
        Double exchangeCurrnecyTo =  getCurrencyInfo(nameCurrencyTo, date).getValute().get(0).getValue();
        return  value * (exchangeCurrnecyFrom / exchangeCurrnecyTo);
    }

    private ValCurs getAllCurrency(String date) {
        if (date == null) {
            date = LocalDate.now().format(formatter);
        }
        return readerXML.getAllCurrency(date);
    }
}
