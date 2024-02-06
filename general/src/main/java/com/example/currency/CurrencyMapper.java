package com.example.currency;

import com.example.currency.model.dto.RecordDto;
import com.example.currency.model.dto.ValCursDto;
import com.example.currency.model.dto.ValCursDynamicDto;
import com.example.currency.model.dto.ValuteDto;
import com.example.model.Record;
import com.example.model.ValCurs;
import com.example.model.ValCursDynamic;
import com.example.model.Valute;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring", uses = {ValCurs.class})
public interface CurrencyMapper {

    @Mapping(source = "value", target = "value", qualifiedByName = "convertStringToDouble")
    ValuteDto convertValuteToDto(Valute valute);

    @Mapping(source = "value", target = "value", qualifiedByName = "convertStringToDouble")
    RecordDto convertRecordToDto(Record record);

    List<ValuteDto> convertListValuteToDto(List<Valute> valutes);

    List<RecordDto> convertListRecordToDto(List<Record> valutes);


    ValCursDto convertValCursToDto(ValCurs valCurs);

    ValCursDynamicDto convertValCursDynamicToDto(ValCursDynamic valCursDynamic);


    @Named("convertStringToDouble")
    default Double convertStringToDouble(String value) {
        return Double.parseDouble(value.replace(",", "."));
    }
}
