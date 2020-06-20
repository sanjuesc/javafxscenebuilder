package ehu.isad.controller.dao;

import ehu.isad.controller.db.DBKudMySQL;
import ehu.isad.model.Autobusa;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BusKud {

  private static BusKud instance;
  private DBKudMySQL dbkud = DBKudMySQL.getInstance();

  public static BusKud getInstance(){
    if (instance == null) {
      instance = new BusKud();
    }
    return instance;
  }

  public List<Autobusa> getAutobusak(){
    List<Autobusa> emaitza = new ArrayList<>();
    String selectStmt = "SELECT * FROM autobusa";

    try {
      ResultSet rs = dbkud.execSQL(selectStmt);

      while (rs.next()) {
        int edukiera = rs.getInt("edukiera");
        String matrikula = rs.getString("matrikula");
        Date noizkoa = rs.getDate("noizkoa");

        emaitza.add(new Autobusa(matrikula,edukiera,noizkoa));
      }

    } catch (SQLException ex) {
      System.out.println("SQLException: " + ex.getMessage());
      System.out.println("SQLState: " + ex.getSQLState());
      System.out.println("VendorError: " + ex.getErrorCode());
    }

    return emaitza;
  }

}
