package com.example.configuration;

import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Configuration
@ConfigurationProperties(prefix = "currency.request")
public class RequestParameters {
    private final String baseUrl = "http://www.cbr.ru/scripts/XML";
    private final String currencyUrl = "_daily.asp?date_req=";
    private final String dynamicUrl = "_dynamic.asp?date_req1=";
    private final String dictionareUrl = "_val.asp?d=0";
    private final String dictionaryUpdateCron = "0 0 1 * * ?";
}
