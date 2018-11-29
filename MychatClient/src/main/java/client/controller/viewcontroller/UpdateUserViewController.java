package client.controller.viewcontroller;

import client.services.manager.UpdateUserRequestManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class UpdateUserViewController {
        public static UpdateUserViewController updateUserViewController;
        @FXML
        private TextField new_phone_id;

        @FXML
        private Button exit_bt_id;

        @FXML
        private TextField last_pwd_id;

        @FXML
        private TextField new_pwd_id;

        @FXML
        private TextField new_sign_id;

        @FXML
        private TextField username_tx_id;

        @FXML
        private Button user_up_bt;

        @FXML
        private TextField last_username_id;

        @FXML
        void user_up_event(ActionEvent event) {
                String username = username_tx_id.getText();
                String password = new_pwd_id.getText();
                String sign = new_sign_id.getText();
                String telephone = new_phone_id.getText();
                String lastPwd = last_pwd_id.getText();
                String lastUsername = last_username_id.getText();
                UpdateUserRequestManager.getINSTANCE().sendUpdateUser(username,lastUsername,lastPwd,password,sign,telephone);
        }

        @FXML
        void exit_bt_event(ActionEvent event) {
                ((Node) (event.getSource())).getScene().getWindow().hide();
        }
        public void wirteUp(String username,String sign,String phone){
                username_tx_id.appendText(username);
                new_sign_id.appendText(sign);
                new_phone_id.appendText(phone);
        }
}
