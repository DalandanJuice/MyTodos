package javaapplication16;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import javafx.scene.control.CheckBox;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import static javafx.scene.input.KeyCode.ENTER;
import javafx.scene.input.KeyEvent;
import static javafx.scene.input.MouseButton.SECONDARY;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

/**
 *
 * @author genesis
 */
public class FXMLController implements Initializable {

    private Todolist todo = new Todolist();
    private Label label;
    @FXML
    private ScrollPane scrollPane;
    @FXML
    private VBox todoBox;
    @FXML
    private int i = 0;
    @FXML
    private TextField textField1;
    @FXML
    private ContextMenu menu;
    @FXML
    private MenuItem delete;
    @FXML
    private ArrayList<CheckBox> todos;
    @FXML
    private ArrayList<ContextMenu> cm;
    @FXML
    private int a;

    @FXML
    private void onKeyPressed(KeyEvent e) {
        if (e.getCode() == ENTER) {

            todo.add(todoBox, todos, new CheckBox(textField1.getText()));
           for (int j = 0; j < todos.size(); j++) {
                  todos.get(j).setOnMouseClicked(this::showMenu);
            }
          

            textField1.setText("");
        }
    }
    
    private void showMenu(MouseEvent event) {
        if (event.getButton() == SECONDARY) {
                            for (int j = 0; j < todos.size(); j++) {
                                if (event.getSource() == todos.get(j)) {
                                    a = j;
                                    menu.show(todos.get(j), Side.RIGHT, 0, 0);
                                }
                            }

                        }
    }

    private void getSourced() {

    }

    @FXML

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         
        a = -2;
        todos = new ArrayList<>();
        menu = new ContextMenu();
        delete = new MenuItem("Delete");
        menu.getItems().add(delete);
        delete.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                for (int j = 0; j < todos.size(); j++) {
                    if (a == j) {
                        todoBox.getChildren().remove(todos.get(a));
                        todos.remove(a);
                    }
                }
            }

        });

    }

}
