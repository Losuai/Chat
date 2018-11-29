package client.application;

import client.global.CommonSwitchStage;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.IOException;
import java.net.URL;

public class UpdateUserApplication {
    public void start(Stage primaryStage) {
        URL location = getClass().getResource("/UpdateUserView.fxml");
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(location);
            fxmlLoader.setBuilderFactory(new JavaFXBuilderFactory());
            try {
                Parent root = fxmlLoader.load();
                Scene scene = new Scene(root);
                primaryStage.setTitle("网络聊天室");
                primaryStage.setScene(scene);
                CommonSwitchStage.updateUserViewController  = fxmlLoader.getController();   //获取Controller的实例对象
                primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
