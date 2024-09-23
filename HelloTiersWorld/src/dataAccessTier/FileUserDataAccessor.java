/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataAccessTier;

import java.util.ResourceBundle;
import model.User;

/**
 *
 * @author 2dam
 */
public class FileUserDataAccessor implements DataAccesible {

    private static final String USERDATA = "dataAccessTier.user";

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
