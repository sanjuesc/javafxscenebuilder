package ehu.isad.controller.ui;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import ehu.isad.Main;
import ehu.isad.controller.db.HerrialdeDB;
import ehu.isad.model.Herrialde;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class top3Kud {
    Main main;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView eurovison;

    @FXML
    void clickEgin(ActionEvent event) {
        main.mainErakutsi();
    }

    private ObservableList<Herrialde> herrialdeak;

    public void setMainApp(Main main) {
        this.main = main;
    }


    @FXML
    private TableView<Herrialde> tbData;

    @FXML
    private TableColumn<Herrialde, Image> banderaId;

    @FXML
    private TableColumn<Herrialde, String> herrialdeId;

    @FXML
    private TableColumn<Herrialde, Integer> puntuakId;

    @FXML
    void initialize() {
        Image euroImage = new Image("/eurovision.png");
        eurovison.setImage(euroImage);
        herrialdeId.setCellValueFactory(new PropertyValueFactory<>("izena"));
        puntuakId.setCellValueFactory(new PropertyValueFactory<>("puntuazioa"));
        banderaId.setCellValueFactory(new PropertyValueFactory<Herrialde, Image>("bandera"));

        banderaId.setCellFactory(p -> new TableCell<>() {
            public void updateItem(Image image, boolean empty) {
                if (image != null && !empty){
                    final ImageView imageview = new ImageView();
                    imageview.setFitHeight(12);
                    imageview.setFitWidth(20);
                    imageview.setImage(image);
                    setGraphic(imageview);
                    setAlignment(Pos.CENTER);
                    // tbData.rºefresh();
                }else{
                    setGraphic(null);
                    setText(null);
                }
            };
        });
    }
    public void setHerrialdeak() throws SQLException {
        herrialdeak= FXCollections.observableArrayList();
        herrialdeak.addAll(HerrialdeDB.getInstantzia().lortuTop());
        tbData.setItems(herrialdeak);

    }
}