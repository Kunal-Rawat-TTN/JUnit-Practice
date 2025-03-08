package com.kunalTTN;

import com.kunalTTN.business.TodoBusinessImpl;
import com.kunalTTN.service.TodoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.core.Is.is;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class testMockito {
    @Mock
    TodoService todoService;

    @InjectMocks
    TodoBusinessImpl todoBusiness;

    @Captor
    ArgumentCaptor<String> argumentCaptor;

    @Test
    public void testwithMokito()
    {
        List<String> list = Arrays.asList("Learn with Spring", "Bootcamp", "Spring Boot");
        given(todoService.retrieveTodos("Kunal")).willReturn(list);
        List<String> list1 = todoBusiness.retrieveTodosRelatedToSpring("Kunal");
        assertThat(list1,hasSize(2));
    }
    @Test
    public void testwithMokito_argumentCaptor()
    {
        List<String> list = Arrays.asList("Learn with Spring", "Bootcamp", "Spring Boot");
        given(todoService.retrieveTodos("Kunal")).willReturn(list);
        todoBusiness.deleteTodosNotRelatedToSpring("Kunal");
        verify(todoService, times(1)).deleteTodo("Bootcamp");
        verify(todoService, times(1)).deleteTodo(argumentCaptor.capture());
        assertThat(argumentCaptor.getValue(),is("Bootcamp"));
    }
}
