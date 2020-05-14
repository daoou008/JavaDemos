import util.JDBCUtilsC3p0;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCDemo4 {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstmt1 = null;
        PreparedStatement pstmt2 = null;

        try {
            conn = JDBCUtilsC3p0.getConnection();
            //开启事务
            conn.setAutoCommit(false);

            String sql1 = "UPDATE account SET balance = balance - ? WHERE name = ?";
            String sql2 = "UPDATE account SET balance = balance + ? WHERE name = ?";

            pstmt1 = conn.prepareStatement(sql1);
            pstmt1.setDouble(1, 500);
            pstmt1.setString(2, "张三");

            //int i = 3/0;

            pstmt2 = conn.prepareStatement(sql2);
            pstmt2.setDouble(1, 500);
            pstmt2.setString(2, "李四");

            pstmt1.executeUpdate();
            pstmt2.executeUpdate();

            //提交事务
            conn.commit();
        } catch (Exception throwables) {
            if (null != conn){
                try {
                    conn.rollback();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            throwables.printStackTrace();
        } finally {
            JDBCUtilsC3p0.close(pstmt1, conn);
            JDBCUtilsC3p0.close(pstmt2, null);
        }

    }
}
