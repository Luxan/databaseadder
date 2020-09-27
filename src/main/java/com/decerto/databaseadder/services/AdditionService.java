package com.decerto.databaseadder.services;

public class AdditionService implements IProcessingService<Integer> {
    @Override
    public Integer process(Integer first, Integer second) {
        return first + second;
    }
}
