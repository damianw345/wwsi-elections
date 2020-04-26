package com.github.damianw345.elections;

import com.github.damianw345.elections.model.area.Counties;
import com.github.damianw345.elections.util.XmlCountiesMapper;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import static org.junit.Assert.assertFalse;

public class XmlCountiesMapperTest {

    @Test
    public void givenFileNameThenContentReadToString() throws IOException {
        String xml = inputStreamToString("counties.xml");
        assertFalse(xml.isBlank());
    }

    @Test
    public void givenXmlFileWhenDeserializeThenMappingIsCorrect() throws IOException {
        Counties counties = XmlCountiesMapper.deserializeCounties(inputStreamToString("counties.xml"));

        assertFalse(counties.getList().isEmpty());
        assertFalse(counties.getCountyCity().isBlank());
    }


    private String inputStreamToString(String resourceFilename) throws IOException {

        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(resourceFilename).getFile());

        FileInputStream fileInputStream = new FileInputStream(file);
        StringBuilder sb = new StringBuilder();
        String line;
        BufferedReader br = new BufferedReader(new InputStreamReader(fileInputStream));
        while ((line = br.readLine()) != null) {
            sb.append(line);
        }
        br.close();
        return sb.toString();
    }
}
