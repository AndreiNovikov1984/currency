package com.example.currency.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Setter
@SuperBuilder
@RequiredArgsConstructor
public class RequestCurrencyDynamic extends RequestCurrency {
    @NotNull
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Schema(description = "Дата начала показа динамики курса валюты", example = "01012002",  requiredMode = Schema.RequiredMode.REQUIRED)
    private final LocalDate dateFrom;
    @NotNull
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Schema(description = "Дата завершения показа динамики курса валюты", example = "31012002",  requiredMode = Schema.RequiredMode.REQUIRED)
    private final LocalDate dateTo;
}
