/**
 *
 * @author Natalia Arce 
 * @author Michelle Delgado
 * @author Beverly Ugalde
 * 
 */

package backend.logic;

import java.util.ArrayList;

public class Doctor {
    
    String idDoctor;
    String nombre;
    int costoConsulta;
    int frecuencia;
    String especialidad;
    String localidad;
    String presentacionDoctor;
    Usuario usuario;
    int estadoDoctor;
    ArrayList<Horario> horarios;
    ArrayList<Paciente> pacientes;

    public Doctor(String idDoctor, String nombre, int costoConsulta, 
            int frecuencia, String especialidad, String localidad, 
            String presentacionDoctor, Usuario usuario, int estadoDoctor, 
            ArrayList<Horario> horarios, ArrayList<Paciente> pacientes) {
        this.idDoctor = idDoctor;
        this.nombre = nombre;
        this.costoConsulta = costoConsulta;
        this.frecuencia = frecuencia;
        this.especialidad = especialidad;
        this.localidad = localidad;
        this.presentacionDoctor = presentacionDoctor;
        this.usuario = usuario;
        this.estadoDoctor = estadoDoctor;
        this.horarios = horarios;
        this.pacientes = pacientes;
    }
    public Doctor(String idDoctor, String nombre, int costoConsulta, 
            int frecuencia, String especialidad, String localidad, 
            String presentacionDoctor, Usuario usuario, int estadoDoctor) {
        this.idDoctor = idDoctor;
        this.nombre = nombre;
        this.costoConsulta = costoConsulta;
        this.frecuencia = frecuencia;
        this.especialidad = especialidad;
        this.localidad = localidad;
        this.presentacionDoctor = presentacionDoctor;
        this.usuario = usuario;
        this.estadoDoctor = estadoDoctor;
        this.horarios = new ArrayList();
        this.pacientes = new ArrayList();
    }

    public Doctor() {
    }

    public String getIdDoctor() {
        return idDoctor;
    }

    public void setIdDoctor(String idDoctor) {
        this.idDoctor = idDoctor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCostoConsulta() {
        return costoConsulta;
    }

    public void setCostoConsulta(int costoConsulta) {
        this.costoConsulta = costoConsulta;
    }

    public int getFrecuencia() {
        return frecuencia;
    }

    public void setFrecuencia(int frecuencia) {
        this.frecuencia = frecuencia;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getPresentacionDoctor() {
        return presentacionDoctor;
    }

    public void setPresentacionDoctor(String presentacionDoctor) {
        this.presentacionDoctor = presentacionDoctor;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public int getEstadoDoctor() {
        return estadoDoctor;
    }

    public void setEstadoDoctor(int estadoDoctor) {
        this.estadoDoctor = estadoDoctor;
    }

    public ArrayList<Horario> getHorarios() {
        return horarios;
    }

    public void setHorarios(ArrayList<Horario> horarios) {
        this.horarios = horarios;
    }

    public ArrayList<Paciente> getPacientes() {
        return pacientes;
    }

    public void setPacientes(ArrayList<Paciente> pacientes) {
        this.pacientes = pacientes;
    }
}
