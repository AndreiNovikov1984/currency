package com.example.dictionaries;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class Item {
    @XmlAttribute(name = "ID")
    private String id;
    @XmlElement(name = "Name")
    private String name;
    @XmlElement(name = "EngName")
    private String engName;
    @XmlElement(name = "Nominal")
    private String nominal;
}
