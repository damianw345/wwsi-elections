package com.github.damianw345.elections.model.area;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class Counties {
    @JacksonXmlProperty(localName = "PowiatMiasto")
    String countyCity;
    @JacksonXmlProperty(localName = "Powiat")
    List<String> list;
}
