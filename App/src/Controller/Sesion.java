/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Models.Usuario;
import Models.Rol;

public class Sesion {
    private static Sesion instancia;
    private Usuario usuarioActivo;

    private Sesion() {}

    public static Sesion getInstance() {
        if (instancia == null) {
            instancia = new Sesion();
        }
        return instancia;
    }

    public void iniciarSesion(Usuario usuario) {
        this.usuarioActivo = usuario;
    }

    public void cerrarSesion() {
        this.usuarioActivo = null;
    }

    public Usuario getUsuarioActivo() {
        return usuarioActivo;
    }

    public boolean estaAutenticado() {
        return usuarioActivo != null;
    }

    public boolean esAdministrador() {
        return estaAutenticado() && Rol.ADMINISTRADOR.equals(usuarioActivo.getRol());
    }
}