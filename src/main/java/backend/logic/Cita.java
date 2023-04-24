/**
 *
 * @author Natalia Arce 
 * @author Michelle Delgado
 * @author Beverly Ugalde
 * 
 */

package backend.logic;

import java.time.LocalDateTime;

public class Cita {
    int idCita;
    String motivo;
    int estado;
    LocalDateTime fechaConsulta;
    String idPaciente;
    String idDoctor;
    int idResultado;

    public Cita(int idCita, String motivo, int estado, LocalDateTime fechaConsulta, String idPaciente, String idDoctor, int idResultado) {
        this.idCita = idCita;
        this.motivo = motivo;
        this.estado = estado;
        this.fechaConsulta = fechaConsulta;
        this.idPaciente = idPaciente;
        this.idDoctor = idDoctor;
        this.idResultado = idResultado;
    }

    public Cita() {
    }

    public int getIdCita() {
        return idCita;
    }

    public void setIdCita(int idCita) {
        this.idCita = idCita;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public LocalDateTime getFechaConsulta() {
        return fechaConsulta;
    }

    public void setFechaConsulta(LocalDateTime fechaConsulta) {
        this.fechaConsulta = fechaConsulta;
    }

    public String getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(String idPaciente) {
        this.idPaciente = idPaciente;
    }

    public String getIdDoctor() {
        return idDoctor;
    }

    public void setIdDoctor(String idDoctor) {
        this.idDoctor = idDoctor;
    }

    
    public int getIdResultado() {
        return idResultado;
    }

    public void setIdResultado(int idResultado) {
        this.idResultado = idResultado;
    }
    
    
}
