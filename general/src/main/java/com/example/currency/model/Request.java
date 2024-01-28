package com.example.currency.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class Request {
//    @Pattern(message = "Формат даты не соответствует ddMMyyyy: ${validatedValue}", regexp = "^\\d{4}\\d{2}\\d{2}$")
    @Schema(example = "24012001",  requiredMode = Schema.RequiredMode.NOT_REQUIRED, description = "Дата для запроса курса валют")
    protected String date;
}
