package grp17.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

@Path("/people")
public class PeopleRestService {
    @GET // This annotation indicates GET request
    @Path("/{personId}/control/{controlType}")
    public Response personControl(@PathParam("personId") int id, @PathParam("controlType") String type) {
        switch(type){
            case "vehicle":
                return Response.status(200).entity("Person id: " + id + " has controlled the following vehicles: LALALA").build();

            case "container":
                return Response.status(200).entity("Person id: " + id + " has controlled the following containers: LALALA").build();

            case "book":
                return Response.status(200).entity("Person id: " + id + " has the following book entries: LALALA").build();

            default:
                return Response.status(404).entity("There are no entries on this path").build();
        }
    }

}
