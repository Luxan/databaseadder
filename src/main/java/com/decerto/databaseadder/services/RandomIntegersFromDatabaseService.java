package com.decerto.databaseadder.services;

import com.decerto.databaseadder.models.IntegerDataContainer;
import com.decerto.databaseadder.repositories.IntegerDataContainerRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class RandomIntegersFromDatabaseService implements IRandomDataFromDatabaseRetrieverService<Integer> {

    @Autowired
    IntegerDataContainerRepository integerDataContainerRepository;

    @Override
    public Integer[] retrieve() {
        List<IntegerDataContainer> all = (List<IntegerDataContainer>) integerDataContainerRepository.findAll();
        if (all.size() < 100) {
            initializeDB();
            return retrieve();
        }

        return all.stream().map(IntegerDataContainer::getData).toArray(Integer[]::new);
    }

    private void initializeDB() {
        int[] orderedNumbers = IntStream.range(0, 100).toArray();
        List<Integer> collect = Arrays.stream(orderedNumbers)
                .boxed()
                .map(Integer::new)
                .collect(Collectors.toList());
        Collections.shuffle(collect);
        collect.forEach(number -> integerDataContainerRepository.save(new IntegerDataContainer(number)));
    }

}
