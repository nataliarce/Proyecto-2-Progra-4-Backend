/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend.logic;

import backend.data.ExamenDAO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Natalia Arce 
 * @author Michelle Delgado
 * @author Beverly Ugalde
 * 
 */
public class ServiceExamen {
    private static ServiceExamen uniqueInstance;
    
    public static ServiceExamen instance(){
        if (uniqueInstance == null){
            uniqueInstance = new ServiceExamen();
        }
        return uniqueInstance;
    }
    ExamenDAO examenDAO;
    private ServiceExamen(){
        //pacientes = new HashMap<> ();
        examenDAO = new ExamenDAO();
    }
    public void examenCREATE(Examen e)throws Exception {
        examenDAO.insertarExamen(e);
    }
    public List<Examen> examenesREAD()throws Exception{
        return new ArrayList(examenDAO.readExamenes());
    }
    public Examen examenREAD(int id)throws Exception {
        return examenDAO.readExamenPorId(id);
    } 
    public List<Examen> examenesPorIdPacienteREAD(String id)throws Exception {
        return examenDAO.readExamenesPorIdPaciente(id);
    }
}
