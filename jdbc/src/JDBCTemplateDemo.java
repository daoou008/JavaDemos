import org.springframework.jdbc.core.JdbcTemplate;
import util.JDBCUtils;

public class JDBCTemplateDemo {
    public static void main(String[] args) {
        JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
        String sql = "UPDATE account SET balance = 5000 WHERE id = ?";
        int count = template.update(sql, 6);
        System.out.println(count);
    }
}
