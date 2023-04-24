/**
 *
 * @author Natalia Arce 
 * @author Michelle Delgado
 * @author Beverly Ugalde
 * 
 */

package backend.resources;

import backend.logic.ServiceUsuario;
import backend.logic.Usuario;
import java.util.ArrayList;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/usuarios")
public class Usuarios 
{
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public ArrayList<Usuario> listarUsuarios()
    {
        try
        {
            return ServiceUsuario.instance().listarUsuarios();
        }
        catch (Exception ex)
        {
            throw new NotFoundException();
        }
    }
}
