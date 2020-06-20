package ehu.isad;

import ehu.isad.controller.ui.WebguneKud;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


public class Webguneak extends Application {

  private Stage stage;
  private Parent webguneUI;
  private WebguneKud webguneKud;

  private void pantailakKargatu() throws IOException {

    FXMLLoader loaderWebgune = new FXMLLoader(getClass().getResource("/view/webguneak.fxml"));
    webguneUI = (Parent) loaderWebgune.load();
    webguneKud = loaderWebgune.getController();
    webguneKud.setMainApp(this);
  }

  @Override
  public void start(Stage primaryStage) throws Exception {
    stage = primaryStage;
    pantailakKargatu();

    stage.setTitle("Webguneak Kudeatu");
    stage.setScene(new Scene(webguneUI));
    stage.show();
  }
}
