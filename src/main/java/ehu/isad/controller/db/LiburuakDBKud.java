package ehu.isad.controller.db;

import ehu.isad.model.Book;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LiburuakDBKud {

    private static LiburuakDBKud instantzia = new LiburuakDBKud();

    private LiburuakDBKud () {

    }

    public static LiburuakDBKud getInstantzia(){
        return instantzia;
    }


    public void gordeLiburua(Book book){
        DBKudeatzaile dbkud = DBKudeatzaile.getInstantzia();
        String query = "insert or replace into liburuak (izenburua, egilea, data, isbn, filename) " +
                " values ('" + book.details.title + "','" +
                book.details.authors[0].name + "','" +
                book.details.publish_date + "','" +
                book.isbn + "','" +
                book.filename + "')";
        System.out.println(query);
        dbkud.execSQL(query);
    }

    public Book lortuLiburua(int offset) {
        DBKudeatzaile dbkud = DBKudeatzaile.getInstantzia();
        ResultSet rs = dbkud.execSQL("select * from liburuak LIMIT " + offset + ", 1");
        Book book = null;
        try {
            if ( rs.next() ) {
                String isbn = rs.getString("isbn");
                String izenburua = rs.getString("izenburua");
                String egilea = rs.getString("egilea");
                String data = rs.getString("data");
                String filename = rs.getString("filename");
                book = new Book(isbn, izenburua, egilea, data, filename);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return book;
    }
}
