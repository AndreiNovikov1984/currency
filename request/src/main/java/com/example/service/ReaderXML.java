package com.example.service;

import com.example.dictionaries.ValCursShort;
import com.example.dictionaries.Valuta;
import com.example.model.ValCurs;
import com.example.model.ValCursDynamic;
import org.springframework.lang.Nullable;

import java.time.LocalDate;

public interface ReaderXML {
    /**
     * Получение курсов всех валют на указанную дату
     * @param date - дата, на которую будет получен курс, если не указано - то будет использована текущая дата
     * @return - данные курса всех доступных валют на запрошенную дату
     */
    ValCurs getAllCurrency(@Nullable LocalDate date);

    /**
     * Получение сокращенной информации о курсах всех валют
     * @param date - дата, на которую будет получен курс, если не указано - то будет использована текущая дата
     * @return - сокращенные данные курса всех доступных валют на запрошенную дату
     */
    ValCursShort getAllCurrencyShort(@Nullable LocalDate date);

    /**
     * Получение данных для справочника по всем валютам
     * @return - данные по соответствию названий валют кодам
     */
    Valuta getDictionary();

    /**
     * Получение динамики курса валюты за определенный интервал
     * @param currency - валюта
     * @param dateFrom - дата начала интервала запроса
     * @param dateTo - дата окончания интервала запроса
     * @return - данные по динамике курса
     */
    ValCursDynamic getCurrencyDynamic(String currency, LocalDate dateFrom, LocalDate dateTo);

}
