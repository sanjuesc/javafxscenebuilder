package ehu.isad.model;

public class Ezarpena {

  private Integer userID;
  private String key;
  private String value;

  public Ezarpena(Integer userID, String key, String value) {
    this.userID = userID;
    this.key = key;
    this.value = value;
  }

  @Override
  public String toString() {
    return
        "userID=" + userID +
        ", key='" + key + '\'' +
        ", value='" + value + '\'' +
        "\n";
  }
}
