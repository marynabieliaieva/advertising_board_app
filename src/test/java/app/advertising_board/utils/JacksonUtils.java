package app.advertising_board.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;

public class JacksonUtils {
    public static <T> T deserializeJson(String fileName, Class<T> T) throws IOException {
        InputStream filePath = JacksonUtils.class.getClassLoader().getResourceAsStream(fileName);
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(filePath, T);
    }
}
