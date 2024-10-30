package proyecto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ActividadLimpieza {
    private String descripcion;
    private Date fecha;
    private List<Observer> observadores = new ArrayList<>();
    private String retroalimentacion;
    private String imagenEvidencia;
    private Cuadrilla cuadrilla;

    public ActividadLimpieza(String descripcion, Date fecha, String retroalimentacion, String imagenEvidencia, Cuadrilla cuadrilla) {
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.observadores = new ArrayList<>();
        this.retroalimentacion = retroalimentacion;
        this.imagenEvidencia = imagenEvidencia;
        this.cuadrilla = cuadrilla;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getRetroalimentacion() {
        return retroalimentacion;
    }

    public void setRetroalimentacion(String retroalimentacion) {
        this.retroalimentacion = retroalimentacion;
    }

    public String getImagenEvidencia() {
        return imagenEvidencia;
    }

    public void setImagenEvidencia(String imagenEvidencia) {
        this.imagenEvidencia = imagenEvidencia;
    }

    public Cuadrilla getCuadrilla() {
        return cuadrilla;
    }

    public void setCuadrilla(Cuadrilla cuadrilla) {
        this.cuadrilla = cuadrilla;
    }

    public void agregarObserver(Observer observer) {
        observadores.add(observer);
    }

    public void eliminarObserver(Observer observer) {
        observadores.remove(observer);
    }

    public void notificarObserver(String mensaje) {
        for (Observer observer : observadores) {
            observer.actualizar(mensaje);
        }
    }

    @Override
    public String toString() {
        return "ActividadLimpieza{" +
                "descripcion='" + descripcion + '\'' +
                ", fecha=" + fecha +
                ", retroalimentacion='" + retroalimentacion + '\'' +
                ", imagenEvidencia='" + imagenEvidencia + '\'' +
                ", cuadrilla=" + (cuadrilla != null ? cuadrilla.getNombre() : "Sin cuadrilla") +
                '}';
    }
}
