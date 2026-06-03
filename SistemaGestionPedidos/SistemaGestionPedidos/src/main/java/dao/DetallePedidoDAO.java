/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import conexion.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import modelos.DetallePedido;

/**
 *
 * @author Dhamar Aldana
 */
public class DetallePedidoDAO {

    public void guardarDetalle(
            DetallePedido detalle) {

        String sql
                = "INSERT INTO detalle_pedido "
                + "(productoNombre, cantidad, precio, subtotal, ClienteNombre) "
                + "VALUES (?, ?, ?, ?, ?)";

        try (
                Connection conexion
                = ConexionBD.conectar(); PreparedStatement ps
                = conexion.prepareStatement(sql)) {

            ps.setString(
                    1,
                    detalle.getProducto().getNombre()
            );

            ps.setInt(
                    2,
                    detalle.getCantidad()
            );

            ps.setDouble(
                    3,
                    detalle.getProducto().getPrecio()
            );

            ps.setDouble(
                    4,
                    detalle.getSubtotal()
            );

            ps.setString(
                    5,
                    detalle.getClienteNombre()
            );

            ps.executeUpdate();

            System.out.println(
                    "Detalle guardado correctamente"
            );

        } catch (SQLException e) {

            System.out.println(
                    "Error al guardar detalle: "
                    + e.getMessage()
            );
        }
    }
}
