package rates;

public class LongTermGarageTotal extends ParkingCalculator {


  public LongTermGarageTotal() {
    this.rate = 10.8;
  }

  @Override
  public Double calculate(Double total) {
    return total * rate;
  }
}
