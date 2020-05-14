package data.source.druid;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

public class DruidDemo {
    public static void main(String[] args) throws Exception {
        Properties prop = new Properties();
        InputStream ris = DruidDemo.class.getClassLoader().getResourceAsStream("druid.properties");
        prop.load(ris);
        DataSource ds = DruidDataSourceFactory.createDataSource(prop);
        Connection conn = ds.getConnection();
        System.out.println(conn);
    }
}
