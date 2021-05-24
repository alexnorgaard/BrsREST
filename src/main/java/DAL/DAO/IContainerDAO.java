package DAL.DAO;

import DAL.IContainerDTO;

public interface IContainerDAO {

  void createContainer(IContainerDTO container) throws DALException;
  IContainerDTO getContainer(int containerId) throws DALException;
  void updateContainer(IContainerDTO container) throws DALException;
  void deleteContainer(int containerId) throws DALException;

  public class DALException extends Exception{

    public DALException(String message) {
    }
  }
}
