package proyecto;

import java.util.List;

public class Empleado {
    private String nombre;
    private String cargo;
    private boolean esJefeCuadrilla;
    private Cuadrilla cuadrilla;
    private Usuario usuario;

    public Empleado(String nombre, String cargo, boolean esJefeCuadrilla, Cuadrilla cuadrilla, Usuario usuario) {
        this.nombre = nombre;
        this.cargo = cargo;
        this.esJefeCuadrilla = esJefeCuadrilla;
        this.cuadrilla = cuadrilla;
        this.usuario = usuario;
    }

    public Empleado() {}

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public boolean isEsJefeCuadrilla() {
        return esJefeCuadrilla;
    }

    public void setEsJefeCuadrilla(boolean esJefeCuadrilla) {
        this.esJefeCuadrilla = esJefeCuadrilla;
    }

    public Cuadrilla getCuadrilla() {
        return cuadrilla;
    }

    public void setCuadrilla(Cuadrilla cuadrilla) {
        this.cuadrilla = cuadrilla;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "nombre='" + nombre + '\'' +
                ", cargo='" + cargo + '\'' +
                ", esJefeCuadrilla=" + esJefeCuadrilla +
                ", cuadrilla=" + (cuadrilla != null ? cuadrilla.getNombre() : "Sin cuadrilla") +
                ", usuario=" + usuario +
                '}';
    }
}
