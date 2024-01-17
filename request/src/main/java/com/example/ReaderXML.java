package com.example;

import com.example.model.ValCurs;
import com.example.model.ValCursDynamic;


public interface ReaderXML {

    ValCurs getAllCurrency(String date);

    ValCursDynamic getCurrencyDynamic(String currency, String dateFrom, String dateTo);

}
