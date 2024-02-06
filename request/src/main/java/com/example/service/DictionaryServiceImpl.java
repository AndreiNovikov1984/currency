package com.example.service;

import com.example.configuration.RequestParameters;
import com.example.dictionaries.Item;
import com.example.dictionaries.ValCursShort;
import com.example.dictionaries.Valuta;
import com.example.dictionaries.ValuteShort;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
@Slf4j
@Getter
@RequiredArgsConstructor
public class DictionaryServiceImpl implements DictionaryService{
    private final RequestParameters parameters;
    private final Map<String, Item> dictionaryMap = new HashMap<>();
    private final ReaderXML readerXML;

    @PostConstruct
    void dictionarePrepare() {
        updateDictionary();
    }

    @Scheduled(cron = "0 0 3 * * ?")
    public void updateDictionaryScheduller(){
        updateDictionary();
    }

    private void updateDictionary(){
        ValCursShort valCursShort = readerXML.getAllCurrencyShort(null);
        Valuta valuta = readerXML.getDictionary(Valuta.class);
        Map<String, Item> temporaryMap = new HashMap<>();
        for (Item item : valuta.getItems()){
            temporaryMap.put(item.getId(), item);
        }
        Optional<Item> item;
        for (ValuteShort valute : valCursShort.getValute()) {
            item = Optional.of(temporaryMap.get(valute.getId()));
            item.ifPresent(value -> dictionaryMap.put(valute.getCharCode(), value));
        }
        log.info("Справочник валют успешно обновлен, внесено {} валют", dictionaryMap.size());
    }
}
