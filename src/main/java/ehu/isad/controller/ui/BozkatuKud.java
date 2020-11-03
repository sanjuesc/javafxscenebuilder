package ehu.isad.controller.ui;

import java.net.URL;
import java.util.ResourceBundle;

import ehu.isad.Main;
import ehu.isad.model.Herrialde;
import ehu.isad.model.StudentsModel;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.util.Callback;


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
    private TableColumn<Herrialde, String> Puntuak;

    @FXML
    private TableColumn<Herrialde, Image> argazkiId;

    private int ematekoPuntuak;
    private Main main;
    private Herrialde nork;
    private ObservableList<Herrialde> herrialdeak;

    @FXML
    private Text textuId;

    @FXML
    private Text zenbatId;

    @FXML
    void bozkaketaGorde(ActionEvent event) {
        Herrialde[] herriak = tbData.getItems().toArray(new Herrialde[0]);
        int i = 0;
        while(i<herriak.length){
            if(!herriak[i].getIzena().equals(nork.getIzena()))
            herriak[i].puntuazioEguneratu(nork);
            i++;
        }
        main.topErakutsi();
    }

    @FXML
    void initialize() {
        tbData.setEditable(true);
        Herrialdea.setCellValueFactory(new PropertyValueFactory<>("izena"));
        Artista.setCellValueFactory(new PropertyValueFactory<>("artista"));
        Abestia.setCellValueFactory(new PropertyValueFactory<>("abestia"));
        Puntuak.setCellValueFactory(c-> new SimpleStringProperty(String.valueOf(c.getValue().getJasotakoPunt())));


        Callback<TableColumn<Herrialde, String>, TableCell<Herrialde, String>> defaultTextFieldCellFactory
                = TextFieldTableCell.<Herrialde>forTableColumn();

        Puntuak.setCellFactory(col -> {
            TableCell<Herrialde, String> cell = defaultTextFieldCellFactory.call(col);

            cell.setOnMouseClicked(event -> {
                if (! cell.isEmpty()) {
                    if (cell.getTableView().getSelectionModel().getSelectedItem().getIzena().equals(nork.getIzena())) {
                        cell.setEditable(false); //deshabilitar una
                    }else {
                        cell.setEditable(true);
                    }
                }
            });

            return cell ;
        });



        Puntuak.setOnEditCommit(data -> {
            Integer zenbat = 0;
            if(!data.getNewValue().equals("")&& Integer.parseInt(data.getNewValue())<=(ematekoPuntuak+data.getRowValue().getJasotakoPunt())){
                zenbat=Integer.parseInt(data.getNewValue());
            }
            ematekoPuntuak=ematekoPuntuak+data.getRowValue().getJasotakoPunt()-zenbat;
            data.getRowValue().setJasotakoPunt(zenbat);
            zenbatId.setText(String.valueOf(ematekoPuntuak));
            tbData.refresh();


        });
        argazkiId.setCellValueFactory(new PropertyValueFactory<Herrialde, Image>("bandera"));

        argazkiId.setCellFactory(p -> new TableCell<>() {
            public void updateItem(Image image, boolean empty) {
                if (image != null && !empty){
                    final ImageView imageview = new ImageView();
                    imageview.setFitHeight(12);
                    imageview.setFitWidth(20);
                    imageview.setImage(image);
                    setGraphic(imageview);
                    setAlignment(Pos.CENTER);
                    // tbData.refresh();
                }else{
                    setGraphic(null);
                    setText(null);
                }
            };
        });
    }

    public void setHerrialdeak(ObservableList<Herrialde> pLista, Herrialde pHerrialde){
        ematekoPuntuak=5;
        zenbatId.setText(String.valueOf(ematekoPuntuak));
        nork=pHerrialde;
        herrialdeak=pLista;
        tbData.setItems(herrialdeak);

    }

    public void setMainApp(Main main) {
        this.main = main;
    }

}
