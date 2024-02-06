package com.example.currency.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
public class RecordDto {
    @Size(min = 8, max = 8)
    @Pattern(message = "Формат даты не соответствует ddMMyyyy: ${validatedValue}", regexp = "^\\d{4}\\d{2}\\d{2}$")
    @Schema(example = "24012001",  requiredMode = Schema.RequiredMode.REQUIRED, description = "Дата запроса курса валют")
    private String date;
    @NotBlank
    @Size(max = 20)
    @Schema(description = "Курс валюты", example = "154",  requiredMode = Schema.RequiredMode.REQUIRED)
    private Double value;
}
