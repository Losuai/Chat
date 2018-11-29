package client.controller.viewcontroller;

import client.application.LoginApplication;
import client.application.RegisterApplication;
import client.services.manager.RegisterUserRequestManager;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class RegisterViewController {

        @FXML
        private PasswordField r_pwd_tf;

        @FXML
        private TextField r_sign_tf;

        @FXML
        private Button r_reg_bt;

        @FXML
        private Button l_login_bt;

        @FXML
        private TextField r_tele_tf;

        @FXML
        private TextField r_username_tf;

        @FXML
        void reg_bt_event(ActionEvent event) {

        }
        @FXML
        void re_user_event(ActionEvent event) {
                String username = r_username_tf.getText();
                String password = r_pwd_tf.getText();
                String sign = r_sign_tf.getText();
                String telephone = r_tele_tf.getText();
                RegisterUserRequestManager.getINSTANCE().sendRegisterUserRequestPacket(username,password,sign,telephone);
        }

        @FXML
        void l_login_event(ActionEvent event) {
                Platform.runLater(() -> {
                        //创建主界面窗口
                        new LoginApplication().start(new Stage());

                });
                ((Node) (event.getSource())).getScene().getWindow().hide();

    }
}
