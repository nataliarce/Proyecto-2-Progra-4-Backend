package backend.resources;

import backend.logic.Enfermedad;
import backend.logic.ServiceEnfermedades;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.NotAcceptableException;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Natalia Arce 
 * @author Michelle Delgado
 * @author Beverly Ugalde
 * 
 */

@Path("/enfermedades")
public class Enfermedades {
    @POST
    @Consumes(MediaType.APPLICATION_JSON) 
    public void create(Enfermedad e) {  
        try {
            ServiceEnfermedades.instance().enfermedadCREATE(e);
        } catch (Exception ex) {
            throw new NotAcceptableException(); 
        }
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Enfermedad> read() throws Exception { 
        return ServiceEnfermedades.instance().enfermedadesREAD();  
        //return new ArrayList();
    }
    
    @GET
    @Path("{idEnfermedades}")
    @Produces({MediaType.APPLICATION_JSON})
    public Enfermedad read(@PathParam("idEnfermedades") String idEnfermedades) {
        try {
            return ServiceEnfermedades.instance().enfermedadREAD(idEnfermedades);
        } catch (Exception ex) {
            throw new NotFoundException(); 
        }
    }
}
