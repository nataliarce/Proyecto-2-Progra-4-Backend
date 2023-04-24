package backend.logic;

import java.util.Date;

/**
 *
 * @author Natalia Arce 
 * @author Michelle Delgado
 * @author Beverly Ugalde
 * 
 */
public class Examen {
    int idExamen;
    String descripcion;
    String Fecha;
    String idPaciente;
    int idCita;

    public Examen(int idExamen, String descripcion, String Fecha, String idPaciente, int idCita) {
        this.idExamen = idExamen;
        this.descripcion = descripcion;
        this.Fecha = Fecha;
        this.idPaciente = idPaciente;
        this.idCita = idCita;
    }

    public Examen() {
        this.idExamen = 0;
        this.descripcion = "";
        this.Fecha = "";
        this.idPaciente = "";
        this.idCita=0;
    }

    public int getIdExamen() {
        return idExamen;
    }

    public void setIdExamen(int idExamen) {
        this.idExamen = idExamen;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }

    public String getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(String idPaciente) {
        this.idPaciente = idPaciente;
    }

    public int getIdCita() {
        return idCita;
    }

    public void setIdCita(int idCita) {
        this.idCita = idCita;
    }   
    
}
