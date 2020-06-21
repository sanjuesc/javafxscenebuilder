package ehu.isad.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Utils {

    public static Properties loadProperties()  {
        Properties properties = null;
        InputStream in = null;

        try {
            in = Utils.class.getResourceAsStream("/setup.properties");
            properties = new Properties();
            properties.load(in);
        } catch (
                IOException e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return properties;
    }
}
