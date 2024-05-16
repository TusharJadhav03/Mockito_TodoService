package Business;

import org.junit.jupiter.api.Test;
import todotask.TodoService;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
}