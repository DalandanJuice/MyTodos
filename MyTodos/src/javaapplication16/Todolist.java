package javaapplication16;

import java.util.ArrayList;
import java.util.List;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

public class Todolist {

    private ArrayList<CheckBox> todos;

    public Todolist() {
        todos = new ArrayList<CheckBox>();
    }

    public void add(VBox box, ArrayList<CheckBox> todos, CheckBox newTodo) {
        box.getChildren().add(newTodo);
        todos.add(newTodo);
    }

    public void remove(VBox box, int index) {
        box.getChildren().remove(index);
        todos.remove(index);

    }

    public void printTodos() {
        for (int i = 0; i < todos.size(); i++) {
            System.out.println(todos.get(i).getText());
        }
    }

}
