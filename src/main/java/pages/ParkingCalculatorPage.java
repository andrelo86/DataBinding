package pages;

import components.DatePickerComponent;
import entities.Parking;
import framework.BasePage;
import framework.Locators;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class ParkingCalculatorPage extends BasePage {

  private static Logger logger = getLogger(ParkingCalculatorPage.class.getName());

  private By calculateButton = By.name(Locators.SUBMIT_ID);
  private By total = By.cssSelector(Locators.TOTAL_CSS);


  /**
   * Constructor method.
   */
  public ParkingCalculatorPage(WebDriver pDriver) {
    super(pDriver);
  }

  public void chooseALot(String lot) {
    logger.info("Choosing Lot: " + lot);
    WebElement loanPurposeDropDown = driver
        .findElement(By.id(Locators.LOT_ID));
    Select chooseLot = new Select(loanPurposeDropDown);
    wait.until(
        ExpectedConditions.elementToBeClickable(By.id(Locators.LOT_ID)));
    chooseLot.selectByVisibleText(lot);
  }

  public void setEntryExitDateAndTime(String type, String time, String date) {
    logger.info("Setting input time: " + time);
    driver.findElement(By.id(String.format(Locators.ENTRY_EXIT_TIME_ID, type))).click();
    driver.findElement(By.id(String.format(Locators.ENTRY_EXIT_TIME_ID, type))).clear();
    driver.findElement(By.id(String.format(Locators.ENTRY_EXIT_TIME_ID, type))).sendKeys(time);

    logger.info("Setting input date: "+ date);
    driver.findElement(By.id(String.format(Locators.ENTRY_EXIT_DATE_INPUT_ID, type))).click();
    driver.findElement(By.id(String.format(Locators.ENTRY_EXIT_DATE_INPUT_ID, type))).clear();
    driver.findElement(By.id(String.format(Locators.ENTRY_EXIT_DATE_INPUT_ID, type))).sendKeys(date);
  }

  public void calculate() {
    logger.info("Calculating amount..");
    driver.findElement(calculateButton).click();
  }

  public String getDisplayedTotal() {
    logger.info("Picking total..");
    return driver.findElement(total).getText();
  }

  public Parking buildParking(String[] data) {
    return new Parking(data[0], data[1], data[2], data[3], data[4]);
  }

  public DatePickerComponent selectDatePicker(String datePicker) {
    logger.info("Selecting Date generator: " + datePicker);
    driver.findElement(By.cssSelector(String.format(Locators.ENTRY_EXIT_DATE_PICKER_CSS, datePicker))).click();
    return new DatePickerComponent(driver.getWindowHandle()); // to store before driver state
  }
}
