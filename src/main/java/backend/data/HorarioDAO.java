/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend.data;

import backend.logic.Horario;
import backend.logic.Paciente;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author natal
 */
public class HorarioDAO {
    
    Database db;

    public HorarioDAO() 
    {
        db = Database.instance();
    }
    
    public void insertarHorario(Horario horario, String idDoctor) throws Exception
    {
        String sql = 
                "insert into horario (desde, hasta, "
                + "dia, seleccionado, idDoctor) "
                + "values (?,?,?,?,?)";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setString(1, horario.getDesde());
        stm.setString(2, horario.getHasta());
        stm.setString(3, horario.getDia());
        stm.setInt(4, horario.getSeleccionado());
        stm.setString(5, idDoctor);
        int count = db.executeUpdate(stm);
        if (count == 0)
        {
            throw new Exception("Horario no se pudo insertar");
        }   
    }
    
   public ArrayList<Horario> recuperarListaDeHorariosDelDoctor(String id) throws Exception
   {
       
       String sql = "select * from horario h where idDoctor=?";
       PreparedStatement stm = db.prepareStatement(sql);
       stm.setString(1, id);
       ResultSet rs =  db.executeQuery(stm);
       ArrayList<Horario> horarios = new ArrayList();
       while (rs.next())
       {          
           horarios.add(crearHorario(rs, "h")) ; 
 
       }
       return horarios;     
   }
   
   public Horario crearHorario(ResultSet rs, String alias) throws Exception
   {

        try
        {
            Horario h = new Horario();
            h.setIdHorario(rs.getInt(alias+".idHorario"));
            h.setDesde(rs.getString(alias+".desde"));
            h.setHasta(rs.getString(alias+".hasta"));
            h.setDia(rs.getString(alias+".dia"));
            h.setSeleccionado(rs.getInt(alias+".seleccionado"));
            return h;
        }
        catch (SQLException ex)
        {
            return null;
        }
   }
   
}
