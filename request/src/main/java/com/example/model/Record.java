package com.example.model;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class Record {

    @XmlAttribute(name = "Date")
    private String date;

    @XmlAttribute(name = "Id")
    private String id;

    @XmlElement(name = "Value")
    private String value;
}
