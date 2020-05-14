import person.Student;
import util.JDBCUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBCDemo3 {
    public static void main(String[] args) {
        List<Student> students = getAllStudent();
        System.out.println(students);
    }

    public static List<Student> getAllStudent(){
        List<Student> result = null;
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtils.getConnection();
            stmt = conn.createStatement();
            String sql = "SELECT * FROM student;";
            rs = stmt.executeQuery(sql);
            result = new ArrayList<>();
            while (rs.next()){
                int id = rs.getInt("student_id");
                String name = rs.getString("student_name");
                int age = rs.getInt("student_age");
                String sex = rs.getString("student_sex");
                Date birthday = rs.getDate("birthday_date");
                result.add(new Student(id, name, age, sex, birthday));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtils.close(rs, stmt, conn);
        }

        return result;
    }
}
