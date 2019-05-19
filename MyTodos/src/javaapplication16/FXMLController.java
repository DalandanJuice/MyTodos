package javaapplication16;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.Checkbox;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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
    private TextField textField1;
    private ContextMenu menu;
    private MenuItem delete;
    private ArrayList<CheckBox> todos;
    @FXML
    private void onKeyPressed(KeyEvent e) {
        if (e.getCode() == ENTER) {
            todo.add(todoBox,todos,new CheckBox(textField1.getText()));
            for(CheckBox cb: todos) {
                cb.setContextMenu(menu);
            }
        }
    }
    @FXML
    private void delete(ActionEvent e) {
        for(CheckBox cb: todos) {
            if (cb.isSelected()) {
                System.out.println("deleted");
            }
        }
    }
    
    @FXML
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        todos = new ArrayList<CheckBox>();
        menu = new ContextMenu();
        delete = new MenuItem("Delete");
        menu.getItems().add(delete);
        delete.setOnAction(new EventHandler<ActionEvent>() {
    public void handle(ActionEvent e) {
        System.out.println(e.getSource());
    }
});
        

    }

}
