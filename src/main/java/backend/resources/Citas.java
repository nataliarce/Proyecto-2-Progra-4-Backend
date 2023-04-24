/**
 *
 * @author Natalia Arce 
 * @author Michelle Delgado
 * @author Beverly Ugalde
 * 
 */
package backend.resources;


import backend.logic.Cita;
import backend.logic.Resultado;
import backend.logic.ServiceCita;
import backend.logic.ServiceResultado;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.NotAcceptableException;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/citas")
public class Citas {
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Cita> read() throws Exception { 
        return ServiceCita.instance().citasREAD();
        //return new ArrayList();
    }     
    
    @GET
    @Path("{idPaciente}/paciente")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Cita> read(@PathParam("idPaciente") String idPaciente) {
        try {
            return ServiceCita.instance().citasPorIdPacienteREAD(idPaciente);
        } catch (Exception ex) {
            throw new NotFoundException(); 
        }
    }
    
    @GET
    @Path("{idCita}")
    @Produces({MediaType.APPLICATION_JSON})
    public Cita read(@PathParam("idCita") int idCita) {
        try {
            return ServiceCita.instance().citaPorIdREAD(idCita);
        } catch (Exception ex) {
            throw new NotFoundException(); 
        }
    }
    
    @POST
    @Path("{idCita}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void crearResultado(@PathParam("idCita") int idCita, Resultado r) {  
        try {
            ServiceResultado.instance().crearResultado(r, idCita);
            ServiceCita.instance().citaUPDATE(idCita);
            
        } catch (Exception ex) {
            throw new NotFoundException(); 
        }
    }
}
