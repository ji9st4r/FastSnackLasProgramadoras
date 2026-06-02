/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import conexion.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import modelos.Producto;

/**
 *
 * @author Dhamar Aldana
 */
public class ProductoDAO {

    public void guardarProducto(Producto producto) {

        String sql = "INSERT INTO productos(nombre, precio) VALUES (?, ?)";

        try (Connection conexion = ConexionBD.conectar(); PreparedStatement ps = conexion.prepareStatement(sql)) {

            ps.setString(1, producto.getNombre());
            ps.setDouble(2, producto.getPrecio());

            ps.executeUpdate();

            System.out.println("Producto guardado correctamente");

        } catch (SQLException e) {

            System.out.println("Error al guardar producto: "
                    + e.getMessage());
        }
    }
}
