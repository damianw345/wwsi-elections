package com.github.damianw345.elections.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.JacksonXmlModule;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.github.damianw345.elections.model.area.Counties;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class XmlCountiesMapper {

    private static JacksonXmlModule xmlModule = new JacksonXmlModule();
    private static ObjectMapper objectMapper;

    static {
        xmlModule.setDefaultUseWrapper(false);
        objectMapper = new XmlMapper(xmlModule);
    }

    public static Counties deserializeCounties(String xml) throws JsonProcessingException {
        return objectMapper.readValue(xml, Counties.class);
    }
}
