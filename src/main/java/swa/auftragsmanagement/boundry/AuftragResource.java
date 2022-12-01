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
        return Response.ok(orders).build();
    }

    @GET
    @Path("{id}")
    public Response getAuftragByID(@PathParam("id") int id) {
        Auftrag order = this.auftragService.getAuftragByID(id);
        return Response.ok(order).build();
    }

    @POST
    @Path("{description}")
    public Response addAuftrag(@PathParam("description") String description) {
        this.auftragService.addAuftrag(description);
        return Response.ok().build();
    }

    @PUT
    @Path("{id}")
    public Response updateAuftrag(@PathParam("id") int id, @QueryParam("description") String description) {
        this.auftragService.updateAuftrag(id, description);
        return Response.ok().build();
    }

    @DELETE
    @Path("{id}")
    public Response deleteAuftrag(@PathParam("id") int id) {
        this.auftragService.deleteAuftrag(id);
        return Response.ok().build();
    }
}
