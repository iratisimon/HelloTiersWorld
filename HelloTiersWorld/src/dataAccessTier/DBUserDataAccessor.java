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
import java.util.logging.Logger;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
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
            String url = "jdbc:mysql://localhost:3306/hellotiersworld?zeroDateTimeBehavior=convertToNull";
            con = DriverManager.getConnection(url, "root", "abcd*1234");
        } catch (SQLException e) {
            Logger.getLogger("dataAccessTier").severe(e.getLocalizedMessage());

            new Alert(Alert.AlertType.ERROR, "No se ha podido abrir la base de datos.", ButtonType.OK).showAndWait();

        }
        return con;
    }

    /**
     * Cierra la conexion con la base de datos.
     *
     * @param stmt
     * @param con
     * @throws SQLException si ocurre un error al cerrar la conexión
     */
    public void closeConnection(PreparedStatement stmt, Connection con) throws SQLException {

        if (stmt != null) {
            stmt.close();
        }
        if (con != null) {
            con.close();
        }
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
            Logger.getLogger("dataAccessTier").severe(e.getLocalizedMessage());

            new Alert(Alert.AlertType.ERROR, "Error al obtener los datos del usuario: ", ButtonType.OK).showAndWait();

        } finally {
            try {
                closeConnection(stmt, con);
            } catch (SQLException e) {
                Logger.getLogger("dataAccessTier").severe(e.getLocalizedMessage());

                new Alert(Alert.AlertType.ERROR, "Error al cerrar la conexión: ", ButtonType.OK).showAndWait();

            }
        }
        return user;

    }

}
