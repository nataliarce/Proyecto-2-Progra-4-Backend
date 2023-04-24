/**
 *
 * @author Natalia Arce 
 * @author Michelle Delgado
 * @author Beverly Ugalde
 * 
 */

package backend.logic;

public class Paciente 
{
    int idPaciente;
    String nombrePaciente;
    int edadPaciente;
    int celularPaciente;
    String emailPaciente;
    int idDoctor;
    int contactoEmergenciaPaciente;

    public Paciente(int idPaciente, String nombrePaciente, int edadPaciente, int celularPaciente, String emailPaciente, int idDoctor, int contactoEmergenciaPaciente) {
        this.idPaciente = idPaciente;
        this.nombrePaciente = nombrePaciente;
        this.edadPaciente = edadPaciente;
        this.celularPaciente = celularPaciente;
        this.emailPaciente = emailPaciente;
        this.idDoctor = idDoctor;
        this.contactoEmergenciaPaciente = contactoEmergenciaPaciente;
    }
   

    public Paciente() 
    {
        this.idPaciente = 0;
        this.nombrePaciente = "";
        this.edadPaciente = 0;
        this.celularPaciente = 0;
        this.emailPaciente = "";
        this.idDoctor = 0;
        this.contactoEmergenciaPaciente = 0;
    }

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    public String getNombrePaciente() {
        return nombrePaciente;
    }

    public void setNombrePaciente(String nombrePaciente) {
        this.nombrePaciente = nombrePaciente;
    }

    public int getEdadPaciente() {
        return edadPaciente;
    }

    public void setEdadPaciente(int edadPaciente) {
        this.edadPaciente = edadPaciente;
    }

    public int getCelularPaciente() {
        return celularPaciente;
    }

    public void setCelularPaciente(int celularPaciente) {
        this.celularPaciente = celularPaciente;
    }

    public String getEmailPaciente() {
        return emailPaciente;
    }

    public void setEmailPaciente(String emailPaciente) {
        this.emailPaciente = emailPaciente;
    }

    public int getContactoEmergenciaPaciente() {
        return contactoEmergenciaPaciente;
    }

    public int getIdDoctor() {
        return idDoctor;
    }

    public void setIdDoctor(int idDoctor) {
        this.idDoctor = idDoctor;
    }

    public void setContactoEmergenciaPaciente(int contactoEmergenciaPaciente) {
        this.contactoEmergenciaPaciente = contactoEmergenciaPaciente;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Paciente other = (Paciente) obj;
        return this.idPaciente == other.idPaciente;
    }
}
