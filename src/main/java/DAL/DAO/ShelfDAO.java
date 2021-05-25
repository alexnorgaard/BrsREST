package DAL.DAO;

import DAL.IShelfDTO;
import DAL.ShelfDTO;

import java.sql.*;
import java.util.LinkedList;

public class ShelfDAO implements IShelfDAO {

  private Connection createConnection() throws SQLException {
    return DriverManager.getConnection("jdbc:mariadb://130.225.170.83:3306/db?user=soren&password=password");
  }

  @Override
  public void createShelf(IShelfDTO shelf) throws DALException {
    try (Connection c = createConnection()){
      Statement statement = c.createStatement();
      ResultSet rs = statement.executeQuery("SELECT * FROM shelves WHERE shelves_id = " + shelf.getShelfId());
      LinkedList<Integer> uid = new LinkedList<>();
      boolean idUsed = false;

      if(rs.next()){
        throw  new DALException("ID already in use");
      }

      PreparedStatement prepState = c.prepareStatement("INSERT INTO shelves (shelves_id, shelf_name_col, compartments_compartments_id, vehicles_vehicles_id, containers_containers_id) VALUES (?,?,?,?,?)");


      prepState.setInt(1,shelf.getShelfId());
      prepState.setString(2,shelf.getShelfName());
      prepState.setInt(3,shelf.getCompartmentId());
      prepState.setInt(4,shelf.getVehicleId());
      prepState.setInt(5,shelf.getContainerId());
      prepState.executeUpdate();

    } catch (SQLException e) {
      throw new DALException(e.getMessage());
    }
  }

  @Override
  public IShelfDTO getShelf(int shelfId) throws DALException {
    IShelfDTO shelf = new ShelfDTO();

    try (Connection c = createConnection()){

      Statement st = c.createStatement();
      ResultSet rs = st.executeQuery("SELECT * FROM shelves WHERE shelves_id = " + shelfId);
      rs.next();

      shelf.setShelfId(rs.getInt("shelves_id"));
      shelf.setShelfName(rs.getString("shelf_name_col"));
      shelf.setCompartmentId(rs.getInt("compartments_id"));
      shelf.setVehicleId(rs.getInt("vehicles_id"));
      shelf.setContainerId(rs.getInt("containers_id"));

    } catch (SQLException e) {
      throw new DALException(e.getMessage());
    }
    return shelf;
  }

  @Override
  public void updateShelf(IShelfDTO shelf) throws DALException {
    try (Connection c = createConnection()){
      PreparedStatement st = c.prepareStatement("UPDATE shelves SET shelf_name_col = ?, compartments_id = ?, vehicles_id = ?, containers_id = ?, WHERE shelves_id = ?");

      st.setString(1,shelf.getShelfName());
      st.setInt(2,shelf.getCompartmentId());
      st.setInt(3,shelf.getVehicleId());
      st.setInt(4,shelf.getContainerId());
      st.setInt(5,shelf.getShelfId());
      st.executeUpdate();

    } catch (SQLException e) {
      throw new DALException(e.getMessage());
    }
  }

  @Override
  public void deleteShelf(int shelfId) throws DALException {
    try (Connection c = createConnection()){
      PreparedStatement st = c.prepareStatement("DELETE * FROM shelves WHERE shelves_id = ?");

      st.setInt(1,shelfId);

    } catch (SQLException e) {
      throw new DALException(e.getMessage());
    }
  }
}
