package DAL.DAO;

import DAL.IItemDTO;

public interface IItemDAO {

  void createItem(IItemDTO item) throws DALException;
  IItemDTO getItem(int itemId) throws DALException;
  void updateItem(IItemDTO item) throws DALException;
  void deleteItem(int itemId) throws DALException;

  public class DALException extends Exception{

    public DALException(String id_already_in_use) {
    }
  }
}
