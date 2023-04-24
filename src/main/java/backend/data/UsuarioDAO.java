/**
 *
 * @author Natalia Arce 
 * @author Michelle Delgado
 * @author Beverly Ugalde
 * 
 */

package backend.data;
import backend.logic.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UsuarioDAO 
{
    Database db;
    
    public UsuarioDAO()
    {
        db = Database.instance();
    }
    
    public Usuario crearUsuario(ResultSet rs, String alias)
    {
        try 
        {
            Usuario u = new Usuario();
            u.setIdUsuario(rs.getString(alias+".idUsuario"));
            u.setContrasena(rs.getString(alias+".contrasena"));
            u.setTipo(rs.getString(alias+".tipo"));
            return u;
        }
        catch (SQLException ex)
        {
            return null;
        }
    }
    
    public Usuario login(Usuario usuario) throws Exception 
    {
        String sql = "select * from u where idUsuario = ? and contrasena = ?";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setString(1, usuario.getIdUsuario());
        stm.setString(2, usuario.getContrasena()); 
        ResultSet rs = db.executeQuery(stm);
        if (rs.next())
        {
            Usuario u = crearUsuario(rs, "u");
            return u;
        }
        else
        {
            throw new Exception ("404-doctor no existe");
        }
    }  
    
    public Usuario readUsuario(Usuario usuario) throws Exception
    {
        String sql = "select * from usuario u where idUsuario=?";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setString(1, usuario.getIdUsuario());
        ResultSet rs =  db.executeQuery(stm);
        if (rs.next())
        {
            Usuario u = crearUsuario(rs, "u"); 
            return u;
        }
        else{
            throw new Exception ("Usuario no existe");
        }
    }
    
    public Usuario readUsuarioPorId(String idUsuario) throws Exception
    {
        String sql = "select * from usuario u where idUsuario=?";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setString(1, idUsuario);
        ResultSet rs =  db.executeQuery(stm);
        if (rs.next())
        {
            Usuario u = crearUsuario(rs, "u"); 
            return u;
        }
        else{
            throw new Exception ("Usuario no existe");
        }
    }
    
    public void insertarUsuario(Usuario u) throws Exception
    {
        String sql = "insert into usuario (idUsuario, contrasena, tipo) " + 
                "values (?,?,?)";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setString(1, u.getIdUsuario());
        stm.setString(2, u.getContrasena());
        stm.setString(3, u.getTipo());
        int count = db.executeUpdate(stm);
        if (count == 0)
        {
            throw new Exception("Usuario no se inserto o ya existe");
        }  
    }
    
    public ArrayList<Usuario> listarUsuarios() throws Exception
    {
        String sql = "select * from usuario u";
        PreparedStatement stm = db.prepareStatement(sql);
        ArrayList<Usuario> usuarios = new ArrayList<>();
        ResultSet rs = db.executeQuery(stm);
        while(rs.next())
        {
            Usuario u = crearUsuario(rs,"u");
            if (u != null)
            {
                usuarios.add(u);
            }
        }
        if (usuarios.isEmpty())
        {
            System.out.print("No existe ningun usuario");
        }
        return usuarios;
    }
}
