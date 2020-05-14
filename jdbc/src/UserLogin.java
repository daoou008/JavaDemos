import person.User;
import util.JDBCUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class UserLogin {
    public static void main(String[] args) {
        System.out.println("请输入用户名:");
        Scanner sc = new Scanner(System.in);
        String userName = sc.next();
        System.out.println("请输入密码:");
        String password = sc.next();
        if (login(userName, password)){
            System.out.println("登录成功!");
        } else{
            System.out.println("用户名或密码错误!");
        }
    }

    private static boolean login(String u, String p) {
        if(null == u || null == p){
            return false;
        }

        boolean result = false;

        //HashMap<String, String> userInfo = new HashMap<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = JDBCUtils.getConnection();
            //String sql = "SELECT `username`, `password` FROM `user`";
            //String sql = "SELECT `username`, `password` FROM `user` WHERE `username` = '" + u + "' AND `password` = '" + p + "';";
            String sql = "SELECT * FROM `user` WHERE `username` = ? AND `password` = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, u);
            pstmt.setString(2, p);
            rs = pstmt.executeQuery();
            /*while (rs.next()){
                String username = rs.getString("username");
                String password = rs.getString("password");
                userInfo.put(username, password);
            }

            if (userInfo.containsKey(u) && userInfo.containsValue(p)){
                result = true;
            }*/

            if (rs.next()){
                result = true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(rs, pstmt, conn);
        }

        return result;
    }
}
