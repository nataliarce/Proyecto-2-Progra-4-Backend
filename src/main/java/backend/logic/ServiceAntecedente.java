package backend.logic;


import backend.data.AntecedenteDAO;
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
public class ServiceAntecedente {
    private static ServiceAntecedente uniqueInstance;
    public static ServiceAntecedente instance(){
        if (uniqueInstance == null){
            uniqueInstance = new ServiceAntecedente();
        }
        return uniqueInstance;
    }
    EnfermedadDAO enfermedadesDAO;
    AntecedenteDAO antecedenteDAO;
    
    private ServiceAntecedente(){
        enfermedadesDAO = new EnfermedadDAO();
        antecedenteDAO = new AntecedenteDAO();
    }
    
    public void antecedentesCREATE(Antecedente ant)throws Exception {
        antecedenteDAO.insertarAntecedente(ant);
    }
    public List<Antecedente> antecedentesREAD()throws Exception{
        return new ArrayList(antecedenteDAO.readAntecedentes());
    }
}
