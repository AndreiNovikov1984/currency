package com.example.currency.dto;

import lombok.Data;
import java.util.List;

@Data
public class ValCursDynamicDto {
    private String id;
    private String dateRange1;
    private String dateRange2;
    private List<RecordDto> record;
}
