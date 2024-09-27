/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterfaceTier;

import dataAccessTier.UserManagerFactory;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import model.User;

/**
 * Controller class for managing user data display in the user interface.
 *
 * @author Irati and Elbire
 */
public class UserDataWindowController {

    @FXML
    private TextField nameU;

    @FXML
    private TextField surname;

    @FXML
    private TextField dni;

    @FXML
    private TextField passwd;

    /**
     * Handles the button action to retrieve and display user data.
     *
     * @throws Exception if there is an error retrieving user data
     */
    @FXML
    private void handleButtonAction() {

        try {
            User user = UserManagerFactory.getData().getUserData();
            nameU.setId("nameU");
            nameU.setText(user.getNameU());
            surname.setId("surname");
            surname.setText(user.getSurname());
            dni.setId("dni");
            dni.setText(user.getDNI());
            passwd.setId("passwd");
            passwd.setText(user.getPasswd());
        } catch (Exception e) {
            Logger.getLogger("userInterfaceTier").severe(e.getLocalizedMessage());

            new Alert(Alert.AlertType.ERROR, "No se ha podido obtener los datos del usuario.", ButtonType.OK).showAndWait();
        }
    }

}
