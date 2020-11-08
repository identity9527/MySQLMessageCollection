package Business;

import Constant.StringConstant;
import Util.ConnectionManager;

import java.io.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class StoreTask implements Runnable {

    @Override
    public void run() {
        Connection connection = ConnectionManager.getConnectionFromThreadLocal();
        FileTask fileTask = FileTask.getInstance();
        Statement statement = null;
        File file;
        try {
            assert connection != null;
            statement = connection.createStatement();
            while ((file = fileTask.getFileTask()) != null) {
                String url = "insert into "
                        +StringConstant.TABLE_NAME
                        + StringConstant.COLUMN_NAME
                        + " values " + getMessageLine(file);
                statement.executeUpdate(url);
            }
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }finally {
            try {
                statement.close();
                connection.close();
            } catch (SQLException throwable) {
                throwable.printStackTrace();
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("End time:"+end+"ms");
        System.out.println("Consume Time:"+(end-DataCollection.start)+"ms("+((end-DataCollection.start)/1000.0)+"s)");
    }

    private String getMessageLine(File file){
        StringBuilder builder = new StringBuilder();
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = reader.readLine()) != null) {
                builder.append("(");
                builder.append(getMessageLine(line.split(",")));
                builder.append("),");
            }
        } catch (FileNotFoundException fileNotFoundException) {
            System.out.println("Do not find file: " + file.getName());
            fileNotFoundException.printStackTrace();
            return "()";
        } catch (IOException ioException){
            System.out.println("Find IOException in: " + file.getName());
            ioException.printStackTrace();
            return "()";
        }
        if(builder.length()==0){
            return "()";
        }else {
            return builder.substring(0,builder.length()-1);
        }
    }

    private String getMessageLine(String[] message){
        StringBuilder builder = new StringBuilder();
        builder.append(message[0]+",");
        builder.append(message[1]+",");
        builder.append("'"+message[2]+"',");
        builder.append(message[3]+",");
        builder.append("\""+message[4]+"\",");
        builder.append("\""+message[5]+"\",");
        builder.append(message[6]+",");
        builder.append("\""+message[7]+"\",");
        builder.append("\""+message[8]+"\",");
        builder.append(message[9]+",");
        builder.append("\""+message[10]+"\",");
        builder.append("\""+message[11]+"\"");
        return builder.toString();
    }
}


/**
 CREATE TABLE IF NOT EXISTS `government_msg`(
    `msg_id` int UNSIGNED AUTO_INCREMENT,
    `first` int,
    `second` date,
    `third` int,
    `forth` varchar(40),
    `fifth` varchar(40),
    `sixth` double,
    `seventh` varchar(40),
    `eighth` varchar(40),
    `ninth` int,
    `tenth` varchar(40),
    `eleventh` varchar(40),
    PRIMARY KEY (`msg_id`)
 )ENGINE=InnoDB DEFAULT CHARSET=utf8;
* */