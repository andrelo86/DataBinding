package framework;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public abstract class BaseTest {

  private Driver driver;

  private static final String BROWSER = "CHROME";


  /**
   * This method contains all before test actions.
   */
  @BeforeTest
  public void beforeTestActions() {
    driver = new Driver(BROWSER);
    Driver.getDriver().manage().deleteAllCookies();
    Driver.getDriver().manage().window().maximize();
  }

  /**
   * This method contains all after test actions.
   */
  @AfterTest
  public void afterTestActions() {
    if (this.driver != null) {
      Driver.getDriver().close();
    }
  }

  /**
   * Return a MyDriver object for using through the test flow.
   *
   * @return MyDriver : Object
   */
  public Driver getMyDriver() {
    return this.driver;
  }

  /**
   * This method focus a driver in our URL request.
   */
  public void navigateTo(String url) {
    Driver.getDriver().get(url);
  }

}
