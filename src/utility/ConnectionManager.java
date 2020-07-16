package utility;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionManager {
	public static Properties loadPropertiesFile() throws Exception {
		Properties prop = new Properties();
		InputStream in = ConnectionManager.class.getClassLoader().getResourceAsStream("jdbc.properties");
		prop.load(in);
		in.close(); 
		return prop;
	}
	public static Connection getConnection() throws Exception {
        Properties prop= loadPropertiesFile();	
		final String driver = prop.getProperty("driver");
		final String url = prop.getProperty("url");
		final String username = prop.getProperty("username");
			final String password = prop.getProperty("password");
			System.out.println(driver);
			System.out.println(url);
			System.out.println(username);
			System.out.println(password);
		Class.forName(driver);  // Registering the jdbc driver
		Connection con = null;
		con = DriverManager.getConnection(url,username,password); // Connecting to database
		return con;
	}
}

