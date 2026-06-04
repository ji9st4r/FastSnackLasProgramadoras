/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import conexion.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import modelos.Pago;

/**
 *
 * @author Dhamar Aldana
 */
public class PagoDAO {

    public void guardarPago(Pago pago) {

        String sql = "INSERT INTO pagos"
                + "(metodoPago, monto, cedula, banco) "
                + "VALUES (?, ?, ?, ?)";

        try (Connection conexion = ConexionBD.conectar(); PreparedStatement ps
                = conexion.prepareStatement(sql)) {

            ps.setString(
                    1,
                    pago.getMetodoPago()
            );

            ps.setDouble(
                    2,
                    pago.getMonto()
            );

            ps.setString(
                    3,
                    pago.getCedula());

            ps.setString(
                    4,
                    pago.getBanco());

            ps.executeUpdate();

            System.out.println(
                    "Pago guardado correctamente"
            );

        } catch (SQLException e) {

            System.out.println(
                    "Error al guardar pago: "
                    + e.getMessage()
            );
        }
    }
}
