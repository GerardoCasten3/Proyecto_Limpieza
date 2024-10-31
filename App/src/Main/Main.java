package Main;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import Methods.*;
import Objects.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        UsuarioDAO userDAO = new UsuarioDAO();
        Sesion sesion = Sesion.getInstance();
        Scanner s = new Scanner(System.in);
        System.out.println("====== Inicio de Sesión =====");
        System.out.println("Ingresa tu nombre de usuario: ");
        String usern = s.nextLine();
        System.out.println("Ingresa tu contraseña: ");
        String pswd = s.nextLine();
        Usuario user_princ = userDAO.validaUsuario(usern, pswd);
        sesion.iniciarSesion(user_princ);

        if (sesion.estaAutenticado() && sesion.esAdministrador()) {
            Menu(user_princ);
        } else if (sesion.estaAutenticado()) {
            Menu(user_princ);
        }else{
            System.out.println("Credenciales incorrectas.");
        }
    }

    public static void Menu(Usuario user_princ) {
       // Instancias de DAOs
        UsuarioDAO userDAO = new UsuarioDAO();
        EmpleadoDAO empDAO = new EmpleadoDAO();
        CuadrillaDAO cuadDAO = new CuadrillaDAO();
        ColoniasDAO colDAO = new ColoniasDAO();
        ActividadLimpiezaDAO actDAO = new ActividadLimpiezaDAO();
        ActividadColoniaDAO actCDAO = new ActividadColoniaDAO();
        Scanner s = new Scanner(System.in);
        int opc = 0;

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy"); // Formato de fecha esperado
        dateFormat.setLenient(false);
        do {
            System.out.println("===== CRUD para Sistema de Limpieza =====");
            System.out.println("1.- Insertar");
            System.out.println("2.- Leer");
            System.out.println("3.- Actualizar");
            System.out.println("4.- Eliminar");
            System.out.println("0.- Salir");
            opc = s.nextInt();
            s.nextLine(); // Limpiar el buffer

            switch (opc) {
                case 1 -> {
                    int opc1 = 0;
                    do {
                        System.out.println("Elige la tabla a insertar:");
                        System.out.println("1.- Usuario");
                        System.out.println("2.- Empleado");
                        System.out.println("3.- Cuadrilla");
                        System.out.println("4.- Colonia");
                        System.out.println("5.- Actividad de Limpieza");
                        System.out.println("0.- Salir");
                        opc1 = s.nextInt();
                        s.nextLine(); // Limpiar el buffer

                        switch (opc1) {
                            case 1:
                                System.out.println("Nombre de usuario: ");
                                String username = s.nextLine();
                                System.out.println("Contraseña: ");
                                String password = s.nextLine();
                                System.out.println("Rol (Administrador o Empleado): ");
                                String rolIpt = s.nextLine().toUpperCase();
                                Rol rol = Rol.valueOf(rolIpt);
                                Usuario user1 = new Usuario(username, password, rol);
                                userDAO.insertarUsuario(user1);
                                break;
                            case 2:
                                System.out.println("Nombre: ");
                                String name = s.nextLine();
                                System.out.println("Cargo: ");
                                String cargo = s.nextLine();
                                System.out.println("¿Es jefe de cuadrilla? (S/N) ");
                                boolean leader = s.nextLine().equalsIgnoreCase("S");
                                Empleado emp = new Empleado(name, cargo, leader);
                                empDAO.insertarEmpleado(emp);
                                break;
                            case 3:
                                System.out.println("Nombre de la cuadrilla: ");
                                String nameC = s.nextLine();
                                Cuadrilla cuadrilla = new Cuadrilla(nameC);
                                cuadDAO.insertarCuadrilla(cuadrilla);
                                break;

                            case 4:
                                System.out.println("Nombre de la colonia: ");
                                String nameColonia = s.nextLine();
                                System.out.println("Código postal: ");
                                int cp = s.nextInt();
                                s.nextLine(); // Limpiar el buffer
                                System.out.println("Tipo de asentamiento: ");
                                String tipoA = s.nextLine();
                                Colonia colonia = new Colonia(nameColonia, cp, tipoA);
                                colDAO.agregarColonia(colonia);
                                break;

                            case 5:
                                System.out.println("Descripcion de la actividad: ");
                                String descp = s.nextLine();
                                System.out.print("Introduce la fecha (dd/MM/yyyy): ");
                                String fechaStr = s.nextLine();
                                Date fecha = new Date();
                                try {
                                    // Convertir la cadena a un objeto Date
                                    fecha = dateFormat.parse(fechaStr);
                                    System.out.println("Fecha ingresada: " + fecha);
                                } catch (ParseException e) {
                                    System.out.println("Formato de fecha inválido. Por favor, usa el formato dd/MM/yyyy.");
                                }
                                System.out.println("Escribe el nombre de la cuadrilla al que se le asignará: ");
                                String nombreCuadrilla = s.nextLine();
                                System.out.println("Escribe el nombre de la colonia asignada a la actividad: ");
                                String nombre_colonia = s.nextLine();

                                colonia = colDAO.obtenerColoniaPorNombre(nombre_colonia);
                                Cuadrilla cuadrilla1 = cuadDAO.obtenerCuadrillaPorNombre(nombreCuadrilla);
                                ActividadLimpieza actividadLimpieza = new ActividadLimpieza(descp, fecha, cuadrilla1);
                                actDAO.insertarActividad(actividadLimpieza);
                                actividadLimpieza = actDAO.buscarPrimeraActividadPorNombre(descp);
                                actCDAO.agregarActividadColonia(actividadLimpieza, colonia);
                                System.out.println("¿Deseas añadir otra colonia? (S/N)");
                                String ans = s.next().toUpperCase();
                                if (ans.equals("S")) {
                                    s.nextLine();
                                    System.out.println("Escribe el nombre de la colonia asignada a la actividad: ");
                                    nombre_colonia = s.nextLine();
                                    colonia = colDAO.obtenerColoniaPorNombre(nombre_colonia);
                                    actividadLimpieza = actDAO.buscarPrimeraActividadPorNombre(descp);
                                    actCDAO.agregarActividadColonia(actividadLimpieza, colonia);
                                }
                                System.out.println("¡Se ingresó correctamente la actividad!");
                                s.nextLine();
                                break;
                        }
                    } while (opc1 != 0); // Menú insertar
                } // Fin caso uno
                case 2 -> {
                    int opc1 = 0;
                    do {
                        System.out.println("Elige la tabla a leer:");
                        System.out.println("1.- Usuario");
                        System.out.println("2.- Empleado");
                        System.out.println("3.- Cuadrilla");
                        System.out.println("4.- Colonia");
                        System.out.println("5.- Actividad de Limpieza");
                        System.out.println("0.- Salir");
                        opc1 = s.nextInt();
                        s.nextLine(); // Limpiar el buffer

                        switch (opc1) {
                            case 1:
                                List<Usuario> usuarios = userDAO.obtenerUsuarios();
                                for (Usuario usuario : usuarios) {
                                    System.out.println(usuario);
                                }
                                break;
                            case 2:
                                List<Empleado> empleados = empDAO.obtenerEmpleados();
                                for (Empleado empleado : empleados) {
                                    System.out.println(empleado);
                                }
                                break;
                            case 3:
                                List<Cuadrilla> cuadrillas = cuadDAO.obtenerCuadrillas();
                                for (Cuadrilla cuadrilla : cuadrillas) {
                                    System.out.println(cuadrilla);
                                }
                                break;
                            case 4:
                                List<Colonia> colonias = colDAO.obtenerTodasLasColonias();
                                for (int i = 0; i < Math.min(5, colonias.size()); i++) {
                                    Colonia colonia = colonias.get(i);
                                    System.out.println("Nombre: " + colonia.getNombre()
                                            + ", Código Postal: " + colonia.getCodigoPostal()
                                            + ", Tipo de Asentamiento: " + colonia.getTipoAsentamiento());
                                }
                                break;
                            case 5:
                                List<ActividadLimpieza> actividades = actDAO.obtenerTodasLasActividades();
                                for (ActividadLimpieza actividadades : actividades) {
                                    System.out.println(actividades.toString());
                                }
                        }

                    } while (opc1 != 0); // Menú leer
                } // Fin caso 2
                case 3 -> {
                    int opc1 = 0;
                    do {
                        System.out.println("Elige la tabla a actualizar:");
                        System.out.println("1.- Usuario");
                        System.out.println("2.- Empleado");
                        System.out.println("3.- Cuadrilla");
                        System.out.println("4.- Colonia");
                        System.out.println("5.- Actividad de Limpieza");
                        System.out.println("0.- Salir");
                        opc1 = s.nextInt();
                        s.nextLine(); // Limpiar el buffer

                        switch (opc1) {
                            case 1:
                                System.out.println("Ingresa el ID a actualizar: ");
                                int id = s.nextInt();
                                s.nextLine();
                                System.out.println("Nombre de usuario: ");
                                String username = s.nextLine();
                                System.out.println("Contraseña: ");
                                String password = s.nextLine();
                                System.out.println("Rol (Administrador o Empleado): ");
                                String rolIpt = s.nextLine().toUpperCase();
                                Rol rol = Rol.valueOf(rolIpt);
                                Usuario user1 = new Usuario(id, username, password, rol);
                                userDAO.actualizarUsuario(user1);
                                System.out.println("¡Se actualizó con éxito el usuario!");
                                s.nextLine();

                                break;
                            case 2:
                                System.out.println("Ingresa el ID a actualizar: ");
                                id = s.nextInt();
                                s.nextLine();
                                System.out.println("Nombre: ");
                                String name = s.nextLine();
                                System.out.println("Cargo: ");
                                String cargo = s.nextLine();
                                System.out.println("¿Es jefe de cuadrilla? (S/N) ");
                                boolean leader = s.nextLine().equalsIgnoreCase("S");
                                System.out.println("Nombre de la cuadrilla a la cual pertenece: ");
                                String cuad = s.nextLine();
                                System.out.println("Ingrese su ID de usuario: ");
                                int id_user = s.nextInt();

                                Cuadrilla cuadrilla = cuadDAO.obtenerCuadrillaPorNombre(cuad);
                                Usuario user = userDAO.obtenerUsuarioPorId(id_user);
                                Empleado emp = new Empleado(name, cargo, leader, cuadrilla, user);
                                empDAO.actualizarEmpleado(emp, id);
                                System.out.println("¡Se actualizó con éxito el empleado!");
                                s.nextLine();

                                break;
                            case 3:
                                System.out.println("Ingresa el ID a actualizar: ");
                                int id_cuadrilla = s.nextInt();
                                s.nextLine();
                                System.out.println("Ingresa el nuevo nombre: ");
                                String nombre_cuadrilla = s.nextLine();
                                cuadrilla = new Cuadrilla(nombre_cuadrilla);
                                cuadDAO.actualizarCuadrilla(cuadrilla, id_cuadrilla);
                                System.out.println("¡Se actualizó con éxito la cuadrilla!");
                                s.nextLine();
                                break;
                            case 4:
                                System.out.println("Ingresa el nombre de la colonia que quieras actualizar: ");
                                name = s.nextLine();
                                Colonia colonia = colDAO.obtenerColoniaPorNombre(name);
                                int id_colonia = colonia.getId_colonia();

                                System.out.println("Ingresa el nuevo nombre: ");
                                String newName = s.nextLine();
                                System.out.println("Ingresa el codigo postal: ");
                                int cod_post = s.nextInt();
                                s.nextLine();
                                System.out.println("Ingresa el tipo de asentamiento: ");
                                String tipo = s.nextLine();

                                colonia = new Colonia(newName, cod_post, tipo);
                                colDAO.actualizarColonia(colonia, id_colonia);
                                System.out.println("¡Se actualizó con éxito!");
                                s.nextLine();
                                break;
                            case 5:
                                System.out.println("Ingresa el ID de la actividad a actualizar: ");
                                int id_act = s.nextInt();
                                s.nextLine();
                                System.out.println("¿Deseas actualizar toda la actividad o solo agregar retroalimentación y una imagen? (1/2)");
                                int answ = s.nextInt();
                                s.nextLine();
                                if (answ == 1) {

                                    s.nextLine();
                                    System.out.println("Descripcion de la actividad: ");
                                    String descp = s.nextLine();
                                    System.out.print("Introduce la fecha (dd/MM/yyyy): ");
                                    String fechaStr = s.nextLine();
                                    Date fecha = new Date();
                                    try {
                                        // Convertir la cadena a un objeto Date
                                        fecha = dateFormat.parse(fechaStr);
                                        System.out.println("Fecha ingresada: " + fecha);
                                    } catch (ParseException e) {
                                        System.out.println("Formato de fecha inválido. Por favor, usa el formato dd/MM/yyyy.");
                                    }
                                    System.out.println("Escribe el nombre de la cuadrilla al que se le asignará: ");
                                    String nombreCuadrilla = s.nextLine();
                                    System.out.println("Escribe el nombre de la colonia asignada a la actividad: ");
                                    String nombre_colonia = s.nextLine();

                                    colonia = colDAO.obtenerColoniaPorNombre(nombre_colonia);
                                    Cuadrilla cuadrilla1 = cuadDAO.obtenerCuadrillaPorNombre(nombreCuadrilla);
                                    ActividadLimpieza actividadLimpieza = new ActividadLimpieza(descp, fecha, cuadrilla1);

                                    actDAO.actualizarActividad(actividadLimpieza, id_act);
                                    actividadLimpieza = actDAO.buscarPrimeraActividadPorNombre(descp);
                                    actCDAO.agregarActividadColonia(actividadLimpieza, colonia);
                                    System.out.println("¿Deseas añadir otra colonia? (S/N)");
                                    String ans = s.next().toUpperCase();
                                    if (ans.equals("S")) {
                                        s.nextLine();
                                        System.out.println("Escribe el nombre de la colonia asignada a la actividad: ");
                                        nombre_colonia = s.nextLine();
                                        colonia = colDAO.obtenerColoniaPorNombre(nombre_colonia);
                                        actividadLimpieza = actDAO.buscarPrimeraActividadPorNombre(descp);
                                        actCDAO.agregarActividadColonia(actividadLimpieza, colonia);
                                    }
                                    System.out.println("¡Se actualizó correctamente la actividad!");
                                    s.nextLine();
                                } else {
                                    System.out.println("Ingresa la retroalimentación de la actividad: ");
                                    String retro = s.nextLine();
                                    System.out.println("Ingresa la imagen: ");
                                    String imagen = s.nextLine();
                                    actDAO.actualizarRetroalimentacionImagen(retro, imagen, id_act);
                                    System.out.println("¡Se actualizó correctamente la retroalimentación y la imagen!");
                                    user_princ.actualizar("Se actualizó los campos de retroalimentación e imagen en la actividad " + id_act);
                                    s.nextLine();
                                }
                        }

                    } while (opc1 != 0); // Menú actualizar
                } // Fin caso 3
                case 4 -> {
                    int opc1 = 0;
                    do {
                        System.out.println("Elige la tabla a eliminar:");
                        System.out.println("1.- Usuario");
                        System.out.println("2.- Empleado");
                        System.out.println("3.- Cuadrilla");
                        System.out.println("4.- Colonia");
                        System.out.println("5.- Actividad de Limpieza");
                        System.out.println("0.- Salir");
                        opc1 = s.nextInt();
                        s.nextLine(); // Limpiar el buffer

                        switch (opc1) {
                            case 1:
                                System.out.println("Ingrese el ID del usuario a eliminar: ");
                                int id = s.nextInt();
                                userDAO.eliminarUsuario(id);
                                s.nextLine();
                                System.out.println("¡Se eliminó con éxito!");
                                break;
                            case 2:
                                System.out.println("Ingrese el ID del empleado a eliminar: ");
                                id = s.nextInt();
                                empDAO.eliminarEmpleado(id);
                                System.out.println("¡Se eliminó con éxito!");
                                s.nextLine();
                                break;
                            case 3:
                                System.out.println("Ingrese el ID de la cuadrilla a eliminar: ");
                                id = s.nextInt();
                                cuadDAO.eliminarCuadrilla(id);
                                System.out.println("¡Se eliminó con éxito!");
                                s.nextLine();
                                break;
                            case 4:
                                System.out.println("Ingrese el ID de la colonia a eliminar: ");
                                id = s.nextInt();
                                colDAO.eliminarColonia(id);
                                System.out.println("¡Se eliminó con éxito!");
                                s.nextLine();
                                break;
                            case 5:
                                System.out.println("Ingrese el ID de la actividad a eliminar: ");
                                id = s.nextInt();
                                actDAO.eliminarActividad(id);
                                System.out.println("¡Se eliminó con éxito!");
                                s.nextLine();
                                break;
                        }

                    } while (opc1 != 0); // Menú eliminar
                } // Fin caso 4
                }

        } while (opc != 0);
        s.close();

    }

}
