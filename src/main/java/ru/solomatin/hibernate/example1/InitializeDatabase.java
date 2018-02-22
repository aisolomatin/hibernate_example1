package ru.solomatin.hibernate.example1;

import org.apache.commons.io.IOUtils;
import org.hibernate.cfg.Configuration;
import ru.solomatin.hibernate.example1.Main;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Properties;

/**
 * Created by lesha on 15.02.2018.
 */
public class InitializeDatabase {

    public static void InitDB(Configuration configuration) throws Exception {

        String sql = readFile("/sql/start.sql");

        Properties prop = configuration.getProperties();

        Connection connection = null;
        String url = (String) prop.get("hibernate.connection.url");
        String name = (String) prop.get("hibernate.connection.username");
        String password = (String) prop.get("hibernate.connection.password");

        try {
            Class.forName((String) prop.get("hibernate.connection.driver_class"));
            connection = DriverManager.getConnection(url, name, password);
            Statement statement = connection.createStatement();
            statement.execute(sql);
        }
        finally {
            if (connection != null) {
                connection.close();
            }
        }

    }

    private static String readFile(String filename) throws IOException {

        return IOUtils.toString(Main.class.getResourceAsStream(filename), "UTF-8");
    }
}
