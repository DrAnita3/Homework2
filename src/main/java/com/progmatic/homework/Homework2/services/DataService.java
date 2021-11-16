package com.progmatic.homework.Homework2.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class DataService {

    @Value("${backend.url")
    private String serverUrl;

    /*public List<String> getDataFromBackend() {
        RestTemplate restTemplate = new RestTemplate();
        List<String> result = restTemplate.getForObject(serverUrl + "/data". ArrayList.class)
        return result;
    }*/





    public List<String> getDataList() {
        return Arrays.asList();
    }
}
