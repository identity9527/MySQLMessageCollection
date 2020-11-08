package Constant;

public class StringConstant {

    /*DataBase Connect Message*/
    public static final String USER_NAME = "root";
    public static final String USER_PASSWORD = "ms17777389675";
    public static final String ORACLE_DRIVER = "oracle.jdbc.OracleDriver";
    public static final String MYSQL_DRIVER = "com.mysql.cj.jdbc.Driver";
    public static final String HOST = "localhost";
    public static final String PORT = "3306";
    public static final String DATABASE_NAME = "government_db";
    public static final String TABLE_NAME = "government_msg";
    public static final String ORACLE_URL = "jdbc:oracle:thin:@"+HOST+":"+PORT+":"+DATABASE_NAME;
    public static final String MYSQL_URL = "jdbc:mysql://"+HOST+":"+PORT+"/"+DATABASE_NAME+"?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    public static final String COLUMN_NAME = "(msg_id,first,second,third,forth,fifth,sixth,seventh,eighth,ninth,tenth,eleventh)";

}
