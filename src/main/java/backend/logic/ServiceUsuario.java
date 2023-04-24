/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend.logic;

import backend.data.UsuarioDAO;
import java.util.ArrayList;

/**
 *
 * @author Michelle
 */
public class ServiceUsuario
{
    private static ServiceUsuario uniqueInstance;
    
    public static ServiceUsuario instance(){
        if (uniqueInstance == null){
            uniqueInstance = new ServiceUsuario();
        }
        return uniqueInstance;
    }   
    
    UsuarioDAO usuarioDAO;
    
    public ServiceUsuario()
    {
        try 
        {
            usuarioDAO = new UsuarioDAO();
        }
        catch (Exception e)
        {
        }
    }
    
    public Usuario readUsuarioPorId(String id) throws Exception
    {
        return usuarioDAO.readUsuarioPorId(id);
    }
    
    public Usuario login (Usuario usuario) throws Exception
    {
        return usuarioDAO.login(usuario);
    }
    
    public ArrayList<Usuario> listarUsuarios() throws Exception
    {
        return usuarioDAO.listarUsuarios();
    }
}
