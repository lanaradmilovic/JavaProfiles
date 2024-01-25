package rs.fon.app;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Hello world!
 *
 */
public class App {

    public static void main(String[] args) {
        App app = new App();
        Properties props = app.loadProperties("application.properties");
        props.forEach((k, v) -> System.out.printf("%s = %s \n", k, v));
    }

    public Properties loadProperties(String file) {
        Properties props = new Properties();
        try ( InputStream resource = getClass().getClassLoader().getResourceAsStream(file)) {
            props.load(resource);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return props;
    }
}
