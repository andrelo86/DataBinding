package scripts;

import static org.assertj.core.api.Assertions.assertThat;

import entities.Parking;
import framework.BaseTest;
import framework.Driver;
import org.testng.annotations.Test;
import pages.ParkingCalculatorPage;
import utils.Utils;

public class ParkingTest extends BaseTest {

  private static final String APPLICATION_URL_KEY = "APPLICATION_URL";
  private static final String SHORT_TERM_TOTAL = "$ 2.00";
  private static final String LONG_TERM_GARAGE_TOTAL = "$ 108.00";
  private static final String SHORT_TERM_PARKING = "Short-Term Parking";
  private static final String LONG_TERM_GARAGE_PARKING = "Long-Term Garage Parking";

  @Test(testName = "createParking", dataProvider = "test", dataProviderClass = Utils.class)
  public void createShortTermParking(String... data) {
    Parking shortParking = new Parking(data[0], data[1], data[2], data[3], data[4]); //This could be improved. POJO
    navigateTo(Utils.getValueFromPropertiesFile(Utils.RESOURCES_PATH + "config.properties",
        APPLICATION_URL_KEY));
    ParkingCalculatorPage parkingCalculatorPage = new ParkingCalculatorPage(Driver.getDriver());
    parkingCalculatorPage.chooseALot(shortParking.getLot());
    parkingCalculatorPage
        .setEntryExitDateAndTime("Entry", shortParking.getEntryTime(), shortParking.getEntryDate());
    parkingCalculatorPage
        .setEntryExitDateAndTime("Exit", shortParking.getExitTime(), shortParking.getExitDate());
    parkingCalculatorPage.calculate();

    if (shortParking.getLot().equals(SHORT_TERM_PARKING)) {
      assertThat(SHORT_TERM_TOTAL)
          .isEqualTo(parkingCalculatorPage.getTotal());

    } else if (shortParking.getLot().equals(LONG_TERM_GARAGE_PARKING)){
      assertThat(LONG_TERM_GARAGE_TOTAL).isEqualTo(parkingCalculatorPage.getTotal());
    }

  }

}
