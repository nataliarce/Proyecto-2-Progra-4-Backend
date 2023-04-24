/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend.data;

import backend.logic.Cita;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author natal
 */
public class CitaDAO {
    
    Database db;
    
    public CitaDAO()
    {
        db = Database.instance();
    }
    
    public void insertarCita(Cita c) throws Exception
    {
        String sql = 
                "insert into cita (motivoCita, estadoCita, fechaConsulta, "
                + "idPaciente, idDoctor) values " + 
                "(?,?,?,?,?)";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setString(1, c.getMotivo());
        stm.setInt(2, c.getEstado());
        stm.setObject(3, c.getFechaConsulta());
        stm.setString(4, c.getIdPaciente());
        stm.setString(5, c.getIdDoctor());
        int count = db.executeUpdate(stm);
        if (count == 0)
        {
            throw new Exception("Cita no se pudo insertar");
        }   
    }
    
    public Cita crearCita(ResultSet rs, String alias) throws Exception
    {

        try
        {
            Cita c = new Cita();
            c.setIdCita(rs.getInt(alias+".idCita"));
            c.setMotivo(rs.getString(alias+".motivoCita"));
            c.setEstado(rs.getInt(alias+".estadoCita"));
            c.setFechaConsulta((LocalDateTime)rs.getObject(alias+".fechaConsulta"));
            c.setIdPaciente(rs.getString(alias+".idPaciente"));
            c.setIdDoctor(rs.getString(alias+".idDoctor"));
            //c.setIdResultado(rs.getInt(alias+".idResulado"));
            return c;
        }
        catch (SQLException ex)
        {
            return null;
        }
    }
    public List<Cita> readCitas() throws Exception 
    {
        String sql = "select * from cita c ";
        PreparedStatement stm = db.prepareStatement(sql);
        ResultSet rs =  db.executeQuery(stm);
        List<Cita> citas = new ArrayList();
        while (rs.next())
        {          
            citas.add(crearCita(rs, "c")) ; 
 
        }
        return citas;        
    }
    public List<Cita> readCitasPorIdPaciente(String id) throws Exception 
    {
        String sql = "select * from cita c where idPaciente=? ";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setString(1, id);
        ResultSet rs =  db.executeQuery(stm);
        List<Cita> citas = new ArrayList();
        while (rs.next())
        {          
            citas.add(crearCita(rs, "c")) ; 
        }
        return citas;        
    }
    
    public List<Cita> readCitasDeLaSemana(String id) throws Exception 
    {
        String sql = "select * from cita c where idDoctor=?";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setString(1, id);
        ResultSet rs =  db.executeQuery(stm);
        List<Cita> citas = new ArrayList();
        while (rs.next())
        {          
            citas.add(crearCita(rs, "c")) ; 
        }
        return citas;        
    }
    
    public void eliminarCita(String idCita) throws Exception 
    {
        String sql = "delete from cita where idCita=?";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setInt(1, Integer.parseInt(idCita));
        int count = db.executeUpdate(stm);
        if (count == 0)
        {
            throw new Exception("Cita no existe");
        }   
    }
    
    public Cita readCitaPorId(int id) throws Exception 
    {
        String sql = "select * from cita c where idCita=? ";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setInt(1, id);
        ResultSet rs =  db.executeQuery(stm);
        if (rs.next())
        {
            Cita c = crearCita(rs, "c"); 
            return c;
        }
        else{
            
            return null;
        }         
    }
    public void updateEstadoCita(int idCita) throws Exception
    {
        String sql = "update cita set estadoCita = ?, idResultado = ? where idCita= ?";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setInt(1, 1);
        stm.setInt(2, idCita);
        stm.setInt(3, idCita);
        int count = db.executeUpdate(stm);
        if (count == 0)
        {
            throw new Exception("Cita no registrada");
        }   
    }
}
