package framework;

import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {

  protected WebDriver driver;
  protected WebDriverWait wait;


  /**
   * Constructor method.
   */
  public BasePage(WebDriver pDriver) {
    this.driver = pDriver;
    this.wait = new WebDriverWait(pDriver, 10);
    driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
  }

  /**
   * Return a WebDriver object with initialized elements (initElements).
   *
   * @return WebDriver : driver
   */
  public WebDriver getWebDriver() {
    return this.driver;
  }

  /**
   * This method is used to provide to logger a class name.
   *
   * @return String
   */
  public static String getClassName(Object className) {
    return className.getClass().getName();
  }

  /**
   * Return a logger with the name instance class.
   */
  public static Logger getLogger(String className) {
    return Logger.getLogger(className);
  }


}
