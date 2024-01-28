package com.example.currency.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@RequiredArgsConstructor
public class RequestCurrencyExchange extends Request{
    @Schema(description = "Название валюты, которую будем менять", example = "RUB",  requiredMode = Schema.RequiredMode.REQUIRED)
    private final String nameCurrencyFrom;
    @Schema(description = "Название валюты, на которую будем менять", example = "EUR",  requiredMode = Schema.RequiredMode.REQUIRED)
    private final String nameCurrencyTo;
    @Schema(description = "Сумма валюты, которую будем менять", example = "100",  requiredMode = Schema.RequiredMode.REQUIRED)
    private final Double value;

}
