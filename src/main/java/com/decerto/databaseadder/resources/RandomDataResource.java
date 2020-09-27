package com.decerto.databaseadder.resources;

import com.decerto.databaseadder.services.IProcessingService;
import com.decerto.databaseadder.services.IRandomDataFromDatabaseRetrieverService;
import com.decerto.databaseadder.services.IRandomDataGeneratorService;
import com.decerto.databaseadder.services.IRandomDataRestApiFetchingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/data")
public class RandomDataResource {
    @Autowired
    IProcessingService processingService;
    @Autowired
    IRandomDataGeneratorService randomDataGeneratorService;
    @Autowired
    IRandomDataFromDatabaseRetrieverService randomDataFromDatabaseRetrieverService;
    @Autowired
    IRandomDataRestApiFetchingService randomDataRestApiFetchingService;


    @RequestMapping("/1")
    public Object[] getRandomData1() {
        Object[] generatedData = randomDataGeneratorService.generate();
        Object[] retrievedData = randomDataFromDatabaseRetrieverService.retrieve();

        Object[] result = new Object[generatedData.length];

        for (int index = 0; index < generatedData.length; index++) {
            result[index] = processingService.process(generatedData[index], retrievedData[index]);
        }

        return result;
    }

    @RequestMapping("/2")
    public Object[] getRandomData2() {
        Object[] generatedData = randomDataGeneratorService.generate();
        Object[] fetchedData = randomDataRestApiFetchingService.fetch();

        Object[] result = new Object[generatedData.length];

        for (int index = 0; index < generatedData.length; index++) {
            result[index] = processingService.process(generatedData[index], fetchedData[index]);
        }

        return result;
    }

    @RequestMapping("/3")
    public Object[] getRandomData3() {
        Object[] retrievedData = randomDataFromDatabaseRetrieverService.retrieve();
        Object[] fetchedData = randomDataRestApiFetchingService.fetch();

        Object[] result = new Object[retrievedData.length];

        for (int index = 0; index < retrievedData.length; index++) {
            result[index] = processingService.process(retrievedData[index], fetchedData[index]);
        }

        return result;
    }
}
