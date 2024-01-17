package com.example.currency.dto;

import lombok.Data;

import java.util.List;

@Data
public class ValCursDto {
    private String date;
    private List<ValuteDto> valute;

}
