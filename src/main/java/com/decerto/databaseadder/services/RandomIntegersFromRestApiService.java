package com.decerto.databaseadder.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;


public class RandomIntegersFromRestApiService implements IRandomDataRestApiFetchingService<Integer> {

    @Autowired
    RestTemplate restTemplate;

    @Override
    public Integer[] fetch() {
        String response = restTemplate.getForObject("https://www.random.org/integers/?num=100&min=0&max=100&col=1&base=10&format=plain&rnd=new", String.class);
        return collectArray(response);
    }

    private Integer[] collectArray(String response) {
        String[] split = response.split("\n");
        return Arrays.stream(split)
                .map(Integer::parseInt)
                .toArray(Integer[]::new);
    }
}
