/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.GUI;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class AnController implements Initializable {

    private ImageView img;
    @FXML
    private VBox vboxim;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       Image image = new Image("https://tpwd.texas.gov/huntwild/wild/game_management/deer/images/WTD-Headshot.jpg");
       img.setImage(image); 
    }    
    
}
