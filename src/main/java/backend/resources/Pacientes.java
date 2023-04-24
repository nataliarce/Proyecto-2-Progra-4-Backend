/**
 *
 * @author Natalia Arce 
 * @author Michelle Delgado
 * @author Beverly Ugalde
 * 
 */
package backend.resources;


import backend.logic.Paciente;
import backend.logic.ServicePaciente;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.NotAcceptableException;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/pacientes")
public class Pacientes {
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON) 
    public void create(Paciente p) {  
        try {
            ServicePaciente.instance().pacientesCREATE(p);
        } catch (Exception ex) {
            throw new NotAcceptableException(); 
        }
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Paciente> read() throws Exception { 
        return ServicePaciente.instance().pacientesREAD();
        //return new ArrayList();
    }     
    
    @GET
    @Path("{idPaciente}")
    @Produces({MediaType.APPLICATION_JSON})
    public Paciente read(@PathParam("idPaciente") String idPaciente) {
        try {
            return ServicePaciente.instance().pacientesREAD(idPaciente);
        } catch (Exception ex) {
            throw new NotFoundException(); 
        }
    }

//    @PUT
//    @Path("{idPaciente}")
//    @Consumes(MediaType.APPLICATION_JSON)
//    public void update(@PathParam("idPaciente") String idPaciente, Paciente p) {  
//        try {
//            ServicePaciente.instance().pacientesUPDATE(p);
//        } catch (Exception ex) {
//            throw new NotFoundException(); 
//        }
//    }
//
//    @DELETE
//    @Path("{idPaciente}")
//    public void delete(@PathParam("idPaciente") String idPaciente) {
//        try {
//            ServicePaciente.instance().pacientesDELETE(idPaciente);
//        } catch (Exception ex) {
//            throw new NotFoundException(); 
//        }
//    }
  
}
