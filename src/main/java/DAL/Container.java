package DAL;

import java.io.Serializable;

public class Container implements Serializable, IContainerDTO {
  private int containerId, license;
  private String containerType, unitResponsible;

  @Override
  public int getContainerId() {
    return containerId;
  }

  @Override
  public void setContainerId(int ContainerId) {
    this.containerId = containerId;
  }

  @Override
  public int getLicense() {
    return license;
  }

  @Override
  public void setLicense(int License) {
    this.license = license;
  }

  @Override
  public String getContainerType() {
    return containerType;
  }

  @Override
  public void setContainerType(String ContainerType) {
    this.containerType = containerType;
  }

  @Override
  public String getUnitResponsible() {
    return unitResponsible;
  }

  @Override
  public void setUnitResponsible(String UnitResponsible) {
    this.unitResponsible = unitResponsible;
  }
}
