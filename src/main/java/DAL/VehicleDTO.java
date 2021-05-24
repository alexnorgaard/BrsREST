package DAL;

import java.io.Serializable;

public class VehicleDTO implements Serializable, IVehicleDTO {
  private int vehicleId, license;
  private String vehicleType, vehiclePurpose, unitResponsible;


  @Override
  public int getVehicleId() {
    return vehicleId;
  }

  @Override
  public void setVehicleId(int VehicleId) {
  this.vehicleId = VehicleId;}

  @Override
  public int getLicense() {
    return license;
  }

  @Override
  public void setLicense(int License) {
    this.license = License;
  }

  @Override
  public String getVehicleType() {
    return vehicleType;
  }

  @Override
  public void setVehicleType(String VehicleType) {
    this.vehicleType = VehicleType;
  }

  @Override
  public String getVehiclePurpose() {
    return vehiclePurpose;
  }

  @Override
  public void setVehiclePurpose(String VehiclePurpose) {
    this.vehiclePurpose = VehiclePurpose;
  }

  @Override
  public String getUnitResponsible() {
    return unitResponsible;
  }

  @Override
  public void setUnitResponsible(String UnitResponsible) {
    this.unitResponsible = UnitResponsible;
  }
}
