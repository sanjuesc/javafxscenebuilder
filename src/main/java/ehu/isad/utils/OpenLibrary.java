package ehu.isad.utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import ehu.isad.model.Book;
import org.jsoup.Jsoup;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

public class OpenLibrary {

    public static String PATH = "/Users/Juanan/.openlibrary";

    public static Book get(String ISBN) throws IOException {
        org.jsoup.nodes.Document docKb = Jsoup
                .connect("https://openlibrary.org/api/books?bibkeys=ISBN:"+ ISBN + "&jscmd=details&format=json")
                .ignoreContentType(true).get();
        String json = docKb.body().text();

        java.lang.reflect.Type type =
                new TypeToken<Map<String, Book>>(){}.getType();

        Map<String, Book> fullJson = new Gson().fromJson(json, type);

        Book book = fullJson.get("ISBN:" + ISBN);

        return book;
    }


    public static String saveImage(String imageUrl, String path) {

        String filepath = path + "/" + Paths.get(imageUrl).getFileName();

        try{
            URL url = new URL(imageUrl);

            InputStream is = url.openStream();
            OutputStream os = new FileOutputStream(filepath);

            byte[] b = new byte[2048];
            int length;

            while ((length = is.read(b)) != -1) {
                os.write(b, 0, length);
            }

            is.close();
            os.close();
        }catch(IOException e){
            e.printStackTrace();
        }

        return filepath;

    }

}
