import util.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCDruidDemo {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        //ResultSet rs = null;
        try{
            //获取连接
            conn = JDBCUtils.getConnection();
            String sql = "insert into account values (null,?,?);";
            //String sql = "SELECT * FROM account WHERE id = ?;";

            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "王五");
            pstmt.setDouble(2, 1000);
            //pstmt.setInt(1,1);

            //此方法pstmt.executeUpdate()必须无参！！！
            int count = pstmt.executeUpdate();
            //rs= pstmt.executeQuery();
            System.out.println(count);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //释放资源
            JDBCUtils.close(pstmt,conn);
        }
    }
}
