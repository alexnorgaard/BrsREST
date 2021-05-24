package grp17.rest;

import DAL.DAO.IItemDAO;
import DAL.DAO.IVehicleDAO;
import DAL.DAO.VehicleDAO;
import DAL.IVehicleDTO;
import DAL.VehicleDTO;
import com.google.gson.Gson;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

@Path("/vehicles")
public class VehicleRestService {
    IVehicleDAO vehicleDAO = new VehicleDAO();
    IVehicleDTO vehicleDTO;
    Gson gson = new Gson();

    @GET // This annotation indicates GET request
    @Path("/{vehicleNum}") //Show data on chosen vehicle
    public Response vehicleInfo(@PathParam("vehicleNum") int id) throws IVehicleDAO.DALException {

       vehicleDTO = vehicleDAO.getVehicle(id);
       String str = gson.toJson(vehicleDTO);
        System.out.println(str);
        return Response.status(200).entity("values: " + str).build();
    }

    @GET
    @Path("/{vehicleNum}/compartments") //For showing all compartments of a chosen vehicle
    public Response compartments(@PathParam("vehicleNum") int id) {
        return Response.status(200).entity("Vehicle NUM: " + id).build();
    }

    @GET
    @Path("/{vehicleNum}/compartment/{compartmentId}") //For showing a specific compartment of a chosen vehicle
    public Response compartmentId(@PathParam("vehicleNum") int vehicleId, @PathParam("compartmentId") int compartmentId){
        return Response.status(200).entity("CompartmentId: " + compartmentId + " in vehicle: " + vehicleId).build();
    }

    @GET
    @Path("/{vehicleNum}/compartment/{compartmentId}/items") //For showing list of items in a specific compartment of a chosen vehicle
    public Response compartmentItems(@PathParam("vehicleNum") int vehicleId, @PathParam("compartmentId") int compartmentId){
        return Response.status(200).entity("CompartmentId: " + compartmentId + " in vehicle: " + vehicleId + " has the following loose items: XYZ").build();
    }

    @GET
    @Path("/{vehicleNum}/compartment/{compartmentId}/shelves") //For showing list of shelves in a specific compartment of a chosen vehicle
    public Response compartmentShelves(@PathParam("vehicleNum") int vehicleId, @PathParam("compartmentId") int compartmentId){
        return Response.status(200).entity("CompartmentId: " + compartmentId + " in vehicle: " + vehicleId + " has the following shelves: ÆØÅ").build();
    }
}
