package backend.logic;

import backend.data.EnfermedadDAO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Natalia Arce 
 * @author Michelle Delgado
 * @author Beverly Ugalde
 * 
 */
public class ServiceEnfermedades {
    private static ServiceEnfermedades uniqueInstance;
    public static ServiceEnfermedades instance(){
        if (uniqueInstance == null){
            uniqueInstance = new ServiceEnfermedades();
        }
        return uniqueInstance;
    }
    EnfermedadDAO enfermedadDAO;
    
    private ServiceEnfermedades(){
        enfermedadDAO = new EnfermedadDAO();
    }
    
    public void enfermedadCREATE(Enfermedad enf)throws Exception {
        enfermedadDAO.insertarEnfermedad(enf);
    }
    public List<Enfermedad> enfermedadesREAD()throws Exception{
        return new ArrayList(enfermedadDAO.readEnfermedades());
    }
    public Enfermedad enfermedadREAD(String id)throws Exception {
        return enfermedadDAO.readEnfermedadPorId(id);
    } 
}
