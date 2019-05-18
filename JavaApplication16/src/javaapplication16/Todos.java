package javaapplication16;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import static jdk.nashorn.internal.objects.NativeDebug.getClass;

public class Todos extends Application {
    public void start(Stage stage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("FXML.fxml"));
        
        GridPane grid = new GridPane();
        Scene scene = new Scene(root);
        stage.setTitle("TodoList");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
        
    }
    public static void main(String [] args) {
        launch(args);
    }
}