package com.example.currency.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
@Setter
@SuperBuilder
@RequiredArgsConstructor
public class RequestCurrencyDynamic extends RequestCurrency {
    @NotBlank
    @Size(min = 8, max = 8)
    @Pattern(message = "Формат даты не соответствует ddMMyyyy: ${validatedValue}", regexp = "^\\d{4}\\d{2}\\d{2}$")
    @Schema(description = "Дата начала показ динамики курса валюты", example = "01012002",  requiredMode = Schema.RequiredMode.REQUIRED)
    private final String dateFrom;
    @NotBlank
    @Size(min = 8, max = 8)
    @Pattern(message = "Формат даты не соответствует ddMMyyyy: ${validatedValue}", regexp = "^\\d{4}\\d{2}\\d{2}$")
    @Schema(description = "Дата завершения показ динамики курса валюты", example = "31012002",  requiredMode = Schema.RequiredMode.REQUIRED)
    private final String dateTo;
}
