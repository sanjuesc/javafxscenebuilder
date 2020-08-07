package ehu.isad.model;

public class Details {
    public String title;
    public String publishers[];
    public Author authors[];
    public String publish_date;

    public Details(String izenburua, String egilea, String data) {
        this.title = izenburua;
        this.publish_date = data;
        this.authors = new Author[1];
        this.authors[0] = new Author(egilea);
    }
}
