package com.example.currency.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@RequiredArgsConstructor
public class RequestCurrencyDynamic extends RequestCurrency {
    @Schema(description = "Дата, с которой начать показ динамики курса валюты", example = "01012002",  requiredMode = Schema.RequiredMode.REQUIRED)
    private final String dateFrom;
    @Schema(description = "Дата, которой завершить показ динамики курса валюты", example = "31012002",  requiredMode = Schema.RequiredMode.REQUIRED)
    private final String dateTo;
}
