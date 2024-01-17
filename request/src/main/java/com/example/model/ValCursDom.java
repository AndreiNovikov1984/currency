package com.example.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Data
public class ValCursDom {
    private HashMap<String, String> attributes = new HashMap<>();

    private List<ValuteDom> valuteList = new ArrayList<>();


}
