package Utils;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {
	public static Properties properties;

	public static String getProperty(String propertyName) throws IOException {
		FileReader is = new FileReader(System.getProperty("user.dir") + "/config.properties");
		properties = new Properties();
		properties.load(is);
		return properties.getProperty(propertyName);
	}
}