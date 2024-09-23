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
 *
 * @author 2dam
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

    @FXML
    private void handleButtonAction() {

        try {
            User user = UserManagerFactory.getData().getUserData();
            nameU.setId("nameU");
            nameU.setPromptText(user.getNameU());
            surname.setId("surname");
            surname.setPromptText(user.getSurname());
            dni.setId("dni");
            dni.setPromptText(user.getDNI());
            passwd.setId("passwd");
            passwd.setPromptText(user.getPasswd());
        } catch (Exception e) {
            Logger.getLogger("userInterfaceTier").severe(e.getLocalizedMessage());

            new Alert(Alert.AlertType.ERROR, "No se ha podido obtener los datos del usuario.", ButtonType.OK).showAndWait();
        }
    }

}
