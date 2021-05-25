package DAL.DAO;

import DAL.IItemDTO;
import DAL.ItemDTO;

import java.sql.*;
import java.util.LinkedList;

public class ItemDAO implements IItemDAO{

  private Connection createConnection() throws SQLException {
    return DriverManager.getConnection("jdbc:mariadb://130.225.170.83:3306/db?user=soren&password=password");
  }

  @Override
  public void createItem(IItemDTO item) throws DALException {
    try (Connection c = createConnection()){
      //Statement statement = c.createStatement();
      //ResultSet rs = statement.executeQuery("SELECT * FROM items WHERE items_id = " + item.getItemId());
      //LinkedList<Integer> uid = new LinkedList<>();
      //boolean idUsed = false;

      //if(rs.next()){
      //  throw  new DALException("ID already in use");
      //}

      PreparedStatement prepState = c.prepareStatement("INSERT INTO items (item_number, item_name, item_type) VALUES (?,?,?)");


      prepState.setInt(1,item.getItemNumber());
      prepState.setString(2,item.getItemName());
      prepState.setString(3,item.getItemType());
      prepState.executeUpdate();

    } catch (SQLException e) {
      throw new DALException(e.getMessage());
    }
  }

  @Override
  public IItemDTO getItem(int itemId) throws DALException {
    IItemDTO item = new ItemDTO();

    try (Connection c = createConnection()){

      Statement st = c.createStatement();
      ResultSet rs = st.executeQuery("SELECT * FROM items WHERE items_id = " + itemId);
      rs.next();

      item.setItemId(rs.getInt("items_id"));
      item.setItemNumber(rs.getInt("item_number"));
      item.setItemName(rs.getString("item_name"));
      item.setItemType(rs.getString("item_type"));

    } catch (SQLException e) {
      throw new DALException(e.getMessage());
    }
    return item;
  }

  @Override
  public void updateItem(IItemDTO item) throws DALException {
    try (Connection c = createConnection()){
      PreparedStatement st = c.prepareStatement("UPDATE items SET item_number = ?, item_name = ?, item_type = ?, WHERE items_id = ?");

      st.setInt(1,item.getItemNumber());
      st.setString(2,item.getItemName());
      st.setString(3,item.getItemType());
      st.setInt(4,item.getItemId());
      st.executeUpdate();

    } catch (SQLException e) {
      throw new DALException(e.getMessage());
    }
  }

  @Override
  public void deleteItem(int itemId) throws DALException {
    try (Connection c = createConnection()){
      PreparedStatement st = c.prepareStatement("DELETE * FROM items WHERE items_id = ?");

      st.setInt(1,itemId);

    } catch (SQLException e) {
      throw new DALException(e.getMessage());
    }
  }
}
