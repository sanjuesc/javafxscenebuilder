package ehu.isad.model;

import ehu.isad.Utils.Utils;
import ehu.isad.controller.db.HerrialdeDB;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.util.Properties;
import java.io.IOException;


public class Herrialde {
    private String izena;
    private String artista;
    private String abestia;
    private int puntuazioa;

    public Image getBandera() {
        return bandera;
    }

    public void setBandera(Image bandera) {
        this.bandera = bandera;
    }

    private Image bandera;
    private int jasotakoPunt;

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

    public int getJasotakoPunt() {
        return jasotakoPunt;
    }

    public void setJasotakoPunt(int jasotakoPunt) {
        this.jasotakoPunt = jasotakoPunt;
    }

    public void setPuntuazioa(int puntuazioa) {
        this.puntuazioa = puntuazioa;
    }


    public Herrialde(String pIzena, String pArtista, String pAbestia, int pPuntuazioa, String path) throws IOException {
        Properties properties = Utils.lortuEzarpenak();
        izena=pIzena;
        artista=pArtista;
        abestia=pAbestia;
        puntuazioa=pPuntuazioa;
        jasotakoPunt=0;
        bandera= new Image(path+".png");
    }
    @Override
    public String toString(){
        return izena;
    }

    public void puntuazioEguneratu(Herrialde bozkatuDio) {
        HerrialdeDB herriDB = HerrialdeDB.getInstantzia();
        herriDB.bozkatu(bozkatuDio, this);
    }
}
