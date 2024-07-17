package com.learning.mockito.mockito_tutorial.list;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ListTest {

    @Test
    void SimpleTest(){
        List listMock = mock(List.class);
        // Creating mock on List Interface.
        //listMock.size() => 3
        when(listMock.size()).thenReturn(3);

        assertEquals(3,listMock.size());
    }

    // Whenever we are mocking a fn we can return multiple values.
    @Test
    void multipleTest(){
        List listMock = mock(List.class);
        when(listMock.size()).thenReturn(1).thenReturn(2);
        assertEquals(1,listMock.size());
        assertEquals(2,listMock.size());
        // Last, value will be the default value if we call it multiple times. In this case it will be 2.
        assertEquals(2,listMock.size());
    }

    //Mocking features where parameters are passed.
    @Test
    void parameters(){
        List listMock = mock(List.class);
        when(listMock.get(0)).thenReturn("Something");
        assertEquals("Something",listMock.get(0));
        // When we call for 1 without returning by default it will return null.
        assertEquals(null, listMock.get(1));

    }
}
