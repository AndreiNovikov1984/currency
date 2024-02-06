package com.example.dictionaries;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@Data
@XmlRootElement(name = "Valuta")
@XmlAccessorType(XmlAccessType.FIELD)
public class Valuta {
    @XmlElement(name = "Item")
    private List<Item> items;
}
