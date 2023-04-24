package backend.logic;

/**
 *
 * @author Natalia Arce 
 * @author Michelle Delgado
 * @author Beverly Ugalde
 * 
 */
public class Enfermedad {
    int idEnfermedades;
    int cardiovascular;
    int cancer;
    int diabetes;
    int asma;

    public Enfermedad(int idEnfermedad, int cardiovascular, int cancer, int diabetes, int asma) {
        this.idEnfermedades = idEnfermedad;
        this.cardiovascular = cardiovascular;
        this.cancer = cancer;
        this.diabetes = diabetes;
        this.asma = asma;
    }

    public Enfermedad() {
    }

    public int getIdEnfermedad() {
        return idEnfermedades;
    }

    public void setIdEnfermedad(int idEnfermedad) {
        this.idEnfermedades = idEnfermedad;
    }

    public int getCardiovascular() {
        return cardiovascular;
    }

    public void setCardiovascular(int cardiovascular) {
        this.cardiovascular = cardiovascular;
    }

    public int getCancer() {
        return cancer;
    }

    public void setCancer(int cancer) {
        this.cancer = cancer;
    }

    public int getDiabetes() {
        return diabetes;
    }

    public void setDiabetes(int diabetes) {
        this.diabetes = diabetes;
    }

    public int getAsma() {
        return asma;
    }

    public void setAsma(int asma) {
        this.asma = asma;
    }
    
    
}

