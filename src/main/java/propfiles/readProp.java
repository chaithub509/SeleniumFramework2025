package propfiles;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class readProp {

    private static final Logger log = LoggerFactory.getLogger(readProp.class);

    public static void main (String[] args) throws IOException {
        Properties readproperties = new Properties();
        String filePath= System.getProperty("user.dir")+"\\src\\main\\java\\Utils1\\config.properties";

            FileInputStream fis = new FileInputStream(filePath);
            readproperties.load(fis);
            fis.close();
    }
}
