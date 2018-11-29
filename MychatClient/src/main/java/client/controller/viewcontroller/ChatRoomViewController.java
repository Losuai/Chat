package client.controller.viewcontroller;

import client.services.manager.MessageRequestManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ChatRoomViewController {

        @FXML
        private Button chat_bt_id;

        @FXML
        private TextArea chat_msr_tx;

        @FXML
        private TextField name_tx_id;

        @FXML
        private TextField chat_ms_tx;

        @FXML
        void chat_bt_ac(ActionEvent event) {
                chat_msr_tx.appendText("\n我：\n"+chat_ms_tx.getText());
                String username = name_tx_id.getText();
                String message = chat_ms_tx.getText();
                MessageRequestManager.getMessageRequestManager().sendMessage(username,message);
        }

        public void writeMes(String username, String message){
                chat_msr_tx.appendText("\n"+username+":\n");
                chat_msr_tx.appendText(message+"\n");
        }

}
