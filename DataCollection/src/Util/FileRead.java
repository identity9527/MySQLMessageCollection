package Util;

import java.io.*;

public class FileRead {

    public static void main(String[] args){
        FileRead fileRead = new FileRead();
        String path = fileRead.getClass().getResource("/").getPath();
        File dir = new File(path+File.separator+"Data");
        if(dir.isDirectory()){
            for(int i=0;i<10000;i++){
                File file = new File(dir.getPath()+File.separator+i+".txt");
                if(!file.exists()){
                    if(file.getParentFile().exists()){
                        try {
                            if(file.createNewFile()){
                                BufferedWriter writer = new BufferedWriter(new FileWriter(file));
                                for(int j=0;j<1000;j++){
                                    writer.write((i*1000+j)+",1,2020-11-07,11," +
                                            "x0111,x0111,11.25,x0111,x0111,11,x0111," +
                                            "x0111");
                                    writer.newLine();
                                }
                                writer.flush();
                                writer.close();
                            }
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                    }
                }
            }
        }
        System.out.println(dir.getPath());
        /*FileTask task = FileTask.getInstance();*/
    }
}
