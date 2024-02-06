package com.example.currency.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
public class ValuteDto {
    @NotBlank
    @Size(min = 3, max = 3)
    @Pattern(message = "Буквенный код валюты не соответствует стандарту: ${validatedValue}", regexp = "\\b[A-Z]{3}\\b")
    @Schema(description = "Буквенный код валюты", example = "RUB",  requiredMode = Schema.RequiredMode.REQUIRED)
    private String charCode;
    @NotBlank
    @Size(max = 50)
    @Schema(description = "Название валюты", example = "RUB",  requiredMode = Schema.RequiredMode.REQUIRED)
    private String name;
    @NotBlank
    @Size(max = 20)
    @Schema(description = "Курс валюты", example = "154",  requiredMode = Schema.RequiredMode.REQUIRED)
    private Double value;
}
