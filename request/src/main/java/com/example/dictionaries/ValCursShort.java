package com.example.dictionaries;

import lombok.Data;

import javax.xml.bind.annotation.*;
import java.util.List;

@Data
@XmlRootElement(name = "ValCurs")
@XmlAccessorType(XmlAccessType.FIELD)
public class ValCursShort {
    @XmlAttribute(name = "Date")
    private String date;
    @XmlElement(name="Valute")
    private List<ValuteShort> valute;
}
