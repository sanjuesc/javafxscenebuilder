package ehu.isad.controller.dao;

import ehu.isad.controller.db.DBKudSQLite;
import ehu.isad.model.Webgunea;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

public class DatuakKud {

  private static DatuakKud instance;
  private DBKudSQLite dbkud = DBKudSQLite.getInstantzia();

  public static DatuakKud getInstance(){
    if (instance == null) {
      instance = new DatuakKud();
    }
    return instance;
  }

  public List<Webgunea> getWebguneak(){
    List<Webgunea> emaitza = new ArrayList<>();
    String selectStmt = "SELECT * FROM webguneak";

    try {
      ResultSet rs = dbkud.execSQL(selectStmt);

      while (rs.next()) {
        String url = rs.getString("url");
        String cms = rs.getString("cms");
        String version = rs.getString("version");
        Long lastupdated =  rs.getLong ("lastupdated");
        String screenshot = rs.getString("screenshot");

        // https://stackoverflow.com/a/35186993/243532
        LocalDate date =
                Instant.ofEpochSecond(lastupdated)
                        .atZone(ZoneId.systemDefault())
                        .toLocalDate();

        emaitza.add(new Webgunea(url, cms, version, date, screenshot));
      }

    } catch (SQLException ex) {
      System.out.println("SQLException: " + ex.getMessage());
      System.out.println("SQLState: " + ex.getSQLState());
      System.out.println("VendorError: " + ex.getErrorCode());
    }

    return emaitza;
  }

}
