package com.learning.mockito.mockito_tutorial.buisness;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

//@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class SomeBusinessMockImplTest {

    @Mock
    private DataService dataServiceMock;
    // Interface on which mock is to be created.

    @InjectMocks
    private SomeBusinessImpl someBusiness;
    // Class where we need to inject the mock.

    @Test
    void test(){
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {25,14,3});
        assertEquals(25, someBusiness.findTheGreatestFromAllData());
    }
    @Test
    void test2(){
        DataService dataServiceMock = mock(DataService.class);
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {14});
        // Basically, we are mocking the DataService interface and the line 15 tells what to do when we retrieve data from the interface mock.
        SomeBusinessImpl someBusiness = new SomeBusinessImpl(dataServiceMock);
        int result = someBusiness.findTheGreatestFromAllData();
        assertEquals(14, result);
    }
    //Here, we can simply copy the method for another test-case.
}
