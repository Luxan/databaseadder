package com.decerto.databaseadder.services;

import java.util.stream.IntStream;

public class RandomIntegersGeneratorService implements IRandomDataGeneratorService<Integer> {

    @Override
    public Integer[] generate() {
        return IntStream.rangeClosed(1, 100)
                .map(i -> (int) (Math.random() * 101))
                .boxed()
                .toArray(Integer[]::new);
    }
}
