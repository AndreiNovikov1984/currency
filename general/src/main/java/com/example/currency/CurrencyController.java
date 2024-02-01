package com.example.currency;

import com.example.currency.dto.ValCursDto;
import com.example.currency.dto.ValCursDynamicDto;
import com.example.currency.model.Request;
import com.example.currency.model.RequestCurrency;
import com.example.currency.model.RequestCurrencyDynamic;
import com.example.currency.model.RequestCurrencyExchange;
import com.example.currency.service.CurrencyService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping(path = "/currency")
@RequiredArgsConstructor
@Slf4j
@Validated
public class CurrencyController {
    private final CurrencyService currencyService;

    @Operation(summary = "Запрос курсов всех валют на определенную дату", description = "если дата не задана - то на текущую")
    @PostMapping("/all")
    public ResponseEntity<ValCursDto> getAllCurrencyInfo(@Valid @RequestBody Request request) {
        log.info("Get info by All currency on date {}", request.getDate());
        return new ResponseEntity<>(currencyService.getAllCurrencyInfo(request.getDate()), HttpStatus.OK);
    }

    @Operation(summary = "Запрос курсов определенной валюты на определенную дату", description = "если дата не задана - то на текущую")
    @PostMapping("/current")
    public ResponseEntity<ValCursDto> getCurrencyInfo(@Valid @RequestBody RequestCurrency requestCurrency) {
        log.info("Get info by currency {} on date {}", requestCurrency.getNameCurrency(), requestCurrency.getDate());
        return new ResponseEntity<>(currencyService.getCurrencyInfo(requestCurrency.getNameCurrency(), requestCurrency.getDate()), HttpStatus.OK);
    }

    @Operation(summary = "Запрос динамики курса определенной валюты за определенный период", description = "результат выдается списком")
    @PostMapping("/dynamic/{nameCurrency}")
    public ResponseEntity<ValCursDynamicDto> getCurrencyDynamic(@Valid @RequestBody RequestCurrencyDynamic dynamic) {
        log.info("Get dynamic by currency {} from {} to {}", dynamic.getNameCurrency(), dynamic.getDateFrom(), dynamic.getDateTo());
        return new ResponseEntity<>(currencyService.getCurrencyDynamic(dynamic.getNameCurrency(), dynamic.getDateFrom(),
                dynamic.getDateTo()), HttpStatus.OK);
    }

    @Operation(summary = "Запрос расчета обмена одной валюты на другую по курсу на определенную дату", description = "если дата не задана - то на текущую")
    @PostMapping("/{nameCurrencyFrom}/exchange/{nameCurrencyTo}")
    public ResponseEntity<Double> getExchangeCurrency(@Valid @RequestBody RequestCurrencyExchange exchange) {
        log.info("Get exchange value = {} from currency {} to currency {} on date {}", exchange.getValue(),
                exchange.getNameCurrencyFrom(), exchange.getNameCurrencyTo(), exchange.getDate());
        return new ResponseEntity<>(currencyService.getExchangeCurrency(exchange.getNameCurrencyFrom(), exchange.getNameCurrencyTo(),
                exchange.getValue(), exchange.getDate()), HttpStatus.OK);
    }

}