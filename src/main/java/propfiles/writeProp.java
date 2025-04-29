package propfiles;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class writeProp {


    private static final Logger log = LoggerFactory.getLogger(writeProp.class);

    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();
        properties.setProperty("name","chaitanya");
        properties.setProperty("email","chaitanya.bommina@gmail.com");
        String filePath= System.getProperty("user.dir")+"\\src\\main\\java\\Utils1\\config.properties";
        FileOutputStream fos = new FileOutputStream(filePath);
        properties.store(fos,"username and email");
        fos.close();
        log.info("File got created succesfully under the given path " + filePath);

    }

}
