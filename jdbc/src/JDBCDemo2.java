import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class JDBCDemo2 {
    public static void main(String[] args) {
        InputStream is = null;
        Connection conn = null;
        Statement statement = null;
        ResultSet rs = null;

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
            String sql = "SELECT * FROM student;";
            //创建Statement
            statement = conn.createStatement();
            //执行SQL语句
            rs = statement.executeQuery(sql);
            while (rs.next()){
                int id = rs.getInt("student_id");
                String name = rs.getString("student_name");
                System.out.println("学号:" + id + "; 姓名:" + name);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            //释放资源
            if (rs!=null) {
                try {
                    rs.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
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
