package grp17.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

@Path("/containers")
public class ContainerRestService {
    @GET // This annotation indicates GET request
    @Path("/{containerNum}/compartments") //For showing all compartments of a chosen vehicle
    public Response compartments(@PathParam("containerNum") int id) {
        return Response.status(200).entity("Container NUM: " + id).build();
    }

    @GET
    @Path("/{containerNum}/compartment/{compartmentId}") //For showing a specific compartment of a chosen vehicle
    public Response compartmentId(@PathParam("containerNum") int vehicleId, @PathParam("compartmentId") int compartmentId){
        return Response.status(200).entity("CompartmentId: " + compartmentId + " in container: " + vehicleId).build();
    }

    @GET
    @Path("/{containerNum}/compartment/{compartmentId}/items") //For showing list of items in a specific compartment of a chosen vehicle
    public Response compartmentItems(@PathParam("containerNum") int vehicleId, @PathParam("compartmentId") int compartmentId){
        return Response.status(200).entity("CompartmentId: " + compartmentId + " in container: " + vehicleId + " has the following loose items: XYZ").build();
    }

    @GET
    @Path("/{containerNum}/compartment/{compartmentId}/shelves") //For showing list of shelves in a specific compartment of a chosen vehicle
    public Response compartmentShelves(@PathParam("containerNum") int vehicleId, @PathParam("compartmentId") int compartmentId){
        return Response.status(200).entity("CompartmentId: " + compartmentId + " in container: " + vehicleId + " has the following shelves: ÆØÅ").build();
    }
}
