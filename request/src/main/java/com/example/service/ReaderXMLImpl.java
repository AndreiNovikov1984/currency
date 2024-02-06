package com.example.service;

import com.example.configuration.RequestParameters;
import com.example.dictionaries.ValCursShort;
import com.example.model.ValCurs;
import com.example.model.ValCursDynamic;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

@Service
@Slf4j
@RequiredArgsConstructor
public class ReaderXMLImpl implements ReaderXML {
    private final RequestParameters parameters;
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");


    @Override
    public ValCurs getAllCurrency(@Nullable LocalDate date) {
        return getValue(parameters.getBaseUrl() + parameters.getCurrencyUrl() + checkDate(date), ValCurs.class);
    }

    @Override
    public ValCursShort getAllCurrencyShort(@Nullable LocalDate date) {
        return getValue(parameters.getBaseUrl() + parameters.getCurrencyUrl() + checkDate(date), ValCursShort.class);
    }

    public <T> T getDictionary(Class<T> className) {
        return getValue(parameters.getBaseUrl() + parameters.getDictionareUrl(), className);
    }

    @Override
    public ValCursDynamic getCurrencyDynamic(String currency, LocalDate dateFrom, LocalDate dateTo) {
        return getValue((parameters.getBaseUrl() + parameters.getDynamicUrl() + dateFrom.format(formatter) +
                "&date_req2=" + dateTo.format(formatter) + "&VAL_NM_RQ=" + currency), ValCursDynamic.class);
    }

    private <T> T getValue(String uri, Class<T> className) {
        try {
            URL url = new URL(uri);
            JAXBContext context = JAXBContext.newInstance(className);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            return (T) unmarshaller.unmarshal(url);
        } catch (Exception ex) {
            log.error("Error {}", ex.getMessage());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage());
        }
    }

    private String checkDate(@Nullable LocalDate date) {
        return Objects.requireNonNullElseGet(date, LocalDate::now).format(formatter);
    }

}
