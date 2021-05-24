package DAL.DAO;

import DAL.IVehicleControlDTO;

public interface IVehicleControlDAO {

  void createVehicleControl(IVehicleControlDTO vehicleControl) throws DALException;
  IVehicleControlDTO getVehicleControl(int vehicleControlId) throws DALException;
  void updateVehicleControl(IVehicleControlDTO vehicleControl) throws DALException;
  void deleteVehicleControl(int vehicleControlId) throws DALException;

  public class DALException extends Exception{

    public DALException(String id_already_in_use) {
    }
  }
}
