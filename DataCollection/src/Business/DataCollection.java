package Business;

import Constant.IntConstant;
import Constant.StringConstant;
import Util.ConnectionManager;
import Util.FileUtil;

import java.io.File;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Vector;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DataCollection {

    public static long start;

    public static void main(String[] args){
        start = System.currentTimeMillis();
        System.out.println("Start time:"+start+"ms");
        ExecutorService executorService = Executors.newFixedThreadPool(IntConstant.WORK_COUNT);
        for(int i=0;i<IntConstant.TASK_COUNT;i++){
            executorService.submit(new StoreTask());
        }
    }

}
