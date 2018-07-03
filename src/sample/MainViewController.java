package sample;

import javafx.event.*;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class MainViewController {

    @FXML
    private Button logoutButton;
    @FXML private Label sessionLabel;

    public void initialize() {}

    public void initSessionID(String sessionID) {
        sessionLabel.setText(sessionID);
        logoutButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent event) {

            }
        });
    }
}
