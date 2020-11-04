package ehu.isad.controller.ui;

import ehu.isad.Main;
import ehu.isad.controller.db.BozkatuDuDB;
import ehu.isad.model.Herrialde;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class bozkatuDuKud implements Initializable {


    private Main mainApp;


    public void setMainApp(Main main) {
        this.mainApp = main;
    }
    @FXML
    private ImageView banderaBihotz;

    @FXML
    private ImageView eurobisioa;

    @FXML
    private Text textId;

    @FXML
    void click(ActionEvent event) throws SQLException {
        mainApp.ezarpenakErakutsi();

    }

    public void setHerrialdeIzena(Herrialde herrialdea) throws SQLException {
        String banderaIzena=BozkatuDuDB.getInstantzia().lortuBandera(herrialdea);
        Image banderaImage= new Image("/bihotz/"+banderaIzena+".png");
        banderaBihotz.setImage(banderaImage);
        textId.setText(herrialdea.getIzena()+ "k jada banatu ditu bere puntuak");

    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Image euroImage = new Image("/eurovision.png");
        eurobisioa.setImage(euroImage);
    }

}