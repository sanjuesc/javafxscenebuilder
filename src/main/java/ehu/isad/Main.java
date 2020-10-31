package ehu.isad;

import ehu.isad.controller.ui.*;
import ehu.isad.model.Herrialde;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class Main extends Application {

  private Parent nagusiaUI;
  private Parent herrialdeUI;
  private Parent bozkatuUI;
  private Parent bozkatuDuUI;


  private Stage stage;

  private NagusiaKud nagusiaKud;
  private HerrialdeKud herrialdeKud;
  private BozkatuKud bozkatuKud;
  private bozkatuDuKud bozkatuduKud;

  private Scene nagusiaScene;
  private Scene herrialdeScene;
  private Scene bozkatuScene;
  private Scene bozkatuduScene;



  @Override
  public void start(Stage primaryStage) throws Exception {

    stage = primaryStage;
    pantailakKargatu();

    nagusiaScene = new Scene(nagusiaUI,600,400);
    herrialdeScene = new Scene(herrialdeUI,600,400);
    bozkatuScene = new Scene(bozkatuUI,600,400);
    bozkatuduScene = new Scene(bozkatuDuUI,600,400);



    stage.setTitle("Eurobisioa");
    stage.setScene(nagusiaScene);
    stage.show();
  }

  private void pantailakKargatu() throws IOException {

    FXMLLoader loaderKautotu = new FXMLLoader(getClass().getResource("/NagusiaUI.fxml"));
    nagusiaUI = (Parent) loaderKautotu.load();
    nagusiaKud = loaderKautotu.getController();
    nagusiaKud.setMainApp(this);

    FXMLLoader loaderHerrialde = new FXMLLoader(getClass().getResource("/Herrialde.fxml"));
    herrialdeUI = (Parent) loaderHerrialde.load();
    herrialdeKud = loaderHerrialde.getController();
    herrialdeKud.setMainApp(this);

    FXMLLoader loaderBozkatu = new FXMLLoader(getClass().getResource("/Bozkatu.fxml"));
    bozkatuUI = (Parent) loaderBozkatu.load();
    bozkatuKud = loaderBozkatu.getController();
    bozkatuKud.setMainApp(this);

    FXMLLoader loaderBozkatuDu = new FXMLLoader(getClass().getResource("/BozkatuDu.fxml"));
    bozkatuDuUI = (Parent) loaderBozkatuDu.load();
    bozkatuduKud = loaderBozkatuDu.getController();
    bozkatuduKud.setMainApp(this);
  }


  public static void main(String[] args) {
    launch(args);
  }

  public void ezarpenakErakutsi() throws SQLException {
    stage.setScene(herrialdeScene);
    stage.show();
    herrialdeKud.getEzarpenak();
  }

  public void bozkatuErakutsi(ObservableList<Herrialde> herrialdeak, Herrialde nork){
    bozkatuKud.setHerrialdeak(herrialdeak, nork);
    stage.setScene(bozkatuScene);
    stage.show();

  }
  public void BozkatuduErakutsi(Herrialde herrialdea) throws SQLException {
    bozkatuduKud.setHerrialdeIzena(herrialdea);
    stage.setScene(bozkatuduScene);
    stage.show();
  }

}
