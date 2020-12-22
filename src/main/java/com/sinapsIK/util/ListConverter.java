/*
 * Copyright (C) 2019 Ahmet AKKUŞ <iletisim@algoritimbilisim.com>
 * Bu yazılımın tüm hakları Algoritim Bilişim'e aittir.
 */
package com.sinapsIK.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import javax.persistence.AttributeConverter;

/**
 *
 * @author Ahmet Akkuş <ahmedakkus.42@gmail.com>
 */
public class ListConverter implements AttributeConverter<List<Object>, String> {
    private final ObjectMapper objectMapper = new ObjectMapper();
    @Override
    public String convertToDatabaseColumn(List< Object> customerInfo) {
 
        String customerInfoJson = null;
        try {
            customerInfoJson = objectMapper.writeValueAsString(customerInfo);
        } catch (final JsonProcessingException e) {
            //logger.error("JSON writing error", e);
        }
 
        return customerInfoJson;
    }
 
    @Override
    public List< Object> convertToEntityAttribute(String customerInfoJSON) {
 
        List<Object> customerInfo = null;
        try {
            customerInfo = objectMapper.readValue(customerInfoJSON, List.class);
        } catch (final IOException e) {
            //logger.error("JSON reading error", e);
        }
 
        return  customerInfo;
    }
 
}
