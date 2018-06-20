package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    public static Stage mainLoginScene;
    public static Stage formAboutmeScene;
    @Override
    public void start(Stage primaryStage) throws Exception{

        Parent mainLogin= FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setScene(new Scene(mainLogin));
        primaryStage.show();
        mainLoginScene = primaryStage;


    }

    public static void main(String[] args) {
        launch(args);
    }
}
