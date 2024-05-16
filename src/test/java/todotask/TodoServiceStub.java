package todotask;

import java.util.Arrays;
import java.util.List;

public class TodoServiceStub implements TodoService {
    @Override
    public List<String> retrieveTodos(String user) {
        return Arrays.asList(
                "Im from Mumbai",
                "Im from Pune",
                "Im from Mumbai",
                "Im from Pune",
                "Im from Mumbai",
                "Im from Mumbai"
        );
    }
}
