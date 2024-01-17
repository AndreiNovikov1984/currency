package com.example.currency;

import com.example.currency.dto.ValCursDto;
import com.example.currency.dto.ValCursDynamicDto;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path = "/currency")
@RequiredArgsConstructor
@Slf4j
@Validated
public class CurrencyController {
    private final CurrencyService currencyService;


    @GetMapping("/all")
    public ResponseEntity<ValCursDto> getAllCurrencyInfo(@RequestParam(required = false) String date) {
        log.info("Get info by All currency on date {}", date);
        return new ResponseEntity<>(currencyService.getAllCurrencyInfo(date), HttpStatus.OK);
    }

    @GetMapping("/{nameCurrency}")
    public ResponseEntity<ValCursDto> getCurrencyInfo(@NonNull @PathVariable String nameCurrency,
                                                      @RequestParam(required = false) String date) {
        log.info("Get info by currency {} on date {}", nameCurrency, date);
        return new ResponseEntity<>(currencyService.getCurrencyInfo(nameCurrency, date), HttpStatus.OK);
    }

    @GetMapping("/dynamic/{nameCurrency}")
    public ResponseEntity<ValCursDynamicDto> getCurrencyDynamic(@NonNull @PathVariable String nameCurrency,
                                                                @NonNull @RequestParam String dateFrom,
                                                                @NonNull @RequestParam String dateTo) {
        log.info("Get dynamic by currency {} from {} to {}", nameCurrency, dateFrom, dateTo);
        return new ResponseEntity<>(currencyService.getCurrencyDynamic(nameCurrency, dateFrom, dateTo), HttpStatus.OK);
    }

    @GetMapping("/{nameCurrencyFrom}/exchange/{nameCurrencyTo}")
    public ResponseEntity<Double> getExchangeCurrency(@NonNull @PathVariable String nameCurrencyFrom,
                                                      @NonNull @PathVariable String nameCurrencyTo,
                                                      @NonNull @RequestParam Double value,
                                                      @RequestParam(required = false) String date) {
        log.info("Get exchange value = {} from currency {} to currency {} on date {}", value, nameCurrencyFrom, nameCurrencyTo, date);
        return new ResponseEntity<>(currencyService.getExchangeCurrency(nameCurrencyFrom, nameCurrencyTo, value, date), HttpStatus.OK);
    }

}