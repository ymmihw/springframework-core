package com.ymmihw.springframework.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiClient {
    private String name;
    private String url;
    private String key;
    public String getConnectionProperties() {
        return "Connecting to " + name + " at " + url;
    }
}