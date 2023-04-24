package backend.data;

import backend.logic.Antecedente;
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
public class AntecedenteDAO {
    Database db;
    public AntecedenteDAO() {
        db = Database.instance();
    }
    public Antecedente crearAntecedente(ResultSet rs, String alias) throws Exception
    {
        try
        {
            Antecedente a = new Antecedente();
            a.setIdEnfermedades(rs.getInt(alias+".idEnfermedades"));
            a.setIdPaciente(rs.getString(alias+".idPaciente"));
            a.setAlergias(rs.getInt(alias+".alergias"));
            a.setCirugias(rs.getInt(alias+".cirugias"));
          
            return a;
        }
        catch (SQLException ex)
        {
            return null;
        }
    }
    
    public List<Antecedente> readAntecedentes() throws Exception 
    {
        String sql = "select * from antecedentes a ";
        PreparedStatement stm = db.prepareStatement(sql);
        ResultSet rs =  db.executeQuery(stm);
        List<Antecedente> antecedentes = new ArrayList();
        while (rs.next())
        {          
            antecedentes.add(crearAntecedente(rs, "a")) ; 
 
        }
        return antecedentes;        
    }
    
    public void insertarAntecedente(Antecedente a) throws Exception
    {
        String sql = 
                "insert into antecedentes (idEnfermedades, idPaciente, alergias, cirugias) " + 
                "values (?,?,?,?)";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setInt(1, a.getIdEnfermedades());
        stm.setString(2, a.getIdPaciente());
        stm.setInt(3, a.getAlergias());
        stm.setInt(4, a.getCirugias());
        int count = db.executeUpdate(stm);
        if (count == 0)
        {
            throw new Exception("Antecedente no se pudo insertar");
        }   
    }
}
