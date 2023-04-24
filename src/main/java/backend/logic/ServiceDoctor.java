/**
 *
 * @author Natalia Arce 
 * @author Michelle Delgado
 * @author Beverly Ugalde
 * 
 */

package backend.logic;

import backend.data.DoctorDAO;
import backend.data.HorarioDAO;
import backend.data.UsuarioDAO;
import java.util.ArrayList;
import java.util.List;

public class ServiceDoctor {
    private static ServiceDoctor uniqueInstance;
    
    public static ServiceDoctor instance(){
        if (uniqueInstance == null){
            uniqueInstance = new ServiceDoctor();
        }
        return uniqueInstance;
    }
    
    DoctorDAO doctorDAO;
    UsuarioDAO usuarioDAO;
    HorarioDAO horarioDAO;
    
    public ServiceDoctor()
    {
        try 
        {
            doctorDAO = new DoctorDAO();
            usuarioDAO = new UsuarioDAO();
            horarioDAO = new HorarioDAO();
        }
        catch (Exception e)
        {
        }
    }
      
    public void doctoresCREATE(Doctor doctor)throws Exception
    {
        usuarioDAO.insertarUsuario(doctor.getUsuario());
        doctorDAO.insertarDoctor(doctor);
        for(Horario h: doctor.getHorarios())
        {
            if(!h.getDesde().equals("0"))
            {
                horarioDAO.insertarHorario(h, doctor.getIdDoctor());
            }
        }
    }
    
    public List<Doctor> doctoresREAD() throws Exception {
        return new ArrayList(doctorDAO.readDoctores());
    } 
    
    public Doctor doctoresREAD(String id)throws Exception 
    {
        return doctorDAO.readDoctorPorId(id);
    }
    
    public int doctorReadEstado(String id) throws Exception
    {
        return doctorDAO.readDoctorEstado(id);
    }

    public void doctoresUPDATE(Doctor d)throws Exception
    {
        doctorDAO.doctoresUpdate(d);
    }
    
    public ArrayList<Doctor> doctoresREADSinAprob() throws Exception
    {
        return doctorDAO.listaDoctoresSinAprobar();
    }
    
    public ArrayList<Doctor> doctoresREADAprob() throws Exception
    {
        return doctorDAO.listaDoctoresAprobados();
    }
}
