package Actions;

import java.io.File;



public class textFile {

    public static void createFolder(String folderPath){

        File folder = new File(folderPath);
        if(!folder.exists()){
            folder.mkdir();
            {
                System.out.println("Folder Create " + folderPath);
            }
        }
    }

    public static void renamefolder(String oldFolderPath,String newFolderPath){
        File oldFolder=new File(oldFolderPath);
                File newFolder= new File(newFolderPath);
                if (!oldFolder.exists()){
                    oldFolder.renameTo(new File("newFolder"));
                    System.out.println("Folder rename to " +newFolderPath);
                }
    }

    public static boolean checkFolderExits(String folderPath) {
        File folderPathexits = new File(folderPath);
        return folderPathexits.exists();
    }


    public static void deleteFolder(String folderPathDelete){
        File deletefolderPath = new File(folderPathDelete);
        if(deletefolderPath.exists()){

            for(File f :deletefolderPath.listFiles()){
                if (f.exists()){
                    f.delete();
                }
            }
            deletefolderPath.delete();
        }
    }
}
