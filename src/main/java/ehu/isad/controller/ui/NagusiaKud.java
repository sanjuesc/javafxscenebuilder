package ehu.isad.controller.ui;

import ehu.isad.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javax.imageio.ImageIO;
import java.io.FileInputStream;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class NagusiaKud implements Initializable {

  // Reference to the main application.
  private Main mainApp;


  @FXML
  private ImageView imageId;

  public void setMainApp(Main main) {
    this.mainApp = main;
  }

  @FXML
  public void onClick(ActionEvent actionEvent) throws SQLException {


      mainApp.ezarpenakErakutsi();

  }

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    Image image = new Image("/eurovision.png");
    imageId.setImage(image);
  }

}