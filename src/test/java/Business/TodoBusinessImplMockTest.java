package Business;


import org.junit.jupiter.api.Test;
import todotask.TodoService;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


class TodoBusinessImplMockTest {

    @Test
    void testRetrieveTodosUsingMock() {

        TodoService todoServiceMock = mock(TodoService.class);
        List<String> todos = Arrays.asList("Im from Mumbai","Im from Mumbai","Im from Mumbai,Im from Pune,Im from Pune");
        when(todoServiceMock.retrieveTodos("Tushar")).thenReturn(todos);

        TodoBusinessImpl todoBusiness = new TodoBusinessImpl(todoServiceMock);
        List<String> filteredTodos = todoBusiness.retrieveTodos("Tushar");
        assertEquals(3,filteredTodos.size());
    }

    @Test
    void testRetrieveTodosUsingMockEmptyList() {

        TodoService todoServiceMock = mock(TodoService.class);
        List<String> todos = List.of();
        when(todoServiceMock.retrieveTodos("Tushar")).thenReturn(todos);

        TodoBusinessImpl todoBusiness = new TodoBusinessImpl(todoServiceMock);
        List<String> filteredTodos = todoBusiness.retrieveTodos("Tushar");
        assertEquals(0,filteredTodos.size());
    }

    @Test
    void testRetrieveTodosUsingBDD() {

        //Given
        TodoService todoServiceBDD = mock(TodoService.class);
        List<String> todos = Arrays.asList("Im from Mumbai","Im from Mumbai","Im from Mumbai,Im from Pune,Im from Pune");
        given(todoServiceBDD.retrieveTodos("Tushar")).willReturn(todos);
        TodoBusinessImpl todoBusiness = new TodoBusinessImpl(todoServiceBDD);

        //When
        List<String> filteredTodos = todoBusiness.retrieveTodos("Tushar");

        //Then
        assertThat(filteredTodos.size(),is(3));

    }

}