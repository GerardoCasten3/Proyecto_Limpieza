package Models;

import java.util.ArrayList;
import java.util.List;

public class ActividadColonia {
    private ActividadLimpieza actividad;
    private List<Colonia> colonias = new ArrayList<>();

    public ActividadColonia(ActividadLimpieza actividad, List<Colonia> colonias) {
        this.actividad = actividad;
        this.colonias = colonias;
    }

    public ActividadLimpieza getActividad() {
        return actividad;
    }

    public void setActividad(ActividadLimpieza actividad) {
        this.actividad = actividad;
    }

    public List<Colonia> getColonias() {
        return colonias;
    }

    public void setColonias(List<Colonia> colonias) {
        this.colonias = colonias;
    }

    public void agregarColonia(Colonia colonia) {
        colonias.add(colonia);
    }

    public void eliminarColonia(Colonia colonia) {
        colonias.remove(colonia);
    }

    @Override
    public String toString() {
        return "ActividadColonia{" +
                "actividad=" + actividad +
                ", colonias=" + colonias +
                '}';
    }
}

