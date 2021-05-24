package DAL.DAO;

import DAL.IShelfDTO;

public interface IShelfDAO {

  void createShelf(IShelfDTO shelf) throws DALException;
  IShelfDTO getShelf(int shelfId) throws DALException;
  void updateShelf(IShelfDTO shelf) throws DALException;
  void deleteShelf(int shelfId) throws DALException;

  public class DALException extends Exception{

    public DALException(String id_already_in_use) {
    }
  }
}
