package client.application;

import client.ChatClient;
import client.global.CommonSwitchStage;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class LoginApplication extends Application {
    public static LoginApplication loginApplication;
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) {
        URL location = getClass().getResource("/LoginView.fxml");
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(location);
        fxmlLoader.setBuilderFactory(new JavaFXBuilderFactory());
        try {
            Parent root = fxmlLoader.load();
            Scene scene = new Scene(root);
            primaryStage.setTitle("网络聊天室");
            primaryStage.setScene(scene);
            CommonSwitchStage.loginViewController= fxmlLoader.getController();   //获取Controller的实例对象
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
        ChatClient.INSTANCE.start();
    }

}
