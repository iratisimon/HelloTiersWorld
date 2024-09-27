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
 * Data Access Object class to manage user data access.
 *
 * @author Irati and Elbire
 */
public class DBUserDataAccessor implements DataAccesible {

    /**
     * SQL query to retrieve all user data from the database.
     */
    private static final String GETUSERDATA = "SELECT * FROM user";

    /**
     * Opens a connection to the database.
     *
     * @return the database connection
     */
    public Connection openConnection() {

        Connection con = null;

        try {
            String url = "jdbc:mysql://localhost:3306/hellotiersworld1?zeroDateTimeBehavior=convertToNull";
            con = DriverManager.getConnection(url, "root", "abcd*1234");
        } catch (SQLException e) {
            Logger.getLogger("dataAccessTier").severe(e.getLocalizedMessage());

            new Alert(Alert.AlertType.ERROR, "No se ha podido abrir la base de datos.", ButtonType.OK).showAndWait();

        }
        return con;
    }

    /**
     * Closes the connection to the database.
     *
     * @param stmt the PreparedStatement object to be closed
     * @param con the Connection object to be closed
     * @throws SQLException if an error occurs while closing the connection
     */
    public void closeConnection(PreparedStatement stmt, Connection con) throws SQLException {

        if (stmt != null) {
            stmt.close();
        }
        if (con != null) {
            con.close();
        }
    }

    /**
     * Retrieves user data from the database.
     *
     * @return a User object containing user data, or null if no data is found
     */
    @Override
    public User getUserData() {
        Connection con = null;
        PreparedStatement stmt = null;
        User user = null;

        try {
            // Opens the connection
            con = openConnection();

            // Prepares the SQL statement
            stmt = con.prepareStatement(GETUSERDATA);

            // Executes the query
            ResultSet rs = stmt.executeQuery();

            // If results are found, creates a User instance with the data
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
