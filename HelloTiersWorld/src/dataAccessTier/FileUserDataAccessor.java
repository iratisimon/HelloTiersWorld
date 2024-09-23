/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataAccessTier;

import java.util.ResourceBundle;
import model.User;

/**
 * Class for accessing user data from a properties file using ResourceBundle.
 *
 * @author Irati and Elbire
 */
public class FileUserDataAccessor implements DataAccesible {

    /**
     * The name of the properties file containing user data.
     */
    private static final String USERDATA = "dataAccessTier.user";

    /**
     * Retrieves user data from the properties file.
     *
     * @return a User object containing the user data from the file
     */
    @Override
    public User getUserData() {
        ResourceBundle resourceBundle = ResourceBundle.getBundle(USERDATA);
        User user = new User();

        user.setDNI(resourceBundle.getString("DNI"));
        user.setNameU(resourceBundle.getString("NameU"));
        user.setPasswd(resourceBundle.getString("Passwd"));
        user.setSurname(resourceBundle.getString("Surname"));

        return user;
    }

}
