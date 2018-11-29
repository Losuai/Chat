package client.controller.viewcontroller;

import client.application.RegisterApplication;
import client.services.manager.LoginRequestManager;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginViewController{
        public static  LoginViewController loginViewController ;
        @FXML
        private PasswordField l_pwd_pf;

        @FXML
        private Button l_log_bt;

        @FXML
        private Button l_reg_bt;

        @FXML
        private TextField l_username_tf;

        @FXML
        void log_bt_event(ActionEvent event) {
                String username = l_username_tf.getText();
                String password = l_pwd_pf.getText();
                LoginRequestManager.getINSTANCE().sendRequestPacket(username,password);
//                ((Node) (event.getSource())).getScene().getWindow().hide();
        }

        @FXML
        void reg_bt_event(ActionEvent event) {
                Platform.runLater(() -> {
                        //创建主界面窗口
                        new RegisterApplication().start(new Stage());
                });
                ((Node) (event.getSource())).getScene().getWindow().hide();
        }

}
