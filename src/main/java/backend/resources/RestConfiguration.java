/**
 *
 * @author Natalia Arce 
 * @author Michelle Delgado
 * @author Beverly Ugalde
 * 
 */
package backend.resources;

import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import org.glassfish.jersey.media.multipart.MultiPartFeature;

@ApplicationPath("api")
public class RestConfiguration extends Application {
    @Override
    public Set<Class<?>> getClasses() {
        HashSet<Class<?>> classes = new HashSet<>();
        classes.add(MultiPartFeature.class);
        classes.add(Doctores.class);
        classes.add(Usuarios.class);
        classes.add(Pacientes.class);
        classes.add(Antecedentes.class);
        classes.add(Enfermedades.class);
        classes.add(Citas.class);
        classes.add(Examenes.class);
        classes.add(Agenda.class);
        
        return classes;
    }     
}
