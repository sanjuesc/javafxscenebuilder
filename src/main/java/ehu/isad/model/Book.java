package ehu.isad.model;

public class Book {
    public String thumbnail_url;
    public Details details;
    public String isbn;
    public String filename;

    public Book(String isbn, String izenburua, String egilea, String data, String filename) {
        this.isbn = isbn;
        this.filename = filename;
        this.details = new Details(izenburua, egilea, data);
    }
}
