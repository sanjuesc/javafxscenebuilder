package ehu.isad.controller.ui;

import ehu.isad.Main;
import ehu.isad.controller.db.EzarpenakDBKud;
import ehu.isad.model.Ezarpena;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class EzarpenakKud implements Initializable {

  // Reference to the main application.
  private Main mainApp;

  @FXML
  private TextArea ezarpenak;

  public void setMainApp(Main main) {
    this.mainApp = mainApp;
  }


  public void getEzarpenak(){
   // datubasetik atzitu ezarpenak
    List<Ezarpena> zerrenda = EzarpenakDBKud.getInstantzia().lortuEzarpenak();

    ezarpenak.setText(zerrenda.toString());
  }

  @FXML
  public void onClick(ActionEvent actionEvent) {
    EzarpenakDBKud.getInstantzia().eguneratu();
    this.getEzarpenak();
  }

  @Override
  public void initialize(URL location, ResourceBundle resources) {

  }

}