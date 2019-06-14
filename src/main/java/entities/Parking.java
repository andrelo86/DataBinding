package entities;

/**
 * Parking: POJO()
 */
public class Parking {

  private String lot;
  private String entryDate;
  private String entryTime;
  private String exitDate;
  private String exitTime;


  public Parking(String... values){
    this.lot = values[0];
    this.entryDate = values[1];
    this.entryTime = values[2];
    this.exitDate = values[3];
    this.exitTime = values[4];

  }

  public String getLot() {
    return lot;
  }

  public void setLot(String lot) {
    this.lot = lot;
  }

  public String getEntryDate() {
    return entryDate;
  }

  public void setEntryDate(String entryDate) {
    this.entryDate = entryDate;
  }

  public String getEntryTime() {
    return entryTime;
  }

  public void setEntryTime(String entryTime) {
    this.entryTime = entryTime;
  }

  public String getExitDate() {
    return exitDate;
  }

  public void setExitDate(String exitDate) {
    this.exitDate = exitDate;
  }

  public String getExitTime() {
    return exitTime;
  }

  public void setExitTime(String exitTime) {
    this.exitTime = exitTime;
  }
}
