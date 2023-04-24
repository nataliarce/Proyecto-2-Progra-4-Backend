/**
 *
 * @author Natalia Arce 
 * @author Michelle Delgado
 * @author Beverly Ugalde
 * 
 */
package backend.resources;

import backend.logic.Doctor;
import backend.logic.ServiceDoctor;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
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
import javax.ws.rs.core.Response;
import org.glassfish.jersey.media.multipart.FormDataParam;


@Path("/doctores")
public class Doctores {
    String location="C:/Users/Michelle/Documents/images/";
            
            
    @POST
    @Consumes(MediaType.APPLICATION_JSON) 
    public void create(Doctor doctor) 
    {  
        try {
            System.out.print("Hi");
            ServiceDoctor.instance().doctoresCREATE(doctor);
            //return;
        } catch (Exception ex) {
            throw new NotAcceptableException(); 
        }
    }
    
    @POST
    @Consumes (MediaType.MULTIPART_FORM_DATA)
    @Path("{idDoctor}/imagen")
    public void addImage(@PathParam("idDoctor") String idDoctor, @FormDataParam("imagen") InputStream in)
    {
        try{
                OutputStream out = new FileOutputStream(new File(location + idDoctor));
                in.transferTo(out);
                out.close();
            } catch (Exception ex) {
                throw new NotAcceptableException(); 
            }
    }
    
    @GET
    @Path("{idDoctor}/image")
    @Produces("image/png")
    public Response getImage(@PathParam("idDoctor") String cedula) throws IOException {
        File file = new File(location+cedula);
        Response.ResponseBuilder response = Response.ok((Object) file);
        return response.build();
    }   
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Doctor> read()throws Exception { 
        //return ServiceDoctor.instance().doctoresREAD();
        return new ArrayList();
    }     
    
    @GET
    @Path("{idDoctor}")
    @Produces({MediaType.APPLICATION_JSON})
    public Doctor read(@PathParam("idDoctor") String idDoctor) {
        try {
            return ServiceDoctor.instance().doctoresREAD(idDoctor);
        } catch (Exception ex) {
            throw new NotFoundException(); 
        }
    }
    
    @GET
    @Path("{idDoctor}/estado")
    @Produces({MediaType.APPLICATION_JSON})
    public int readEstado(@PathParam("idDoctor") String idDoctor) {
        try {
            return ServiceDoctor.instance().doctorReadEstado(idDoctor);
        } catch (Exception ex) {
            throw new NotFoundException(); 
        }
    }
    @GET
    @Path("/sinAprobar")
    @Produces({MediaType.APPLICATION_JSON})
    public ArrayList<Doctor> readSinAprobar() {
        try {
            return ServiceDoctor.instance().doctoresREADSinAprob();
        } catch (Exception ex) {
            throw new NotFoundException(); 
        }
    }
    
    @GET
    @Path("/aprobados")
    @Produces({MediaType.APPLICATION_JSON})
    public ArrayList<Doctor> readAprobados() {
        try {
            return ServiceDoctor.instance().doctoresREADAprob();
        } catch (Exception ex) {
            throw new NotFoundException(); 
        }
    }
    
    @PUT
    @Path("{idDoctor}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void update(@PathParam("idDoctor") String idDoctor, Doctor d) {  
        try {
            ServiceDoctor.instance().doctoresUPDATE(d);
        } catch (Exception ex) {
            throw new NotFoundException(); 
        }
    }
}
