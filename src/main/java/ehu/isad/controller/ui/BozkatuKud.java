package ehu.isad.controller.ui;

import java.net.URL;
import java.util.ResourceBundle;

import ehu.isad.Main;
import ehu.isad.model.Herrialde;
import ehu.isad.model.StudentsModel;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class BozkatuKud {

    @FXML
    private TableView<Herrialde> tbData;

    @FXML
    private TableColumn<Herrialde, String> Herrialdea;

    @FXML
    private TableColumn<Herrialde, String> Artista;

    @FXML
    private TableColumn<Herrialde, String> Abestia;

    @FXML
    private TableColumn<Herrialde, Integer> Puntuak;

    @FXML
    private TableColumn<Herrialde, ImageView> argazkiId;


    private Main main;
    private Herrialde nork;
    private ObservableList<Herrialde> herrialdeak;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    void bozkaketaGorde(ActionEvent event) {

    }

    @FXML
    void initialize() {
        Herrialdea.setCellValueFactory(new PropertyValueFactory<>("izena"));
        Artista.setCellValueFactory(new PropertyValueFactory<>("artista"));
        Abestia.setCellValueFactory(new PropertyValueFactory<>("abestia"));
        Puntuak.setCellValueFactory(new PropertyValueFactory<>("puntuazioa"));
        //argazkiId.setCellValueFactory(new PropertyValueFactory<>("bandera"));
    }

    public void setHerrialdeak(ObservableList<Herrialde> pLista, Herrialde pHerrialde){
        nork=pHerrialde;
        herrialdeak=pLista;
        tbData.setItems(herrialdeak);

    }

    public void setMainApp(Main main) {
        this.main = main;
    }

}
