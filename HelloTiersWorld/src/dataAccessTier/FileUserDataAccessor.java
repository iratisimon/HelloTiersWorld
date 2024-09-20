/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataAccessTier;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.User;

/**
 *
 * @author 2dam
 */
public class FileUserDataAccessor implements DataAccesible {

    private static final String USERDATA = "user.properties";

    @Override
    public User getUserData() {
        Properties properties = new Properties();
        User user = new User();

        try (FileInputStream input = new FileInputStream(USERDATA)) {
            properties.load(input);
            user.setDNI(properties.getProperty("DNI"));
            user.setNameU(properties.getProperty("NameU"));
            user.setPasswd(properties.getProperty("Passwd"));
            user.setSurname(properties.getProperty("Surname"));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileUserDataAccessor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FileUserDataAccessor.class.getName()).log(Level.SEVERE, null, ex);
        }

        return user;
    }

}
