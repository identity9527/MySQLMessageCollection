package Business;

import Util.FileUtil;

import java.io.File;
import java.util.Iterator;

public class FileTask {

    private static volatile FileTask instance;

    private final Iterator<File> files;

    private FileTask(){
        files = FileUtil.getAllFile(getClass().getResource("/").getPath()+File.separator+"Data").iterator();
    }

    public static FileTask getInstance() {
        if(instance==null){
            synchronized (FileTask.class){
                if(instance==null){
                    instance = new FileTask();
                }
            }
        }
        return instance;
    }

    public File getFileTask(){
        synchronized (files){
            if(files.hasNext()){
                return files.next();
            }else {
                return null;
            }
        }
    }

}