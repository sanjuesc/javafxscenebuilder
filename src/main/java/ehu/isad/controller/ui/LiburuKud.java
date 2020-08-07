package ehu.isad.controller.ui;

import ehu.isad.controller.db.DBKudeatzaile;
import ehu.isad.controller.db.LiburuakDBKud;
import ehu.isad.model.Book;
import ehu.isad.utils.OpenLibrary;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.ResourceBundle;

public class LiburuKud implements Initializable {

    private static int unekoa = 0;

    @FXML
    private TextField izenburua;

    @FXML
    private TextField egilea;

    @FXML
    private TextField isbn;

    @FXML
    private TextField urtea;

    @FXML
    private Button next;

    @FXML
    private Button prev;

    @FXML
    private Button bilatu;

    @FXML
    private ImageView irudia;

    @FXML
    void next(ActionEvent event) {
        unekoa++;
        bistaratu();
    }

    @FXML
    void prev(ActionEvent event) {
        unekoa--;
        if (unekoa < 0) unekoa = 0;
        bistaratu();
    }


    @FXML
    void bilatu(ActionEvent event) {
        // 1883601126
        // 1617293563
        try {
            Book book = OpenLibrary.get(isbn.getText());
            izenburua.setText(book.details.title);
            egilea.setText(book.details.authors[0].name);
            urtea.setText(book.details.publish_date);

            // get medium size image
            book.thumbnail_url = book.thumbnail_url.replaceFirst("-S", "-M");
            String filepath = OpenLibrary.saveImage(book.thumbnail_url, OpenLibrary.PATH);

            //Creating an image
            Image image = new Image(new FileInputStream(filepath));

            //Setting the image view
            irudia.setImage(image);

            book.isbn = isbn.getText();
            book.filename = Paths.get(filepath).getFileName().toString();

            LiburuakDBKud.getInstantzia().gordeLiburua(book);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void bistaratu() {
        Book book = LiburuakDBKud.getInstantzia().lortuLiburua(unekoa);
        if (book == null) {
            unekoa--;
            return;
        }

        isbn.setText(book.isbn);
        izenburua.setText(book.details.title);
        egilea.setText(book.details.authors[0].name);
        urtea.setText(book.details.publish_date);

        try {
            Image image = new Image(new FileInputStream(OpenLibrary.PATH + "/" + book.filename));
            irudia.setImage(image);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        bistaratu();
    }
}
