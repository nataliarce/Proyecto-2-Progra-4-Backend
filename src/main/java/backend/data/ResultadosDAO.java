/**
 *
 * @author Natalia Arce 
 * @author Michelle Delgado
 * @author Beverly Ugalde
 * 
 */

package backend.data;

import backend.logic.Resultado;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ResultadosDAO 
{
    Database db;

    public ResultadosDAO() 
    {
        db = Database.instance();
    }
    
    public Resultado crearResultado(ResultSet rs, String alias) throws Exception
    {
        try
        {
            Resultado r = new Resultado();
            r.setIdResultado(Integer.valueOf(rs.getString(alias+".idResultado")));
            r.setSignos(rs.getString(alias+".signos"));
            r.setDiagnosticos(rs.getString(alias+".diagnosticos"));
            r.setPrescripciones(rs.getString(alias+".prescipciones"));
            
            return r;
        }
        catch (SQLException ex)
        {
            return null;
        }
    }
    
    public Resultado readResultadoPorId(int id) throws Exception
    {
        String sql = "select * from resultado r where idResultado=?";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setInt(1, id);
        ResultSet rs =  db.executeQuery(stm);
        if (rs.next())
        {
            Resultado r= crearResultado(rs, "r"); 
            return r;
        }
        else{
            
            return null;
        }      
    }
    
    public void insertarResultado (Resultado r, int idCita) throws Exception
    {
        String sql = "insert into resultado (idResultado, signos, diagnosticos, prescripciones) values (?,?,?,?)";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setInt(1, idCita);
        stm.setString(2, r.getSignos());
        stm.setString(3, r.getDiagnosticos());
        stm.setString(4, r.getPrescripciones());
        int count = db.executeUpdate(stm);
        if (count == 0)
        {
            throw new Exception("Resultado no se pudo insertar");
        }   
    }
    
}
