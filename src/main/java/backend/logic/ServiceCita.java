/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend.logic;

import backend.data.CitaDAO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author natal
 */
public class ServiceCita {
    
    private static ServiceCita uniqueInstance;
    
    public static ServiceCita instance(){
        if (uniqueInstance == null){
            uniqueInstance = new ServiceCita();
        }
        return uniqueInstance;
    }
    
    
    CitaDAO citaDAO;
    
    public ServiceCita()
    {
        try 
        {
            citaDAO = new CitaDAO();
        }
        catch (Exception e)
        {
        }
    }
    
   public void insertarCita(Cita c) throws Exception
    {
        citaDAO.insertarCita(c);
    }
    
    public List<Cita> citasREAD()throws Exception{
        return new ArrayList(citaDAO.readCitas());
    }
    
    public List<Cita> citasPorIdPacienteREAD(String id)throws Exception {
        return citaDAO.readCitasPorIdPaciente(id);
    }
    public Cita citaPorIdREAD(int id)throws Exception {
        return citaDAO.readCitaPorId(id);
    }
    
    public void citaUPDATE(int id)throws Exception {
        citaDAO.updateEstadoCita(id);
    }
    
    public List<Cita> readCitasDeLaSemana(String id) throws Exception 
    {
        return citaDAO.readCitasDeLaSemana(id);
    }
    
    public void eliminarCita(String idCita) throws Exception 
    {
        citaDAO.eliminarCita(idCita);
    }
}
