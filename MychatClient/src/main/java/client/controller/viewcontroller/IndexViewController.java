package client.controller.viewcontroller;

import client.application.ChatRoomApplication;
import client.application.RegisterApplication;
import client.application.UpdateUserApplication;
import client.global.CommonSwitchStage;
import client.services.manager.GroupMessageRequestManager;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class IndexViewController {
        public static IndexViewController indexViewController;
        @FXML
        public  TextArea mes_show;

        @FXML
        private Button send_mes_bt;

        @FXML
        private TextField mes_tx;

        @FXML
        private Text user_namet_tx;

        @FXML
        private Button bj_user_bt;

        @FXML
        private Text phone_id;

        @FXML
        private Text sign_id;

        @FXML
        private Button fes_bt_id;

        @FXML
        private Button talk_id;

        @FXML
        void send_mes_ex(ActionEvent event) {
                mes_show.appendText("我:\n"+mes_tx.getText()+"\n");
                GroupMessageRequestManager.getINSTANCE().sendMessage(mes_tx.getText());
        }
        public void wirteMsg(String username,String msg){
                mes_show.appendText(username+":\n"+msg+"\n");
        }

        public void write(String username,String phone,String sign){
                user_namet_tx.setText(username);
                phone_id.setText(phone);
                sign_id.setText(sign);
        }


        @FXML
        void bj_user_event(ActionEvent event) {
                Platform.runLater(() -> {
                        //创建主界面窗口
                        new UpdateUserApplication().start(new Stage());
                });
        }

        @FXML
        void frs_list_event(ActionEvent event) {

        }

        @FXML
        void Talk_bt(ActionEvent event) {
                Platform.runLater(() -> {
                        //创建主界面窗口
                        new ChatRoomApplication().start(new Stage());
                });
        }


}
