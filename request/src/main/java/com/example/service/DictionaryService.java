package com.example.service;

import com.example.dictionaries.Item;

import java.util.Map;

public interface DictionaryService {
    void updateDictionaryScheduller();
    Map<String, Item> getDictionaryMap();
}
