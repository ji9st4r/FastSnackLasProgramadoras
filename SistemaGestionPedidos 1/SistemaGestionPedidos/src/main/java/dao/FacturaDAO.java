/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import conexion.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import modelos.Factura;

/**
 *
 * @author Dhamar Aldana
 */
public class FacturaDAO {

    public void guardarFactura(Factura factura) {

        String sql = "INSERT INTO facturas"
                + "(numeroFactura, fechaEmision, totalFactura) "
                + "VALUES (?, ?, ?)";

        try (Connection conexion = ConexionBD.conectar(); PreparedStatement ps
                = conexion.prepareStatement(sql)) {

            ps.setString(1,factura.getNumeroFactura()
            );

            ps.setDate(2,new java.sql.Date(factura.getFechaEmision().getTime())
            );

            ps.setDouble(3,factura.getTotalFactura()
            );

            ps.executeUpdate();

            System.out.println(
                    "Factura guardada correctamente"
            );

        } catch (SQLException e) {
            System.out.println(
                    "Error al guardar factura: "
                    + e.getMessage()
            );
        }
    }
}
