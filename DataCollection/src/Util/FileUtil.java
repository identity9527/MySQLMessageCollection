package Util;

import java.io.File;
import java.util.ArrayList;

public class FileUtil {

    public static ArrayList<File> getAllFile(String filePath){
        ArrayList<File> result = new ArrayList<>();
        getAllFile(new File(filePath),result);
        return result;
    }

    private static void getAllFile(File originalFile,ArrayList<File> result){
        if(originalFile.isFile()){
            result.add(originalFile);
        }else {
            File[] childFiles = originalFile.listFiles();
            if (childFiles != null) {
                for(File childFile:childFiles){
                    getAllFile(childFile,result);
                }
            }
        }
    }
}
