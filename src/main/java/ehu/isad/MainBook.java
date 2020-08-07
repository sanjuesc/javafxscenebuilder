package ehu.isad;

import ehu.isad.controller.ui.EzarpenakKud;
import ehu.isad.controller.ui.LiburuKud;
import ehu.isad.controller.ui.NagusiaKud;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainBook extends Application {

  private Parent liburuUI;

  private Stage stage;

  private LiburuKud liburuKud;


  @Override
  public void start(Stage primaryStage) throws Exception {

    stage = primaryStage;
    pantailakKargatu();

    stage.setTitle("Liburuak");
    stage.setScene(new Scene(liburuUI, 550, 375));
    stage.show();
  }

  private void pantailakKargatu() throws IOException {

    FXMLLoader loaderKautotu = new FXMLLoader(getClass().getResource("/Book.fxml"));
    liburuUI = (Parent) loaderKautotu.load();
    liburuKud = loaderKautotu.getController();

  }

  public static void main(String[] args) {
    launch(args);
  }

}
