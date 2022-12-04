package swa.flottenmanagement.boundry;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import swa.flottenmanagement.control.SchiffService;
import swa.flottenmanagement.entity.Schiff;

@Path("/ships")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class SchiffResource {

    @Inject
    SchiffService schiffService;

    @PostConstruct
    public void init() {
        this.schiffService.addSchiff("Titanic");
        this.schiffService.addSchiff("Queen Mary");
        this.schiffService.addSchiff("Queen Elizabeth");
    }

    @GET
    public Response getSchiffs() {
        List<Schiff> ships = this.schiffService.getSchiffs();
        if (!ships.isEmpty())
            return Response.ok(ships).build();
        return Response.status(Response.Status.NOT_FOUND).entity("no Ships was found!").type("text/plain").build();
    }

    @GET
    @Path("{id}")
    public Response getSchiffByID(@PathParam("id") int id) {
        Schiff ship = this.schiffService.getSchiff(id);
        if (ship != null)
            return Response.ok(ship).build();
        return Response.status(Response.Status.NOT_FOUND).entity("no Ship was found!").type("text/plain").build();
    }

    @POST
    @Path("{name}")
    public Response addSchiff(@PathParam("name") String name) {
        Schiff ship = this.schiffService.addSchiff(name);
        if (ship != null)
            return Response.ok(ship).build();
        return Response.status(Response.Status.BAD_REQUEST).entity("Ship was not added!").type("text/plain").build();
    }

    @PUT
    @Path("{id}")
    public Response updateSchiff(@PathParam("id") int id, @QueryParam("name") String name) {
        Schiff ship = this.schiffService.updateSchiff(id, name);
        if (ship != null)
            return Response.ok(ship).build();
        return Response.status(Response.Status.BAD_REQUEST).entity("Ship was not updated!").type("text/plain").build();
    }

    @DELETE
    @Path("{id}")
    public Response deleteSchiff(@PathParam("id") int id) {
        Schiff ship = this.schiffService.removeSchiff(id);
        if (ship != null)
            return Response.ok(ship).build();
        return Response.status(Response.Status.BAD_REQUEST).entity("Ship was not removed!").type("text/plain").build();
    }

}
