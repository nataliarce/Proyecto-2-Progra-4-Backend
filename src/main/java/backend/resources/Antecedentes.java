package backend.resources;

import backend.logic.Antecedente;
import backend.logic.ServiceAntecedente;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.NotAcceptableException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Natalia Arce 
 * @author Michelle Delgado
 * @author Beverly Ugalde
 * 
 */

@Path("/antecedentes")
public class Antecedentes {
    @POST
    @Consumes(MediaType.APPLICATION_JSON) 
    public void create(Antecedente a) {  
        try {
            ServiceAntecedente.instance().antecedentesCREATE(a);
        } catch (Exception ex) {
            throw new NotAcceptableException(); 
        }
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Antecedente> read() throws Exception { 
        return ServiceAntecedente.instance().antecedentesREAD();  
    }     
   
    
}
