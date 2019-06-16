package framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import utils.Utils;

public final class Driver {

    private static final String CHROMEDRIVER_PATH = Utils.getValueFromPropertiesFile(Utils.RESOURCES_PATH + "config.properties", "CHROME_DRIVERS");

    private static WebDriver mdriver;

    private enum Browser {
      CHROME, FIREFOX
    }

    /**
     * Class constructor.
     */
    public Driver(String browser) {
      Browser navigator = Browser.valueOf(browser);
      if (navigator == Browser.FIREFOX) {
        mdriver = new FirefoxDriver();

      } else if (navigator == Browser.CHROME) {
        System.setProperty("webdriver.chrome.driver", CHROMEDRIVER_PATH);
        mdriver = new ChromeDriver();
      }
    }

    /**
     * Returns an instance of MyDriver.
     *
     * @return MyDriver
     */
    public static WebDriver getDriver() {
      return mdriver;
    }

}
