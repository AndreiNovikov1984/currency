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
@NoArgsConstructor
@AllArgsConstructor
public class RequestCurrency extends Request{
    @NotBlank
    @Size(min = 3, max = 3)
    @Pattern(message = "Буквенный код валюты не соответствует стандарту: ${validatedValue}", regexp = "\\b[A-Z]{3}\\b")
    @Schema(description = "Буквенный код валюты для запроса курса", example = "RUB",  requiredMode = Schema.RequiredMode.REQUIRED)
    protected String nameCurrency;
}
