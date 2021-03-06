package com.training.implementation;

import com.training.repository.DataRepository;
import com.training.repository.DataRepositoryImpl;

import java.util.Arrays;

public class UnitTestingImpl {

    DataRepository dataRepository;

    public UnitTestingImpl(DataRepository dataRepository) {
        this.dataRepository = dataRepository;
    }



    // hard coded data
    public int calculateSum(int [] data){
        int sum = 0;
        return Arrays.stream(data).sum();
    }

    // data from database
    public int calculateSumUsingDataService(){
        int sum = 0;
        return Arrays.stream(dataRepository.findAll()).sum();
    }

    public int calculateSumUsingDataService_withParameter(){
        int sum = 0;
        return Arrays.stream(dataRepository.findById(2)).sum();
    }

}
