package com.example.currency.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class Request {
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Schema(example = "2001-24-01",  requiredMode = Schema.RequiredMode.NOT_REQUIRED, description = "Дата для запроса курса валют")
    protected LocalDate date;
}
