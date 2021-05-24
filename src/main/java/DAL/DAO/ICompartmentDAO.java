package DAL.DAO;

import DAL.ICompartmentDTO;

public interface ICompartmentDAO {

  void createCompartment(ICompartmentDTO compartment) throws DALException;
  ICompartmentDTO getCompartment(int compartmentId) throws DALException;
  void updateCompartment(ICompartmentDTO compartment) throws DALException;
  void deleteCompartment(int compartmentId) throws DALException;

  public class DALException extends Exception{

    public DALException(String message) {
    }
  }
}
