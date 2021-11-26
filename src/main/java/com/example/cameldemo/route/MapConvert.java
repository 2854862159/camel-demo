package com.example.cameldemo.route;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.camel.Converter;
import org.apache.camel.TypeConverters;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

/**
 * ClassName: MapConvert <br/>
 * Description: <br/>
 * date: 2021/11/22 11:58 上午<br/>
 *
 * @author tooru<br />
 */
@Converter
public class MapConvert implements TypeConverters {

    ObjectMapper objectMapper = new ObjectMapper();

    @Converter
    public Map toMap(InputStream inputStream) throws IOException {
        return objectMapper.readValue(inputStream, Map.class);
    }
}
