package com.kunalTTN;


import com.kunalTTN.business.TodoBusinessImpl;
import com.kunalTTN.service.TodoService;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.*;

public class test {
    @Test
    public void testWithStub()
    {
        TodoService todoService = new TodoServiceStub();
        TodoBusinessImpl todoBusiness= new TodoBusinessImpl(todoService);
        List<String> todos=todoBusiness.retrieveTodosRelatedToSpring("Dummy");
        assertEquals(2,todos.size());
    }
    @Test
    public void testWithMock()
    {
        TodoService todoService= mock(TodoService.class);
        List<String> todos = Arrays.asList("List of Spring", "Learn Spring", "Bootcamp");
        when(todoService.retrieveTodos("Dummy")).thenReturn(todos);
        TodoBusinessImpl todoBusiness = new TodoBusinessImpl(todoService);

//        todoService.retrieveTodos () will return no values if user is Kunal
//        List<String> filteredTodos=todoBusiness.retrieveTodosRelatedToSpring("Kunal");

//        todoService.retrieveTodos() will return all values if user is Dummy
        List<String> filteredTodos=todoBusiness.retrieveTodosRelatedToSpring("Dummy");

        assertEquals(2,filteredTodos.size());

    }
    @Test
    public void testWithMock_usingBDD()
    {
        //Given - Setup
        TodoService todoService= mock(TodoService.class);
        List<String> todos = Arrays.asList("List of Spring", "Learn Spring", "Bootcamp");
        given(todoService.retrieveTodos("Dummy")).willReturn(todos);
        TodoBusinessImpl todoBusiness = new TodoBusinessImpl(todoService);

        // When - method call
        List<String> filteredTodos=todoBusiness.retrieveTodosRelatedToSpring("Dummy");

        //Then - Asserts
        assertEquals(2,filteredTodos.size());
        assertThat(filteredTodos.size(), is(2));

    }
    @Test
    public void testWithMock_usingBDD_Verify()
    {
        //Given - Setup
        TodoService todoService= mock(TodoService.class);
        List<String> todos = Arrays.asList("List of Spring", "Learn Spring", "Bootcamp","Bootcamp");
        given(todoService.retrieveTodos("Dummy")).willReturn(todos);
        TodoBusinessImpl todoBusiness = new TodoBusinessImpl(todoService);

        // When - method call
        todoBusiness.deleteTodosNotRelatedToSpring("Dummy");

        //Then - Asserts
//        verify(todoService).deleteTodo("Bootcamp");
//        then(todoService).should().deleteTodo("Bootcamp");

//        Will fail
//        verify(todoService,times(1)).deleteTodo("Bootcamp");

        verify(todoService,times(2)).deleteTodo("Bootcamp");
        then(todoService).should(times(2)).deleteTodo("Bootcamp");

        verify(todoService,atLeastOnce()).deleteTodo("Bootcamp");
        then(todoService).should(atLeastOnce()).deleteTodo("Bootcamp");

        verify(todoService,atLeast(1)).deleteTodo("Bootcamp");
        then(todoService).should(atLeast(1)).deleteTodo("Bootcamp");

        verify(todoService,never()).deleteTodo("List of Spring");
        then(todoService).should(never()).deleteTodo("List of Spring");

    }

}