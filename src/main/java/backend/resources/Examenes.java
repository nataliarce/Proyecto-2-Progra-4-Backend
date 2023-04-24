package backend.resources;
import backend.logic.Examen;
import backend.logic.ServiceExamen;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.POST;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.NotAcceptableException;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.PUT;
import javax.ws.rs.core.Response;
import org.glassfish.jersey.media.multipart.FormDataParam;
/**
 *
 * @author Natalia Arce 
 * @author Michelle Delgado
 * @author Beverly Ugalde
 * 
 */

@Path("/examenes")
public class Examenes {
    String location="C:/Users/Michelle/Documents/pdf";
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON) 
    public void create(Examen e) {  
        try {
            ServiceExamen.instance().examenCREATE(e);
        } catch (Exception ex) {
            throw new NotAcceptableException(); 
        }
    }
    @POST
    @Consumes(MediaType.MULTIPART_FORM_DATA) 
    @Path("{idExamen}/pdf")
    public void addPDF(@PathParam("idExamen") String id, @FormDataParam("pdf") InputStream in) {  
        try{
                OutputStream out = new FileOutputStream(new File(location + id));
                in.transferTo(out);
                out.close();
            } catch (Exception ex) {
                throw new NotAcceptableException(); 
            }
    }
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Examen> read() throws Exception { 
        return ServiceExamen.instance().examenesREAD();
    } 
    @GET
    @Path("{idExamen}")
    @Produces({MediaType.APPLICATION_JSON})
    public Examen read(@PathParam("idExamen") int id) {
        try {
            return ServiceExamen.instance().examenREAD(id);
        } catch (Exception ex) {
            throw new NotFoundException(); 
        }
    }
    @GET
    @Path("{idPaciente}/paciente")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Examen> read(@PathParam("idPaciente") String idPaciente) {
        try {
            return ServiceExamen.instance().examenesPorIdPacienteREAD(idPaciente);
        } catch (Exception ex) {
            throw new NotFoundException(); 
        }
    }
    @GET
    @Path("{idExamen}.pdf")
    @Produces("documento/pdf")
    public Response getPdf(@PathParam("idExamen") String id) throws IOException {
        File file = new File(location+id);
        Response.ResponseBuilder response = Response.ok((Object) file);
        return response.build();
    }
//    @PUT
//    @Path("{idExamen}")
//    @Consumes(MediaType.APPLICATION_JSON)
//    public void update(@PathParam("idExamen") String id, Examen e) {  
//        try {
//            ServiceExamen.instance().examenUPDATE(e);
//        } catch (Exception ex) {
//            throw new NotFoundException(); 
//        }
//    }
}
