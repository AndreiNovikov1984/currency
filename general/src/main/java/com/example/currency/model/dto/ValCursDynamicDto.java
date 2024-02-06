package com.example.currency.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@Data
public class ValCursDynamicDto {
    private String id;
    @NotBlank
    @Size(min = 8, max = 8)
    @Pattern(message = "Формат даты не соответствует ddMMyyyy: ${validatedValue}", regexp = "^\\d{4}\\d{2}\\d{2}$")
    @Schema(description = "Дата начала показ динамики курса валюты", example = "01012002",  requiredMode = Schema.RequiredMode.REQUIRED)
    private String dateRange1;
    @NotBlank
    @Size(min = 8, max = 8)
    @Pattern(message = "Формат даты не соответствует ddMMyyyy: ${validatedValue}", regexp = "^\\d{4}\\d{2}\\d{2}$")
    @Schema(description = "Дата завершения показ динамики курса валюты", example = "31012002",  requiredMode = Schema.RequiredMode.REQUIRED)
    private String dateRange2;
    @NotNull
    @Valid
    private List<RecordDto> record;
}
