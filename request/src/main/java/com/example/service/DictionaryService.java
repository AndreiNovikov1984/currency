package com.example.service;

import com.example.dictionaries.Item;

import java.util.Map;

public interface DictionaryService {
    /**
     * Периодическая задача получения справочников валют
     */
    void updateDictionaryScheduller();

    /**
     * Метод обработки запроса на получение справочника валют
     * @return справочник по валютам
     */
    Map<String, Item> getDictionaryMap();
}
