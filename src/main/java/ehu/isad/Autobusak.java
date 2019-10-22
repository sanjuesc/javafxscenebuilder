package ehu.isad;

import ehu.isad.controller.ui.AutobusaKud;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


public class Autobusak extends Application {

  private Stage stage;
  private Parent autobusaUI;
  private AutobusaKud autobusaKud;

  private void pantailakKargatu() throws IOException {

    FXMLLoader loaderAutobusa = new FXMLLoader(getClass().getResource("/view/autobusak.fxml"));
    autobusaUI = (Parent) loaderAutobusa.load();
    autobusaKud = loaderAutobusa.getController();
    autobusaKud.setMainApp(this);
  }

  @Override
  public void start(Stage primaryStage) throws Exception {
    stage = primaryStage;
    pantailakKargatu();

    stage.setTitle("Autobusak Kudeatu");
    stage.setScene(new Scene(autobusaUI));
    stage.show();
  }
}
