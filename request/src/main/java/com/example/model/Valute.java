package com.example.model;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class Valute {

    @XmlAttribute(name = "ID")
    private String id;

    @XmlElement(name="NumCode")
    private short numCode;

    @XmlElement(name="CharCode")
    private String charCode;

    @XmlElement(name="Name")
    private String name;

    @XmlElement(name="Value")
    private String value;
}
