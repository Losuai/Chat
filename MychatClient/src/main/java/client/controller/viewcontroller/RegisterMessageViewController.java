package client.controller.viewcontroller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

public class RegisterMessageViewController {
        public static RegisterMessageViewController registerMessageViewController;
        @FXML
        private Text text_id;

        @FXML
        private Button que_bt_id;

        @FXML
        void que_bt_event(ActionEvent event) {
                ((Node) (event.getSource())).getScene().getWindow().hide();
        }

        public void setText(String text){
            text_id.setText(text);
        }
}
