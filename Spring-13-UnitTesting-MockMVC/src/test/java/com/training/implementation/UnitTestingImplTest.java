package com.training.implementation;

import com.training.repository.DataRepository;
import com.training.repository.DataRepositoryImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;
@ExtendWith(MockitoExtension.class)
class UnitTestingImplTest {

    @Mock
    DataRepository dataRepository;

    @InjectMocks
    UnitTestingImpl unitTesting;

    @Test
    void calculateSum() {

        UnitTestingImpl unitTesting = new UnitTestingImpl();
        int actual = unitTesting.calculateSum(new int[]{1,2,3});
        assertEquals(6, actual);

    }

    @Test
    void calculateSumUsingDataService(){
        DataRepositoryImpl dataRepository = new DataRepositoryImpl();

        UnitTestingImpl unitTesting = new UnitTestingImpl(dataRepository);
        int actual = unitTesting.calculateSumUsingDataService();
        assertEquals(6, actual);
    }

    @Test
    void calculateSumUsingDataService_Mock(){
        when(dataRepository.findAll()).thenReturn(new int[]{1,2,3}).thenReturn(new int[]{5,5,5});

        int actual = unitTesting.calculateSumUsingDataService();
        int actual2 = unitTesting.calculateSumUsingDataService();

        assertEquals(6, actual);
        assertEquals(15, actual2);
    }

    @Test
    void calculateSumUsingDataService_Mock_withParameter(){
        when(dataRepository.findById(anyInt())).thenReturn(new int[] {10,10,10});
        int actual = unitTesting.calculateSumUsingDataService_withParameter();
        assertEquals(30, actual);
    }


}