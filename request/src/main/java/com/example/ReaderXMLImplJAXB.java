package com.example;

import com.example.model.ValCurs;
import com.example.model.ValCursDynamic;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.net.URL;

@Primary
@Service
@Slf4j
public class ReaderXMLImplJAXB implements ReaderXML {

    @Override
    public ValCurs getAllCurrency(String date) {
        ValCurs currency;
        try {
            URL url = new URL("http://www.cbr.ru/scripts/XML_daily.asp?date_req=" + date);
            JAXBContext context = JAXBContext.newInstance(ValCurs.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            currency = (ValCurs) unmarshaller.unmarshal(url);
        } catch (Exception ex) {
            log.error("Error {}", ex.getMessage());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage());
        }
        return currency;
    }

    @Override
    public ValCursDynamic getCurrencyDynamic(String currency, String dateFrom, String dateTo) {
        ValCursDynamic valCursDynamic;
        try {
            URL url = new URL("http://www.cbr.ru/scripts/XML_dynamic.asp?date_req1=" +
                    dateFrom + "&date_req2=" + dateTo + "&VAL_NM_RQ=" + currency);
            JAXBContext context = JAXBContext.newInstance(ValCursDynamic.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            valCursDynamic = (ValCursDynamic) unmarshaller.unmarshal(url);
        } catch (Exception ex) {
            log.error("Error {}", ex.getMessage());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage());
        }
        return valCursDynamic;
    }

}
