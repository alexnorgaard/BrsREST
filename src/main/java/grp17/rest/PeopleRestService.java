package grp17.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

@Path("/people")
public class PeopleRestService {
    @GET // This annotation indicates GET request
    @Path("/{vehicleNum}/compartments")
    public Response compartments(@PathParam("vehicleNum") int id) {
        return Response.status(200).entity("Vehicle NUM: " + id).build();
    }

}
