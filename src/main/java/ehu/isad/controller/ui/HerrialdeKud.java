package ehu.isad.controller.ui;

import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

import ehu.isad.Main;
import ehu.isad.controller.db.HerrialdeDB;
import ehu.isad.model.Herrialde;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;

public class HerrialdeKud {

  @FXML
  private ResourceBundle resources;

  @FXML
  private URL location;

  @FXML
  private ComboBox<Herrialde> cBox;
  private Main main;
  private ObservableList<Herrialde> herrialdeak;

  @FXML
  void onClick(ActionEvent event) throws SQLException {
    if (HerrialdeDB.getInstantzia().bozkatuDu(cBox.getValue())){
      main.BozkatuduErakutsi(cBox.getValue());
    }else{
      main.bozkatuErakutsi(herrialdeak, cBox.getValue());
    }


  }

  @FXML
  void initialize() {
    cBox.getItems().removeAll();

  }
  public void setMainApp(Main main) {
    this.main = main;
  }

  public void getEzarpenak() throws SQLException {
    // datubasetik atzitu ezarpenak
    herrialdeak = FXCollections.observableArrayList();
    herrialdeak.addAll(HerrialdeDB.getInstantzia().lortuHerrialde());
    cBox.setItems(herrialdeak);
  }
}

