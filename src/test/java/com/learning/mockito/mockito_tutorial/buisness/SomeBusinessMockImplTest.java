package com.learning.mockito.mockito_tutorial.buisness;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
public class SomeBusinessMockImplTest {
    @Test
    void test(){
        DataService dataServiceMock = mock(DataService.class);
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {25,14,3});
        // Basically, we are mocking the DataService interface and the line 15 tells what to do when we retrieve data from the interface mock.
        SomeBuisnessImpl someBusiness = new SomeBuisnessImpl(dataServiceMock);
        int result = someBusiness.findTheGreatestFromAllData();
        assertEquals(25, result);
    }
    @Test
    void test2(){
        DataService dataServiceMock = mock(DataService.class);
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {14});
        // Basically, we are mocking the DataService interface and the line 15 tells what to do when we retrieve data from the interface mock.
        SomeBuisnessImpl someBusiness = new SomeBuisnessImpl(dataServiceMock);
        int result = someBusiness.findTheGreatestFromAllData();
        assertEquals(14, result);
    }
    //Here, we can simply copy the method for another test-case.
}
