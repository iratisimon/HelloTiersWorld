/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataAccessTier;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.User;

/**
 *
 * @author 2dam
 */
public class DBUserDataAccessor implements DataAccesible {

    /**
     * Abre una conexion con la base de datos.
     */
    private static final String GETUSERDATA = "SELECT * FROM user";

    public Connection openConnection() {
        // TODO Auto-generated method stub
        Connection con = null;
        try {
            String url = "jdbc:mysql://localhost:3306/hellotiersworld?serverTimezone=Europe/Madrid&useSSL=false";
            con = DriverManager.getConnection(url, "root", "abcd*1234");
        } catch (SQLException e) {
            System.out.println("Error al intentar abrir la BD");
        }
        return con;
    }

    /**
     * Cierra la conexion con la base de datos.
     *
     * @throws SQLException si ocurre un error al cerrar la conexión
     */
    public void closeConnection(PreparedStatement stmt, Connection con) throws SQLException {
        System.out.println("Conexion cerrada");
        if (stmt != null) {
            stmt.close();
        }
        if (con != null) {
            con.close();
        }
        System.out.println("--------------------");
    }

    @Override
    public User getUserData() {
        Connection con = null;
        PreparedStatement stmt = null;
        User user = null;

        try {
            // Abre la conexión
            con = openConnection();

            // Prepara la sentencia SQL
            stmt = con.prepareStatement(GETUSERDATA);

            // Ejecuta la consulta
            ResultSet rs = stmt.executeQuery();

            // Si hay resultados, crea una instancia de User con los datos
            if (rs.next()) {
                user = new User();
                user.setDNI(rs.getString("DNI"));
                user.setNameU(rs.getString("NameU"));
                user.setSurname(rs.getString("Surname"));
                user.setPasswd(rs.getString("Passwd"));
            }

        } catch (SQLException e) {
            System.out.println("Error al obtener los datos del usuario: " + e.getMessage());
        } finally {
            try {
                closeConnection(stmt, con);
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
        return user;

    }

}
