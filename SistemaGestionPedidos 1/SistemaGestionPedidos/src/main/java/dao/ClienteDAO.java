/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import conexion.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelos.Cliente;

/**
 *
 * @author Dhamar Aldana
 */
public class ClienteDAO {

    public void guardarCliente(Cliente cliente) {

        String sql = "INSERT INTO clientes "
                + "(nombre, telefono, direccion) "
                + "VALUES (?, ?, ?)";

        try (Connection conexion = ConexionBD.conectar(); PreparedStatement ps = conexion.prepareStatement(sql)) {

            ps.setString(1, cliente.getNombre());
            ps.setString(2, cliente.getTelefono());
            ps.setString(3, cliente.getDireccion());

            ps.executeUpdate();

            System.out.println("Cliente guardado correctamente");

        } catch (SQLException e) {

            System.out.println("Error al guardar cliente: "
                    + e.getMessage());
        }
    }

    public ResultSet mostrarClientes() {

        ResultSet rs = null;

        String sql = "SELECT * FROM clientes";

        try {

            Connection conexion
                    = ConexionBD.conectar();

            PreparedStatement ps
                    = conexion.prepareStatement(sql);

            rs = ps.executeQuery();

        } catch (SQLException e) {

            System.out.println(
                    "Error al mostrar clientes: "
                    + e.getMessage()
            );
        }
        return rs;
    }

    public ResultSet buscarCliente(
            String telefono) {

        ResultSet rs = null;

        String sql = "SELECT * FROM clientes "
                + "WHERE telefono = ?";

        try {

            Connection conexion
                    = ConexionBD.conectar();

            PreparedStatement ps
                    = conexion.prepareStatement(sql);

            ps.setString(
                    1,
                    telefono
            );

            rs = ps.executeQuery();

        } catch (SQLException e) {

            System.out.println(
                    "Error al buscar cliente: "
                    + e.getMessage()
            );
        }

        return rs;
    }
}
