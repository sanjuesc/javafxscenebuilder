package ehu.isad;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import ehu.isad.model.Book;
import org.jsoup.Jsoup;
import java.io.IOException;
import java.util.Map;

class JsonClass {
    public static void main(String[] args) throws IOException {

        String ISBN = "1883601126";
        org.jsoup.nodes.Document docKb = Jsoup
                .connect("https://openlibrary.org/api/books?bibkeys=ISBN:"+ ISBN + "&jscmd=details&format=json")
                .ignoreContentType(true).get();
        String json = docKb.body().text();

        java.lang.reflect.Type type =
                new TypeToken<Map<String, Book>>(){}.getType();

        Map<String, Book> fullJson = new Gson().fromJson(json, type);

        Book book = fullJson.get("ISBN:" + ISBN);
            System.out.println("Author: " + book.details.authors[0].name);
            System.out.println("Title: " + book.details.title);
            System.out.println("Thumb: " + book.thumbnail_url);
            System.out.println("Editor:  " + book.details.publishers[0]);
            System.out.println("Publish date:  " + book.details.publish_date);

    }

}
