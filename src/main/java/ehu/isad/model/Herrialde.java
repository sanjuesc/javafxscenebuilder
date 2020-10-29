package ehu.isad.model;

import ehu.isad.Utils.Utils;
import javafx.scene.image.ImageView;
import java.util.Properties;
import java.io.IOException;


public class Herrialde {
    private String izena;
    private String artista;
    private String abestia;
    private int puntuazioa;
    private ImageView bandera;

    public String getIzena() {
        return izena;
    }

    public void setIzena(String izena) {
        this.izena = izena;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public String getAbestia() {
        return abestia;
    }

    public void setAbestia(String abestia) {
        this.abestia = abestia;
    }

    public int getPuntuazioa() {
        return puntuazioa;
    }

    public void setPuntuazioa(int puntuazioa) {
        this.puntuazioa = puntuazioa;
    }


    public Herrialde(String pIzena, String pArtista, String pAbestia, int pPuntuazioa) throws IOException {
        Properties properties = Utils.lortuEzarpenak();
        izena=pIzena;
        artista=pArtista;
        abestia=pAbestia;
        puntuazioa=pPuntuazioa;
    }
    @Override
    public String toString(){
        return izena;
    }

}
