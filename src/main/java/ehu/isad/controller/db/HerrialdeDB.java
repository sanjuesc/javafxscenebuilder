package ehu.isad.controller.db;

import ehu.isad.model.Herrialde;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HerrialdeDB {

    // singleton patroia

    private static HerrialdeDB instantzia = new HerrialdeDB();

    public static HerrialdeDB getInstantzia(){
        return instantzia;
    };

    private HerrialdeDB(){}

    public List<Herrialde> lortuHerrialde() throws SQLException {

        List<Herrialde> emaitza = new ArrayList<>();
        DBKudeatzaile dbkud = DBKudeatzaile.getInstantzia();

        String query = "select herrialdea, artista, abestia, puntuak from Ordezkaritza JOIN ParteHartzea on ParteHartzea.izena=Ordezkaritza.herrialdea where ParteHartzea.urtea = strftime('%Y', 'now') and etorrikoDa='Bai'";
        ResultSet rs = dbkud.execSQL(query);
        try {
            while (rs.next()) {
                String izena = rs.getString("herrialdea");
                String artista = rs.getString("artista");
                String abestia = rs.getString("abestia");
                Integer puntuak = rs.getInt("puntuak");
                Herrialde herrialde = new Herrialde(izena, artista, abestia,puntuak);
                emaitza.add(herrialde);
            }
        }catch (SQLException | IOException e){
            System.err.println(e);
        }


        return emaitza;
    }

    public Boolean bozkatuDu(Herrialde herri) throws SQLException {

        DBKudeatzaile dbkud = DBKudeatzaile.getInstantzia();

        String query = "select puntuak from Bozkaketa INNER JOIN ParteHartzea on Bozkaketa.bozkatuDu=ParteHartzea.izena where ParteHartzea.urtea = strftime('%Y', 'now') and etorrikoDa='Bai' and izena='"+herri.getIzena()+"'";
        System.out.println(query);
        ResultSet rs = dbkud.execSQL(query);
        return rs.next(); //elementuren bat badago, orduan bozkatu egin du jadanik
    }

    public void bozkatu(Herrialde pHerri, Integer pPuntuak) {
        DBKudeatzaile dbkud = DBKudeatzaile.getInstantzia();
        //dbkud.execSQL("INSERT INTO properties ('userid', 'key', 'value') values ('5','6','7')");

    }
}
