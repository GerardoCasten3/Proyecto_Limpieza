package proyecto;

import java.util.ArrayList;
import java.util.List;

public class Colonia {
    private String nombre;
    private int codigoPostal;
    private String tipoAsentamiento;

    public Colonia(String nombre, int codigoPostal, String tipoAsentamiento) {
        this.nombre = nombre;
        this.codigoPostal = codigoPostal;
        this.tipoAsentamiento = tipoAsentamiento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(int codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getTipoAsentamiento() {
        return tipoAsentamiento;
    }

    public void setTipoAsentamiento(String tipoAsentamiento) {
        this.tipoAsentamiento = tipoAsentamiento;
    }

    public List<Colonia> buscarPorCodigoPostal(int codigoPostal) {
        List<Colonia> coloniasEncontradas = new ArrayList<>();
        if (this.codigoPostal == codigoPostal) {
            coloniasEncontradas.add(this);
        }
        return coloniasEncontradas;
    }

    @Override
    public String toString() {
        return "Colonia{" +
                "nombre='" + nombre + '\'' +
                ", codigoPostal=" + codigoPostal +
                ", tipoAsentamiento='" + tipoAsentamiento + '\'' +
                '}';
    }
}
