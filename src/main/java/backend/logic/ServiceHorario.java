/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend.logic;

import backend.data.HorarioDAO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author natal
 */
public class ServiceHorario {
    
    private static ServiceHorario uniqueInstance;
    
    public static ServiceHorario instance(){
        if (uniqueInstance == null){
            uniqueInstance = new ServiceHorario();
        }
        return uniqueInstance;
    }
    
    HorarioDAO horarioDAO;
    
    public ServiceHorario()
    {
        try 
        {
            horarioDAO = new HorarioDAO();
        }
        catch (Exception e)
        {
        }
    }
    
    public void insertarHorario(Horario horario, String idDoctor) throws Exception
    {
        horarioDAO.insertarHorario(horario, idDoctor);
    }
    
    public ArrayList<Horario> recuperarListaDeHorariosDelDoctor(String id) throws Exception
    {
        return horarioDAO.recuperarListaDeHorariosDelDoctor(id);
    }
}
