package Models;

import java.util.ArrayList;
import java.util.List;

public class Colonia {
    private int id_colonia;
    private String nombre;
    private int codigoPostal;
    private String tipoAsentamiento;

    public Colonia(int id_colonia, String nombre, int codigoPostal, String tipoAsentamiento) {
        this.id_colonia = id_colonia;
        this.nombre = nombre;
        this.codigoPostal = codigoPostal;
        this.tipoAsentamiento = tipoAsentamiento;
    }

    public Colonia(String nombre, int codigoPostal, String tipoAsentamiento) {
        this.nombre = nombre;
        this.codigoPostal = codigoPostal;
        this.tipoAsentamiento = tipoAsentamiento;
    }

    public Colonia() {
    }

    public int getId_colonia() {
        return id_colonia;
    }

    public void setId_colonia(int id_colonia) {
        this.id_colonia = id_colonia;
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

    @Override
    public String toString() {
        return "Colonia{" +
                "nombre='" + nombre + '\'' +
                ", codigoPostal=" + codigoPostal +
                ", tipoAsentamiento='" + tipoAsentamiento + '\'' +
                '}';
    }
}
