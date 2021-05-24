package DAL.DAO;

import DAL.IVehicleDTO;

public interface IVehicleDAO {

  void createVehicle(IVehicleDTO vehicle) throws DALException;
  IVehicleDTO getVehicle(int vehicleId) throws DALException;
  void updateVehicle(IVehicleDTO vehicle) throws DALException;
  void deleteVehicle(int vehicleId) throws DALException;

  public class DALException extends Exception{

    public DALException(String id_already_in_use) {
    }
  }
}
