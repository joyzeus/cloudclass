package com.igeek.common.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class JacksonUtil {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    static {
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
    }

    public static <T> String toJson(T t) {
        if (t instanceof String) {
            return t.toString();
        }
        String s = null;
        try {
            s = objectMapper.writeValueAsString(t);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            LogUtil.error("toJson 序列化异常 ", e);
        }
        return s;
    }

    public static JsonNode parseToJsonNode(String json) {
        JsonNode jsonNode = null;
        try {
            jsonNode = objectMapper.readTree(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonNode;
    }

    public static <T> T parseToObject(String json, Class<T> clazz) {
        T t = null;
        try {
            t = objectMapper.readValue(json, clazz);
        } catch (IOException e) {
            e.printStackTrace();
            LogUtil.error("fromJson 反序列化异常 ", e);
        }
        return t;
    }

    public static <T> List<T> parseToArray(String json, Class<T> clazz) {
        List<T> data = new ArrayList<>();
        try {
            JavaType javaType = getCollectionType(ArrayList.class, clazz);
            data = objectMapper.readValue(json, javaType);
        } catch (IOException e) {
            e.printStackTrace();
            LogUtil.error("fromJson 反序列化异常 ", e);
        }
        return data;
    }

    public static JavaType getCollectionType(Class<?> collectionClass, Class<?>... elementClasses) {
        return objectMapper.getTypeFactory().constructParametricType(collectionClass, elementClasses);
    }
}
