package backend.data;

import backend.data.Database;
import backend.logic.Examen;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Natalia Arce 
 * @author Michelle Delgado
 * @author Beverly Ugalde
 * 
 */
public class ExamenDAO {
    Database db;

    public ExamenDAO() {
        db = Database.instance();
    }
    public Examen crearExamen (ResultSet rs, String alias) throws Exception
    {
        try
        {
            Examen e = new Examen();
            e.setIdExamen(rs.getInt(alias+".idExamen"));
            e.setDescripcion(rs.getString(alias+".descripcion"));
            e.setFecha(rs.getString(alias+".fecha"));
            e.setIdPaciente(rs.getString(alias+".idPaciente"));
            e.setIdCita(rs.getInt(alias+".idCita"));
          
            return e;
        }
        catch (SQLException ex)
        {
            return null;
        }
    }
    public List<Examen> readExamenes() throws Exception 
    {
        String sql = "select * from examenes e ";
        PreparedStatement stm = db.prepareStatement(sql);
        ResultSet rs =  db.executeQuery(stm);
        List<Examen> examenes = new ArrayList();
        while (rs.next())
        {          
            examenes.add(crearExamen(rs, "e")) ; 
 
        }
        return examenes;        
    }
    public Examen readExamenPorId(int id) throws Exception 
    {
        String sql = "select * from examenes e where idExamen=?";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setInt(1, id);
        ResultSet rs =  db.executeQuery(stm);
        if (rs.next())
        {
            Examen e = crearExamen(rs, "e"); 
            return e;
        }
        else{
            
            return null;
        }        
    }
    public List<Examen> readExamenesPorIdPaciente(String id) throws Exception 
    {
        String sql = "select * from examenes e where idPaciente=? ";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setString(1, id);
        ResultSet rs =  db.executeQuery(stm);
        List<Examen> examenes = new ArrayList();
        while (rs.next())
        {          
            examenes.add(crearExamen(rs, "e")) ; 
        }
        return examenes;        
    }
    public void insertarExamen(Examen e) throws Exception
    {
        String sql = 
                "insert into examenes (idExamen,descripcion,fecha,idPaciente,idCita) " + 
                "values (?,?,?,?,?)";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setInt(1, e.getIdExamen());
        stm.setString(2, e.getDescripcion());
        stm.setString(3, e.getFecha());
        stm.setString(4, e.getIdPaciente());
        stm.setInt(5, e.getIdCita());
        int count = db.executeUpdate(stm);
        if (count == 0)
        {
            throw new Exception("Examen no se pudo insertar");
        }   
    }
}