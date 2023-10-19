package com.weather.prediction.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;

@Service
public class MessageService {

    private final String DEFAULT = "Default";

    public String getMessage(String key) {
        try {
            File jsonFile = new File(MessageService.class.getClassLoader().getResource("message.json").getPath());
            JsonNode rootNode = new ObjectMapper().readTree(jsonFile);
            if(rootNode.has(key))
                return rootNode.get(key).asText();
            else
                return rootNode.get(DEFAULT).asText();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
}
