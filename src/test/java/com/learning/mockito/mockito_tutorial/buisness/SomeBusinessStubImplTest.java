package com.learning.mockito.mockito_tutorial.buisness;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class SomeBusinessStubImplTest {
    @Test
    void test(){
        DataServiceStub dataServiceStub = new DataServiceStub();
        SomeBusinessImpl someBusiness = new SomeBusinessImpl(dataServiceStub);
        int result = someBusiness.findTheGreatestFromAllData();
        assertEquals(24, result);
    }
}

class DataServiceStub implements DataService{

    @Override
    public int[] retrieveAllData() {
        return new int[] {10,24,5};
    }
}
