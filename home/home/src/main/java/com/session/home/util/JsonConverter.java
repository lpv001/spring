package com.session.home.util;

import java.util.Map;

public interface  JsonConverter {
    public String toJsonString();
	
	public Map<String, Object> toJson();
}
