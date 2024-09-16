package com.session.home.model;

import java.util.Date;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.session.home.util.JsonConverter;

public class User implements JsonConverter{
    private final ObjectMapper mapper = new ObjectMapper();
    private int id;
    private String username;
    private String password;
    private Date createdDate;
    private Date updatedDate;
    
    public User() {
		super();
		// TODO Auto-generated constructor stub
	}

    public User(String username, String password){
        super();
        this.username = username;
        this.password = password;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", username=" + username + ", password="+ password + "]";
    }

    @Override
    public String toJsonString() {
        return mapper.convertValue(this, Map.class).toString();
    }

    @SuppressWarnings("unchecked")
    @Override
    public Map<String, Object> toJson() {
        return mapper.convertValue(this, Map.class);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
