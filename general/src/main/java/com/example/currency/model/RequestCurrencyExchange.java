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
public class RequestCurrencyExchange extends Request{
    @NotBlank
    @Size(min = 3, max = 3)
    @Pattern(message = "Буквенный код валюты не соответствует стандарту: ${validatedValue}", regexp = "\\b[A-Z]{3}\\b")
    @Schema(description = "Буквенный код валюты, которую будем менять", example = "RUB",  requiredMode = Schema.RequiredMode.REQUIRED)
    private final String nameCurrencyFrom;
    @NotBlank
    @Size(min = 3, max = 3)
    @Pattern(message = "Буквенный код валюты не соответствует стандарту: ${validatedValue}", regexp = "\\b[A-Z]{3}\\b")
    @Schema(description = "Буквенный код валюты, на которую будем менять", example = "EUR",  requiredMode = Schema.RequiredMode.REQUIRED)
    private final String nameCurrencyTo;
    @NotBlank
    @Size(max = 50)
    @Pattern(message = "Сумма указана не верно: ${validatedValue}", regexp = "^\\d{50}$")
    @Schema(description = "Сумма валюты, которую будем менять", example = "100",  requiredMode = Schema.RequiredMode.REQUIRED)
    private final Double value;

}
