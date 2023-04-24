/**
 *
 * @author Natalia Arce 
 * @author Michelle Delgado
 * @author Beverly Ugalde
 * 
 */

package backend.logic;

import java.util.Objects;

public class Usuario
{
    String idUsuario;
    String contrasena;
    String tipo;

    public Usuario(String idUsuario, String contrasena, String tipo)
    {
        this.idUsuario = idUsuario;
        this.contrasena = contrasena;
        this.tipo = tipo;
    }

    public Usuario() 
    {
    }

    public String getIdUsuario()
    {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) 
    {
        this.idUsuario = idUsuario;
    }

    public String getContrasena()
    {
        return contrasena;
    }

    public void setContrasena(String contrasena)
    {
        this.contrasena = contrasena;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public int hashCode() 
    {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Usuario other = (Usuario) obj;
        return Objects.equals(this.idUsuario, other.idUsuario);
    }
    
    
}
