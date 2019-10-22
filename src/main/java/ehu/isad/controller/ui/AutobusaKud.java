package ehu.isad.controller.ui;

import ehu.isad.Autobusak;
import ehu.isad.Main;
import ehu.isad.controller.dao.BusKud;
import ehu.isad.model.Autobusa;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class AutobusaKud implements Initializable {

  // Reference to the main application.
  private Autobusak mainApp;

  @FXML
  private ComboBox matxuratutakoa;

  @FXML
  private ComboBox ordezkoa;

  @FXML
  private DatePicker noiz;

  public void setMainApp(Autobusak main) {
    this.mainApp = mainApp;
  }

  @FXML
  public void onClick(ActionEvent actionEvent) {

    System.out.println(matxuratutakoa.getSelectionModel().getSelectedItem());
    System.out.println(ordezkoa.getSelectionModel().getSelectedItem());
    System.out.println(noiz.getValue());


  }

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    List<Autobusa> autobusak = BusKud.getInstance().getAutobusak();

    matxuratutakoa.getItems().addAll(autobusak);
    ordezkoa.getItems().addAll(autobusak);
  }

}