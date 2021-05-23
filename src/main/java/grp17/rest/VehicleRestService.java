package grp17.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

@Path("/vehicles")
public class VehicleRestService {
    @GET // This annotation indicates GET request
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
}
