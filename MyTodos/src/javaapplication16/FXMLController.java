package javaapplication16;

//NetBeansProjects/new/MyTodos/MyTodos
import java.awt.Checkbox;
import java.awt.event.MouseListener;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Side;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import static javafx.scene.input.KeyCode.ENTER;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import static javafx.scene.input.MouseButton.SECONDARY;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

/**
 *
 * @author genesis
 */
public class FXMLController implements Initializable {

    private Todolist MyTodos;
    private Label label;
    @FXML
    private ScrollPane scrollPane;
    @FXML
    private VBox todoBox;
    @FXML
    private TextField textField1;
    private ContextMenu menu;
    private MenuItem delete;
    private ArrayList<CheckBox> todos;
    private int a;
    @FXML
    private AnchorPane clear;
    @FXML
    private Button clearButton;
   
    @FXML
    private void onKeyPressed(KeyEvent e) {
        if (e.getCode() == KeyCode.ENTER) {

            MyTodos.add(todoBox, todos, new CheckBox(textField1.getText()));
            for (int j = 0; j < todos.size(); j++) {
                todos.get(j).setOnMouseClicked(this::showMenu);
            }

            textField1.setText("");
        }
    }

    private void showMenu(MouseEvent event) {
        if (event.getButton() == MouseButton.SECONDARY) {
            for (int j = 0; j < todos.size(); j++) {
                if (event.getSource() == todos.get(j)) {
                    a = j;
                    menu.show(todos.get(j), Side.BOTTOM, 0, 0);
                }
            }

        }
    }
    @FXML
    private void clear(ActionEvent event) {
        int i = 0;
        for (int j = 0; j < todos.size(); j++) {
            todoBox.getChildren().remove(todos.get(j));
            
        }
        for (int j = 0; j < todos.size(); j++) {
            todos.remove(j);
        }
        
    }
    private void delete(ActionEvent event) {
         for (int j = 0; j < todos.size(); j++) {
                    if (a == j) {
                        todoBox.getChildren().remove(todos.get(a));
                        todos.remove(a);
                    }
                }
    }


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
       MyTodos  = new Todolist();
        a = -2;
        todos = new ArrayList<>();
        menu = new ContextMenu();
        delete = new MenuItem("Delete");
        menu.getItems().add(delete);
        delete.setOnAction(this::delete);
           

    }

}
