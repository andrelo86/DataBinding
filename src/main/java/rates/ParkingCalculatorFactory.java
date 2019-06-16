package rates;

public class ParkingCalculatorFactory {

  private ParkingCalculatorFactory(){}

  public static ParkingCalculator createCalculator(String type) {
    switch (type){
      case "Short-Term Parking":
        return new ShortTermParkingCalculator();
      case "Long-Term Garage Parking":
        return new LongTermGarageTotal();
      default:
        throw new NullPointerException();
    }

  }

}
