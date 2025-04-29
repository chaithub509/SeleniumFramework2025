package Utils1;

import java.util.logging.LogManager;
import java.util.logging.Logger;

public class logs {

    private static final Logger logger = Logger.getLogger(logs.class.getName());


    public static void info(String message){
         logger.info(message);
     }

    public static void warn(String message){
        logger.info(message);
    }

    public static void error(String message){
        logger.info(message);
    }

    public static void debug(String message){
        logger.info(message);
    }



}
