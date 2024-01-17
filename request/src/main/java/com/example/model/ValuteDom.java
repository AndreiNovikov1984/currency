package com.example.model;

import lombok.Data;

import java.util.HashMap;

@Data
public class ValuteDom {
    private HashMap<String, String> attributes  = new HashMap<>();

    private short numCode;
    private String charCode;
//    private String nominal;

    private String name;
    private String value;

    @Override
    public String toString() {
        return "ValuteDom{" +
                "attributes=" + attributes +
                ", numCode=" + numCode +
                ", charCode='" + charCode + '\'' +
                ", name='" + name + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
