package sample;

import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javafx.scene.control.*;
import javafx.stage.FileChooser;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LxController {

    @FXML
    ImageView loginImage;

    @FXML
    TextField email;

    @FXML
    TextField password;

    @FXML
    Button changeImage;

    @FXML
    Button login;

    private FileChooser fileChooser = new FileChooser();

    public void loadImage(String path) {
        Image image = new Image(path);
        loginImage.setImage(image);
        changeLoginImage();
    }


    private void changeLoginImage() {
        changeImage.setOnAction(event -> {
            File file = fileChooser.showOpenDialog(null);
            try {
                BufferedImage bufferedImage = ImageIO.read(file);
                Image image = SwingFXUtils.toFXImage(bufferedImage, null);
                loginImage.setImage(image);
            } catch (IOException ex) {
                Logger.getLogger(LxController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        login.setOnAction(event -> {
            int sn = "abc@gmail.com".equals(email.getText()) && "12345".equals(password.getText())
                    ? generateSessionID()
                    : 0;
            if (sn != 0) {
                System.out.print("Login Successfull: " +sn);
            } else {
                System.out.print("Session id: " +sn);
            }
         });
    }

    private static int sessionID = 0;

    private int generateSessionID() {
        sessionID++;
        return sessionID;
    }
}
