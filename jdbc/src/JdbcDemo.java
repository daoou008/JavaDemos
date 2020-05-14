import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JdbcDemo {
    public static void main(String[] args) {
        InputStream is = null;
        Connection conn = null;
        Statement statement = null;

        try {
            //获取properties文件，读取用户名和密码信息
            ClassLoader classLoader = JdbcDemo.class.getClassLoader();
            is = classLoader.getResourceAsStream("jdbc.properties");
            Properties properties = new Properties();
            properties.load(is);
            String userName = properties.getProperty("userName");
            String password = properties.getProperty("password");

            //注册jar包
            Class.forName("com.mysql.jdbc.Driver");
            //获取mysql连接
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db1", userName, password);
            String sql = "UPDATE student SET student_age = 118 WHERE student_id = 1;";
            //创建Statement
            statement = conn.createStatement();
            //执行SQL语句
            int count = statement.executeUpdate(sql);
            System.out.println(count);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            //释放资源
            if (statement != null){
                try {
                    statement.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if (conn != null){
                try {
                    conn.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if (is != null){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
