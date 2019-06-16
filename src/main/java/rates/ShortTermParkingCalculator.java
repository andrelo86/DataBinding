package rates;

public class ShortTermParkingCalculator extends ParkingCalculator {

  public ShortTermParkingCalculator() {
    this.rate = 2.00;
  }

  @Override
  public Double calculate(Double total) {
    return total * rate;
  }
}
