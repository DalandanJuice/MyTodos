package javaapplication16;



import java.util.ArrayList;
import java.util.List;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

public class Todos_1 {
    
    private ArrayList<CheckBox> todos;
    public Todos_1() {
        todos =  new ArrayList<CheckBox>();
    }
    public void add(VBox pane, ArrayList<CheckBox> todos,CheckBox newTodo) {
        pane.getChildren().add(newTodo);
        todos.add(newTodo);
    }
    public void remove(int index) {
        todos.remove(index);
    }
    
    public void printTodos() {
        for (int i = 0; i < todos.size(); i++) {
            System.out.println(todos.get(i).getText());
        }
    }

}
