package Models;

import java.util.ArrayList;
import java.util.List;

public class Cuadrilla {
    private int id_cuadrilla;
    private String nombre;
    private List<Empleado> empleados = new ArrayList<>();
    private List<ActividadLimpieza> actividades = new ArrayList<>();

    public Cuadrilla(String nombre) {
        this.nombre = nombre;
    }

    public Cuadrilla() {}

    public int getId_cuadrilla() {
        return id_cuadrilla;
    }

    public void setId_cuadrilla(int id_cuadrilla) {
        this.id_cuadrilla = id_cuadrilla;
    }

    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(List<Empleado> empleados) {
        this.empleados = empleados;
    }

    public List<ActividadLimpieza> getActividades() {
        return actividades;
    }

    public void setActividades(List<ActividadLimpieza> actividades) {
        this.actividades = actividades;
    }

    public void agregarEmpleado(Empleado empleado) {
        empleados.add(empleado);
    }

    public void eliminarEmpleado(Empleado empleado) {
        empleados.remove(empleado);
    }

    public List<ActividadLimpieza> obtenerActividades() {
        return actividades;
    }

    @Override
    public String toString() {
        return "Cuadrilla{" +
                "id='" + id_cuadrilla + '\'' +
                ", nombre='" + nombre + '\'' +
                ", empleados=" + empleados +
                '}';
    }
}
