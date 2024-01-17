package com.example.model;

import lombok.Data;

import javax.xml.bind.annotation.*;
import java.util.List;

@Data
@XmlRootElement(name="ValCurs")
@XmlAccessorType(XmlAccessType.FIELD)
public class ValCursDynamic {
    @XmlAttribute(name = "ID")
    private String id;

    @XmlAttribute(name = "DateRange1")
    private String dateRange1;

    @XmlAttribute(name = "DateRange2")
    private String dateRange2;

    @XmlElement(name="Record")
    private List<Record> record;
}
