package com.spring_authentication.home.utils;

import java.util.Map;

public interface JsonConverter {

    public String toJsonString();
    public Map<String, Object> toJson();

}
