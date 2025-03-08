package com.kunalTTN;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ListTest {
    @Test
    public void testListMock()
    {
        List listMock = mock(List.class);
        when(listMock.size()).thenReturn(2);
        assertEquals(2,listMock.size());
        assertEquals(2,listMock.size());
        assertEquals(2,listMock.size());
    }    @Test
    public void testListMock_MultipleValues()
    {
        List listMock = mock(List.class);
        when(listMock.size()).thenReturn(2).thenReturn(3);

        // now return will be 2
//        assertEquals(3,listMock.size()); Fail
        assertEquals(2,listMock.size());

        // returned value will not be 2
//        assertEquals(2,listMock.size()); Fail
        assertEquals(3,listMock.size());
        assertEquals(3,listMock.size());
    }
    @Test
    public void testListMock_ArgumentMatchers()
    {
        List listMock = mock(List.class);
        when(listMock.get(anyInt())).thenReturn(2).thenReturn(3);
        assertEquals(2,listMock.get(1));
        assertEquals(3,listMock.get(2));
        assertEquals(3,listMock.get(4));
    }
    @Test
    public void testListMock_MultipleArgumentMatchers()
    {
        List listMock = mock(List.class);
//        when(listMock.subList(anyInt(),4)).thenReturn(List.of(1,2,3));

        when(listMock.subList(anyInt(),anyInt())).thenReturn(List.of(1,2,3));
        when(listMock.subList(4,9)).thenReturn(List.of(2,4,6));

        List<Integer> list1=listMock.subList(2,4);
        System.out.println(list1);

        List<Integer> list2=listMock.subList(4,9);
        System.out.println(list2);

    }

}
