package com.example.currency.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class RequestCurrency extends Request{
    @NotBlank
    @Schema(description = "Название валюты для запроса курса", example = "RUB",  requiredMode = Schema.RequiredMode.REQUIRED)
    protected String nameCurrency;
}
