/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import java.util.List;

/**
 *
 * @author Dhamar Aldana
 */
public interface GestionDatos<T> {

    boolean guardar(T objeto);
    boolean editar(T objeto);
    boolean eliminar(int id);
    List<T> listar();
}
