/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend.logic;

import backend.data.ResultadosDAO;

/**
 *
 * @author Michelle
 */
public class ServiceResultado 
{
    private static ServiceResultado uniqueInstance;
    
    public static ServiceResultado instance(){
        if (uniqueInstance == null){
            uniqueInstance = new ServiceResultado();
        }
        return uniqueInstance;
    }
    
    ResultadosDAO resultadosDAO;

    public ServiceResultado()
    {
        try 
        {
            resultadosDAO = new ResultadosDAO();
        }
        catch (Exception e)
        {
        }
    }
    
    public void crearResultado(Resultado r, int idCita) throws Exception
    {
        resultadosDAO.insertarResultado(r,idCita);
    }
}
