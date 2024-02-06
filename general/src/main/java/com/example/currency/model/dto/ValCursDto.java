package com.example.currency.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@Data
public class ValCursDto {
    @Size(min = 8, max = 8)
    @Pattern(message = "Формат даты не соответствует ddMMyyyy: ${validatedValue}", regexp = "^\\d{4}\\d{2}\\d{2}$")
    @Schema(example = "24012001",  requiredMode = Schema.RequiredMode.REQUIRED, description = "Дата запроса курса валют")
    private String date;
    @Valid
    @NotNull
    private List<ValuteDto> valute;

}
