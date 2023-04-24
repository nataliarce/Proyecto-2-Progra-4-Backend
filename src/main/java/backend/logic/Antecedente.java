/**
 *
 * @author Natalia Arce 
 * @author Michelle Delgado
 * @author Beverly Ugalde
 * 
 */

package backend.logic;

public class Antecedente {
    int idEnfermedades;
    String idPaciente;
    int alergias;
    int cirugias;

    public Antecedente(int idEnfermedades, String idPaciente, int alergias, int cirugias) {
        this.idEnfermedades = idEnfermedades;
        this.idPaciente = idPaciente;
        this.alergias = alergias;
        this.cirugias = cirugias;
    }

    

    public Antecedente() {
        this.idPaciente = "";
    }

    public int getIdEnfermedades() {
        return idEnfermedades;
    }

    public void setIdEnfermedades(int idEnfermedades) {
        this.idEnfermedades = idEnfermedades;
    }
   
    public String getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(String idPaciente) {
        this.idPaciente = idPaciente;
    }

    public int getAlergias() {
        return alergias;
    }

    public void setAlergias(int alergias) {
        this.alergias = alergias;
    }

    public int getCirugias() {
        return cirugias;
    }

    public void setCirugias(int cirugias) {
        this.cirugias = cirugias;
    }
    
}
