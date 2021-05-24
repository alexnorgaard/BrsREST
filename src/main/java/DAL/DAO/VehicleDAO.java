package DAL.DAO;

import DAL.IVehicleDTO;
import DAL.VehicleDTO;

import java.sql.*;
import java.util.LinkedList;

public class VehicleDAO implements IVehicleDAO {

  private Connection createConnection() throws SQLException {
    System.out.println("connecting");
    final String username = "alexander";
    final String password = "Sf49ers49";
    try {
      Class.forName("org.mariadb.jdbc.Driver");
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
    return DriverManager.getConnection("jdbc:mariadb://130.225.170.83:3306/testbrs?user=alexander&password=Sf49ers49");
    //static final String db_url = "jdbc:mariadb://130.225.170.83:3306/
    //return DriverManager.getConnection("jdbc:mariadb://130.225.170.83:3306/testbrs", username, password);
  }

  @Override
  public void createVehicle(IVehicleDTO vehicle) throws DALException {
    try (Connection c = createConnection()){
      Statement statement = c.createStatement();
      ResultSet rs = statement.executeQuery("SELECT * FROM vehicles WHERE vehicles_id = " + vehicle.getVehicleId());
      LinkedList<Integer> uid = new LinkedList<>();
      boolean idUsed = false;

      if(rs.next()){
        throw  new DALException("ID already in use");
      }

      PreparedStatement prepState = c.prepareStatement("INSERT INTO vehicles VALUES (?,?,?,?,?)");

      prepState.setInt(1,vehicle.getVehicleId());
      prepState.setInt(2,vehicle.getLicense());
      prepState.setString(3,vehicle.getVehicleType());
      prepState.setString(4,vehicle.getVehiclePurpose());
      prepState.setString(5,vehicle.getUnitResponsible());
      prepState.executeUpdate();

    } catch (SQLException e) {
      throw new DALException(e.getMessage());
    }
  }

  @Override
  public IVehicleDTO getVehicle(int vehicleId) throws DALException {
    IVehicleDTO vehicle = new VehicleDTO();

    try (Connection c = createConnection()){
     // ResultSet rs;
     // String query = "SELECT * FROM vehicles WHERE vehicles_id = ?";
     // PreparedStatement vehicleQuery = c.prepareStatement(query);
     // vehicleQuery.setInt(1, vehicleId);
     // rs = vehicleQuery.executeQuery();
     // rs.next();
      Statement st = c.createStatement();
      ResultSet rs = st.executeQuery("SELECT * FROM vehicles WHERE license = " + vehicleId);
      rs.next();

      vehicle.setVehicleId(rs.getInt("vehicles_id"));
      vehicle.setLicense(rs.getInt("license"));
      vehicle.setVehicleType(rs.getString("vehicle_type"));
      vehicle.setVehiclePurpose(rs.getString("vehicle_purpose"));
      vehicle.setUnitResponsible(rs.getString("unit_responsible"));

    } catch (SQLException e) {
      System.out.println(e);
      throw new DALException(e.getMessage());
    }
    return vehicle;
  }

  @Override
  public void updateVehicle(IVehicleDTO vehicle) throws DALException {
    try (Connection c = createConnection()){
      PreparedStatement st = c.prepareStatement("UPDATE vehicles SET license = ?, vehicle_type = ?, vehicle_purpose = ?, unit_responsible = ? WHERE vehicles_id = ?");

      st.setInt(1,vehicle.getLicense());
      st.setString(2,vehicle.getVehicleType());
      st.setString(3,vehicle.getVehiclePurpose());
      st.setString(4,vehicle.getUnitResponsible());
      st.setInt(5,vehicle.getVehicleId());
      st.executeUpdate();

    } catch (SQLException e) {
      throw new DALException(e.getMessage());
    }
  }

  @Override
  public void deleteVehicle(int vehicleId) throws DALException {
    try (Connection c = createConnection()){
      PreparedStatement st = c.prepareStatement("DELETE * FROM vehicles WHERE vehicles_id = ?");

      st.setInt(1,vehicleId);

    } catch (SQLException e) {
      throw new DALException(e.getMessage());
    }
  }
}
