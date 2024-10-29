package proyecto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Crear instancias de Usuario
        Usuario usuario1 = new Usuario("admin", "password", Rol.Administrador);
        Usuario usuario2 = new Usuario("empleado1", "1234", Rol.Empleado);

        // Crear instancias de Empleado
        Empleado jefeCuadrilla = new Empleado("Juan", "Jefe de Cuadrilla", true, null, usuario1);
        Empleado empleado1 = new Empleado("Pedro", "Operario", false, null, usuario2);
        Empleado empleado2 = new Empleado("Maria", "Operaria", false, null, usuario2);

        // Crear instancia de Cuadrilla
        Cuadrilla cuadrilla = new Cuadrilla();
        cuadrilla.setNombre("Cuadrilla 1");
        cuadrilla.agregarEmpleado(jefeCuadrilla);
        cuadrilla.agregarEmpleado(empleado1);
        cuadrilla.agregarEmpleado(empleado2);

        // Crear instancia de ActividadLimpieza
        ActividadLimpieza actividad = new ActividadLimpieza("Limpieza de Parque", new Date(), "Bien", "imagen.jpg", cuadrilla);
        cuadrilla.getActividades().add(actividad);

        // Crear instancia de Colonia
        Colonia colonia1 = new Colonia("Centro", 25000, "Urbano");
        Colonia colonia2 = new Colonia("Norte", 25001, "Urbano");

        // Crear instancia de ActividadColonia
        ActividadColonia actividadColonia = new ActividadColonia(actividad, new ArrayList<>());
        actividadColonia.agregarColonia(colonia1);
        actividadColonia.agregarColonia(colonia2);

        // Mostrar detalles
        System.out.println("Detalles de la Cuadrilla:");
        System.out.println(cuadrilla);

        System.out.println("\nDetalles de la Actividad de Limpieza:");
        System.out.println(actividad);

        System.out.println("\nDetalles de ActividadColonia:");
        System.out.println(actividadColonia);
    }
}

