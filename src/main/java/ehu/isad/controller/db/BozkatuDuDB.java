package ehu.isad.controller.db;

import ehu.isad.model.Herrialde;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BozkatuDuDB {


    // singleton patroia

    private static BozkatuDuDB instantzia = new BozkatuDuDB();

    public static BozkatuDuDB getInstantzia(){
        return instantzia;
    };

    private BozkatuDuDB(){}


    public String lortuBandera(Herrialde pHerrialdea) throws SQLException {
        String query = "select bandera from  Herrialde where izena = '"+pHerrialdea.getIzena()+"'";
        DBKudeatzaile dbkud = DBKudeatzaile.getInstantzia();
        ResultSet rs =dbkud.execSQL(query);
        return rs.getString("bandera");

    }

}
