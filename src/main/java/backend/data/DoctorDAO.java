/**
 *
 * @author Natalia Arce 
 * @author Michelle Delgado
 * @author Beverly Ugalde
 * 
 */


package backend.data;


import backend.logic.Doctor;
import backend.logic.Horario;
import backend.logic.Paciente;
import backend.logic.ServiceHorario;
import backend.logic.ServicePaciente;
import backend.logic.ServiceUsuario;
import backend.logic.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DoctorDAO 
{
    Database db;
    
    public DoctorDAO()
    {
        db = Database.instance();
    }
    

    public Doctor crearDoctor(ResultSet rs, String alias) throws Exception
    {

        try
        {
            Doctor d = new Doctor();
            d.setIdDoctor(rs.getString(alias+".idDoctor"));
            d.setNombre(rs.getString(alias+".nombreDoctor"));
            d.setCostoConsulta(Integer.valueOf(rs.getString(alias+".costoConsulta")));
            d.setFrecuencia(Integer.valueOf(rs.getString(alias+".frecuencia")));
            d.setEspecialidad(rs.getString(alias+".especialidad"));
            d.setLocalidad(rs.getString(alias+".localidad"));
            d.setPresentacionDoctor(rs.getString(alias+".presentacionDoctor"));
            d.setEstadoDoctor(Integer.valueOf(rs.getString(alias+".estadoDoctor")));
            Usuario u = 
                    ServiceUsuario.instance().readUsuarioPorId(rs.getString(alias+".idUsuario"));
            d.setUsuario(u);
            ArrayList<Horario> horarios = 
                    ServiceHorario.instance().recuperarListaDeHorariosDelDoctor(d.getIdDoctor());
            d.setHorarios(horarios);
            ArrayList<Paciente> pacientes = 
                    this.recuperarListaDePacientesDelDoctor(d.getIdDoctor());
            d.setPacientes(pacientes);
            return d;
        }
        catch (SQLException ex)
        {
            return null;
        }
    }
       public List<Doctor> readDoctores() throws Exception 
    {
        String sql = "select * from doctor d ";
        PreparedStatement stm = db.prepareStatement(sql);
        ResultSet rs =  db.executeQuery(stm);
        List<Doctor> doctores = new ArrayList();
        while (rs.next())
        {          
            doctores.add(crearDoctor(rs, "d")) ; 
 
        }
        return doctores;        
    }
    
    
    public Doctor readDoctorPorId(String id) throws Exception 
    {
        String sql = "select * from doctor d where idDoctor=?";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setString(1, id);
        ResultSet rs =  db.executeQuery(stm);
        if (rs.next())
        {
            Doctor d = crearDoctor(rs, "d"); 
            return d;
        }
        else{
            
            return null;
        }        
    }
    
    public Doctor crearDoctorEstado(ResultSet rs, String alias) throws Exception
    {

        try
        {
            Doctor d = new Doctor();
            d.setEstadoDoctor(Integer.valueOf(rs.getString(alias+".estadoDoctor")));
            return d;
        }
        catch (SQLException ex)
        {
            return null;
        }
    }
    
    public int readDoctorEstado(String id) throws Exception 
    {
        String sql = "select estadoDoctor from doctor d where idDoctor=?";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setString(1, id);
        ResultSet rs =  db.executeQuery(stm);
        if (rs.next())
        {
            Doctor d = crearDoctorEstado(rs, "d"); 
            return d.getEstadoDoctor();
        }
        else{
            
            return -1;
        }     
        
    }
    public void insertarDoctor(Doctor d) throws Exception
    {
        String sql = 
                "insert into doctor (idDoctor, nombreDoctor, costoConsulta, "
                + "frecuencia, especialidad, localidad, presentacionDoctor, estadoDoctor, idUsuario) " + 
                "values (?,?,?,?,?,?,?,?,?)";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setString(1, d.getIdDoctor());
        stm.setString(2, d.getNombre());
        stm.setInt(3, d.getCostoConsulta());
        stm.setInt(4, d.getFrecuencia());
        stm.setString(5, d.getEspecialidad());
        stm.setString(6, d.getLocalidad());
        stm.setString(7, d.getPresentacionDoctor());
        stm.setInt(8, 0);
        stm.setString(9, d.getUsuario().getIdUsuario());
        int count = db.executeUpdate(stm);
        if (count == 0)
        {
            throw new Exception("Doctor no se pudo insertar");
        }   
   }
    
   public ArrayList<Paciente> recuperarListaDePacientesDelDoctor(String id) throws Exception
   {
       
       String sql = "select * from paciente p where idDoctor=?";
       PreparedStatement stm = db.prepareStatement(sql);
       stm.setString(1, id);
       ResultSet rs =  db.executeQuery(stm);
       ArrayList<Paciente> pacientes = new ArrayList();
       while (rs.next())
       {          
           pacientes.add(crearPaciente(rs, "p")) ; 
 
       }
       return pacientes;     
   }
   
   public Paciente crearPaciente(ResultSet rs, String alias) throws Exception
   {

        try
        {
            Paciente p = new Paciente();
            p.setIdPaciente(rs.getInt(alias+".idPaciente"));
            p.setNombrePaciente(rs.getString(alias+".nombrePaciente"));
            p.setEdadPaciente(rs.getInt(alias+".edadPaciente"));
            p.setCelularPaciente(rs.getInt(alias+".celularPaciente"));
            p.setEmailPaciente(rs.getString(alias+".emailPaciente"));
            p.setContactoEmergenciaPaciente(rs.getInt(alias+".contactoEmergenciaPaciente"));
          
            return p;
        }
        catch (SQLException ex)
        {
            return null;
        }
   }
   
   
   
    public Doctor crearDoctorAprobYNoAprob(ResultSet rs, String alias) throws Exception
    {

        try
        {
            Doctor d = new Doctor();
            d.setIdDoctor(rs.getString(alias+".idDoctor"));
            d.setNombre(rs.getString(alias+".nombreDoctor"));
            d.setEstadoDoctor(Integer.valueOf(rs.getString(alias+".estadoDoctor")));
            return d;
        }
        catch (SQLException ex)
        {
            return null;
        }
    }
    
    
   public ArrayList<Doctor> listaDoctoresSinAprobar() throws Exception         
   {
       String sql = "select idDoctor, nombreDoctor,estadoDoctor from doctor d where estadoDoctor=?";
       PreparedStatement stm = db.prepareStatement(sql);
       stm.setInt(1, 0);
       ResultSet rs =  db.executeQuery(stm);
       ArrayList<Doctor> doctores = new ArrayList();
       while (rs.next())
       {          
           doctores.add(crearDoctorAprobYNoAprob(rs, "d")) ; 
 
       }
       return doctores;   
   }
   
   public ArrayList<Doctor> listaDoctoresAprobados() throws Exception         
   {
       String sql = "select idDoctor, nombreDoctor,estadoDoctor from doctor d where estadoDoctor=?";
       PreparedStatement stm = db.prepareStatement(sql);
       stm.setInt(1, 1);
       ResultSet rs =  db.executeQuery(stm);
       ArrayList<Doctor> doctores = new ArrayList();
       while (rs.next())
       {          
           doctores.add(crearDoctorAprobYNoAprob(rs, "d")) ; 
 
       }
       return doctores;   
   }
    
   public void doctoresUpdate(Doctor doctor) throws Exception
   {
       String sql = "update doctor set estadoDoctor=? where idDoctor = ?";
       PreparedStatement stm = db.prepareStatement(sql);
       stm.setInt(1, doctor.getEstadoDoctor());
       stm.setString(2, doctor.getIdDoctor());
        int count = db.executeUpdate(stm);
        if (count == 0)
        {
            throw new Exception("No se pudo hacer update");
        }   
   }
}
