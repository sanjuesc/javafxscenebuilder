package ehu.isad.model;

import java.util.Date;

public class Autobusa {

  private String matrikula;
  private Integer edukiera;
  private Date noizkoa;

  public Autobusa(String matrikula, Integer edukiera, Date noizkoa) {
    this.matrikula = matrikula;
    this.edukiera = edukiera;
    this.noizkoa = noizkoa;
  }

  @Override
  public String toString() {
    return matrikula;
  }
}
