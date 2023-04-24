/**
 *
 * @author Natalia Arce 
 * @author Michelle Delgado
 * @author Beverly Ugalde
 * 
 */
package backend.logic;

import backend.data.PacienteDAO;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ServicePaciente {
    private static ServicePaciente uniqueInstance;
    
    public static ServicePaciente instance(){
        if (uniqueInstance == null){
            uniqueInstance = new ServicePaciente();
        }
        return uniqueInstance;
    }
    
    //HashMap<String,Paciente> pacientes;
    PacienteDAO pacienteDAO;
    
    private ServicePaciente(){
        //pacientes = new HashMap<> ();
        pacienteDAO = new PacienteDAO();
    }
    
    public void pacientesCREATE(Paciente pac)throws Exception {
        pacienteDAO.insertarPaciente(pac);
    }
    public List<Paciente> pacientesREAD()throws Exception{
        return new ArrayList(pacienteDAO.readPacientes());
    }
    public Paciente pacientesREAD(String id)throws Exception {
        return pacienteDAO.readPacientePorId(id);
    } 
//
//    public void pacientesUPDATE(Paciente pac)throws Exception {
//        if (pacientes.get(String.valueOf(pac.getIdPaciente()))==null){
//            throw new Exception ("404-paciente no existe");
//        }
//        else{
//            pacientes.put(String.valueOf(pac.getIdPaciente()), pac);
//        }
//    }
//    
//    public void pacientesDELETE(String cedula)throws Exception {
//        if (pacientes.get(cedula)==null){
//            throw new Exception ("404-paciente no existe");
//        }
//        else{
//            pacientes.remove(cedula);
//        }
//    }
}
