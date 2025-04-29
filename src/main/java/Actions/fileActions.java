package Actions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class fileActions {

    private static final Logger log = LoggerFactory.getLogger(fileActions.class);

    public static void createFile(String filePath) throws IOException {
        File pathOfFile= new File(filePath);
        if(pathOfFile.createNewFile()){
            System.out.println("File Created " + pathOfFile.getName());
        } else {
            System.out.println("File already Exits " + pathOfFile);
        }
    }

    public static void fileWriter(String writeFilePath) throws IOException {
        FileWriter writepath= new FileWriter(writeFilePath);
        writepath.write("Chaitanya is a Automation Tester");
        writepath.close();
    }

    public  static void readFile(String readFilePath) throws FileNotFoundException {
        File readPath = new File(readFilePath);
        Scanner sc = new Scanner(readPath);
        while (sc.hasNextLine()){
          String data=sc.nextLine();
          log.info("Reading the data " + data);
        }
        sc.close();
    }
}
