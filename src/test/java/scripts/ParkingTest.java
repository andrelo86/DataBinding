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
    navigateTo(Utils.getValueFromPropertiesFile(Utils.RESOURCES_PATH + "config.properties",
        APPLICATION_URL_KEY));
    ParkingCalculatorPage parkingCalculatorPage = new ParkingCalculatorPage(Driver.getDriver());
    Parking parking = parkingCalculatorPage.buildParking(data);

    parkingCalculatorPage.chooseALot(parking.getLot());
    parkingCalculatorPage
        .setEntryExitDateAndTime("Entry", parking.getEntryTime(), parking.getEntryDate());
    parkingCalculatorPage
        .setEntryExitDateAndTime("Exit", parking.getExitTime(), parking.getExitDate());
    parkingCalculatorPage.calculate();

    if (parking.getLot().equals(SHORT_TERM_PARKING)) {
      assertThat(SHORT_TERM_TOTAL)
          .isEqualTo(parkingCalculatorPage.getDisplayedTotal());

    } else if (parking.getLot().equals(LONG_TERM_GARAGE_PARKING)) {
      assertThat(LONG_TERM_GARAGE_TOTAL).isEqualTo(parkingCalculatorPage.getDisplayedTotal());
    }

  }

}
