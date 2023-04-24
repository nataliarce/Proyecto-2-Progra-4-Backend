/**
 *
 * @author Natalia Arce 
 * @author Michelle Delgado
 * @author Beverly Ugalde
 * 
 */


package backend.resources;

import backend.logic.Cita;
import backend.logic.ServiceCita;
import java.time.LocalDate;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.NotAcceptableException;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/agenda")
public class Agenda {
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON) 
    public void insertarCita(Cita cita) 
    {  
        try {
            ServiceCita.instance().insertarCita(cita);
        } catch (Exception ex) {
            throw new NotAcceptableException(); 
        }
    }
    
    @GET
    @Path("{idDoctor}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Cita> read(@PathParam("idDoctor") String idDoctor) {
        try {
            return ServiceCita.instance().readCitasDeLaSemana(idDoctor);
        } catch (Exception ex) {
            throw new NotFoundException(); 
        }
    }
    
    @DELETE
    @Path("{idCita}")
    public void delete(@PathParam("idCita") String idCita) {
        try {
            ServiceCita.instance().eliminarCita(idCita);
        } catch (Exception ex) {
            throw new NotFoundException(); 
        }
    }
}
