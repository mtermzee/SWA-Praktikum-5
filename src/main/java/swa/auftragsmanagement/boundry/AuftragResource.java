package swa.auftragsmanagement.boundry;

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

import swa.auftragsmanagement.control.AuftragService;
import swa.auftragsmanagement.entity.Auftrag;

@Path("/orders")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AuftragResource {

    @Inject
    AuftragService auftragService;

    @PostConstruct
    public void init() {
        this.auftragService.addAuftrag("Transport to Dubai");
        this.auftragService.addAuftrag("Transport to New York");
        this.auftragService.addAuftrag("Transport to London");
    }

    @GET
    public Response getAuftrags() {
        List<Auftrag> orders = this.auftragService.getAuftrags();
        if (!orders.isEmpty())
            return Response.ok(orders).build();
        return Response.status(Response.Status.NOT_FOUND).entity("no Orders was found!").type("text/plain").build();
    }

    @GET
    @Path("{id}")
    public Response getAuftragByID(@PathParam("id") int id) {
        Auftrag order = this.auftragService.getAuftragByID(id);
        if (order != null)
            return Response.ok(order).build();
        return Response.status(Response.Status.NOT_FOUND).entity("no Order was found!").type("text/plain").build();
    }

    @POST
    @Path("{description}")
    public Response addAuftrag(@PathParam("description") String description) {
        Auftrag order = this.auftragService.addAuftrag(description);
        if (order != null)
            return Response.ok(order).build();
        return Response.status(Response.Status.BAD_REQUEST).entity("Order was not added!").type("text/plain").build();
    }

    @PUT
    @Path("{id}")
    public Response updateAuftrag(@PathParam("id") int id, @QueryParam("description") String description) {
        Auftrag order = this.auftragService.updateAuftrag(id, description);
        if (order != null)
            return Response.ok(order).build();
        return Response.status(Response.Status.BAD_REQUEST).entity("Order was not updated!").type("text/plain").build();
    }

    @DELETE
    @Path("{id}")
    public Response deleteAuftrag(@PathParam("id") int id) {
        Auftrag order = this.auftragService.deleteAuftrag(id);
        if (order != null)
            return Response.ok(order).build();
        return Response.status(Response.Status.BAD_REQUEST).entity("Order was not removed!").type("text/plain").build();

    }
}
