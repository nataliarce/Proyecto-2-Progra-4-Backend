/**
 *
 * @author Natalia Arce 
 * @author Michelle Delgado
 * @author Beverly Ugalde
 * 
 */
package backend.data;

import backend.logic.Paciente;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PacienteDAO {
    Database db;

    public PacienteDAO() {
        db = Database.instance();
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
    
    public List<Paciente> readPacientes() throws Exception 
    {
        String sql = "select * from paciente p ";
        PreparedStatement stm = db.prepareStatement(sql);
        ResultSet rs =  db.executeQuery(stm);
        List<Paciente> pacientes = new ArrayList();
        while (rs.next())
        {          
            pacientes.add(crearPaciente(rs, "p")) ; 
 
        }
        return pacientes;        
    }
    
    
    public Paciente readPacientePorId(String id) throws Exception 
    {
        String sql = "select * from paciente p where idPaciente=?";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setString(1, id);
        ResultSet rs =  db.executeQuery(stm);
        if (rs.next())
        {
            Paciente p = crearPaciente(rs, "p"); 
            return p;
        }
        else{
            
            return null;
        }        
    }
       
    public void insertarPaciente(Paciente p) throws Exception
    {
        String sql = 
                "insert into paciente (idPaciente, nombrePaciente, edadPaciente, "
                + "celularPaciente, emailPaciente, idDoctor,contactoEmergenciaPaciente) " + 
                "values (?,?,?,?,?,?,?)";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setInt(1, p.getIdPaciente());
        stm.setString(2, p.getNombrePaciente());
        stm.setInt(3, p.getEdadPaciente());
        stm.setInt(4, p.getCelularPaciente());
        stm.setString(5, p.getEmailPaciente());
        stm.setInt(6, p.getIdDoctor());
        stm.setInt(7, p.getContactoEmergenciaPaciente());
        int count = db.executeUpdate(stm);
        if (count == 0)
        {
            throw new Exception("Paciente no se pudo insertar");
        }   
    }
    
}
