/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import conexion.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import modelos.Pedido;
import java.sql.Statement;
import java.sql.ResultSet;

/**
 *
 * @author Dhamar Aldana
 */
public class PedidoDAO {

    public void guardarPedido(Pedido pedido) {

        String sql = "INSERT INTO pedidos(fecha, total, estado, clienteNombre) "
                + "VALUES (?, ?, ?, ?)";

        try (Connection conexion = ConexionBD.conectar(); PreparedStatement ps = conexion.prepareStatement(
                sql,
                Statement.RETURN_GENERATED_KEYS)) {

            ps.setDate(
                    1,
                    new java.sql.Date(
                            pedido.getFecha().getTime()
                    )
            );

            ps.setDouble(2, pedido.getTotal());

            ps.setString(
                    3,
                    pedido.getEstado().toString()
            );

            ps.setString(
                    4,
                    pedido.getCliente().getNombre()
            );

            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {

                pedido.setIdPedido(
                        rs.getInt(1));
            }

            System.out.println(
                    "Pedido guardado correctamente"
            );

        } catch (SQLException e) {

            System.out.println(
                    "Error al guardar pedido: "
                    + e.getMessage()
            );
        }
    }

    public ResultSet Mostrar() {

        ResultSet rs = null;

        String sql = "SELECT * FROM pedidos";

        try {

            Connection conexion
                    = ConexionBD.conectar();

            PreparedStatement ps
                    = conexion.prepareStatement(sql);

            rs = ps.executeQuery();

        } catch (SQLException e) {

            System.out.println(
                    "Error al mostrar pedidos: "
                    + e.getMessage()
            );
        }

        return rs;
    }
    public ResultSet Buscar(String nombre) {

        ResultSet rs = null;

        String sql = "SELECT * FROM pedidos "
                + "WHERE clienteNombre LIKE ?";

        try {

            Connection conexion
                    = ConexionBD.conectar();

            PreparedStatement ps
                    = conexion.prepareStatement(sql);

            ps.setString(
                    1,
                    "%" + nombre + "%"
            );

            rs = ps.executeQuery();

        } catch (SQLException e) {

            System.out.println(
                    "Error al buscar pedido: "
                    + e.getMessage()
            );
        }

        return rs;
    }
}
