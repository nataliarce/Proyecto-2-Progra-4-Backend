package backend.data;

import backend.logic.Enfermedad;
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
public class EnfermedadDAO {
    Database db;
    
    public EnfermedadDAO() {
        db = Database.instance();
    }
    public Enfermedad crearEnfermedad(ResultSet rs, String alias) throws Exception
    {
        try
        {
            Enfermedad e = new Enfermedad();
            e.setIdEnfermedad(rs.getInt(alias+".idEnfermedades"));
            e.setCardiovascular(rs.getInt(alias+".cardiovascular"));
            e.setCancer(rs.getInt(alias+".cancer"));
            e.setDiabetes(rs.getInt(alias+".diabetes"));
            e.setAsma(rs.getInt(alias+".asma"));
          
            return e;
        }
        catch (SQLException ex)
        {
            return null;
        }
    }
    
    public ArrayList<Enfermedad> readEnfermedades() throws Exception 
    {
        String sql = "select * from enfermedades u";
        PreparedStatement stm = db.prepareStatement(sql);
        ArrayList<Enfermedad> enfermedades = new ArrayList<>();
        ResultSet rs = db.executeQuery(stm);
        while(rs.next())
        {
            Enfermedad u = crearEnfermedad(rs,"u");
            if (u != null)
            {
                enfermedades.add(u);
            }
        }
        if (enfermedades.isEmpty())
        {
            System.out.print("No existe ninguna enfermedad");
        }
        return enfermedades;       
    }
    
    public Enfermedad readEnfermedadPorId(String id) throws Exception 
    {
        String sql = "select * from enfermedades e where idEnfermedades=?";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setString(1, id);
        ResultSet rs =  db.executeQuery(stm);
        if (rs.next())
        {
            Enfermedad e = crearEnfermedad(rs, "e"); 
            return e;
        }
        else{
            
            return null;
        }        
    }
    public void insertarEnfermedad(Enfermedad e) throws Exception
    {
        String sql = 
                "insert into enfermedades(idEnfermedades,cardiovascular, cancer, diabetes, asma) " + 
                "values (?,?,?,?,?)";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setInt(1, e.getIdEnfermedad());
        stm.setInt(2, e.getCardiovascular());
        stm.setInt(3, e.getCancer());
        stm.setInt(4, e.getDiabetes());
        stm.setInt(5, e.getAsma());
        int count = db.executeUpdate(stm);
        if (count == 0)
        {
            throw new Exception("Enfermedad no se pudo insertar");
        }   
    }
}
