package com.jc.eventbusdemo;

import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void testMock(){
        List<String> list = mock(ArrayList.class);
        when(list.get(anyInt())).thenReturn("first");
        list.add("one");
        list.add("two");

        verify(list,times(1)).add("one");

        System.out.println(list.get(999));
        assertEquals(list.get(999),"first");
    }

    @Mock
    private List<String> arraylist;
    @Test
    public void testArraylist(){
        MockitoAnnotations.initMocks(this);
        arraylist.add("one");
        verify(arraylist,times(1)).add("one");
    }
}