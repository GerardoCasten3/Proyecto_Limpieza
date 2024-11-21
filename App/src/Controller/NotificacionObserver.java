/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Models.Observer;
/**
 *
 * @author gerar
 */
public class NotificacionObserver implements Observer{
    
    private int idUsuario;
    private ActividadLimpiezaDAO actividadLimpiezaDAO;

    public NotificacionObserver(int idUsuario) {
        this.idUsuario = idUsuario;
        this.actividadLimpiezaDAO = new ActividadLimpiezaDAO(); 
    }

    @Override
    public void actualizar(String mensaje) {
        actividadLimpiezaDAO.guardarNotificacion(idUsuario, 0, mensaje); 
        System.out.println("Notificación del usuario " + idUsuario + ": " + mensaje);
    }
    
}
