package edu.miu.sptingcloudfunction.business;

import edu.miu.sptingcloudfunction.business.api.TodoService;

import java.util.ArrayList;
import java.util.List;

public class TodoBusinessImpl {


    private final TodoService todoService;

    public TodoBusinessImpl(TodoService todoService) {
        this.todoService = todoService;
    }


    public List<String> retrieveTodosRelatedToSpring(String user) {

        List<String> filteredTodos = new ArrayList<String>();
        List<String> allTodos = todoService.retrieveTodos(user);
        for (String todo : allTodos) {
            if (todo.contains("Spring")) {
                filteredTodos.add(todo);
            }
        }
        return filteredTodos;
    }

    public void deleteTodosNotRelatedToSpring(String user) {
        List<String> allTodos = todoService.retrieveTodos(user);
        for (String todo : allTodos) {
            if (!todo.contains("Spring")) {
                todoService.deleteTodo(todo);
            }
        }
    }


    public int toTest() {
        return 4;
    }
}
