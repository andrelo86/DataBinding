package utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import org.apache.log4j.Logger;
import org.testng.annotations.DataProvider;

public class Utils {

  private static final String COMMA_DELIMITER = ",";
  private static Logger logger = Logger.getLogger(Utils.class);

  public static final String RESOURCES_PATH = "src" + File.separator
      + "main" + File.separator
      + "resources" + File.separator;

  private static final String TEST_CSV_PATH = "src" + File.separator
      + "test" + File.separator;

  private Utils() {
  }

  public static String getValueFromPropertiesFile(String file, String key) {
    try (InputStream input = new FileInputStream(file)) {

      Properties prop = new Properties();

      prop.load(input);

      return prop.getProperty(key);

    } catch (IOException ex) {
      logger.info("Cannot read from file: " + ex);
      return null;
    }
  }

  @DataProvider(name = "test")
  public static Iterator<Object[]> provider() throws IOException {
    List<Object[]> testCases = new ArrayList<>();
    String[] data;

    try (BufferedReader br = new BufferedReader(new FileReader(TEST_CSV_PATH + "data.csv"))) {
      String line;
      while ((line = br.readLine()) != null) {
        data = line.split(COMMA_DELIMITER);
        testCases.add(data);
      }
      return testCases.iterator();
    }
  }

}
