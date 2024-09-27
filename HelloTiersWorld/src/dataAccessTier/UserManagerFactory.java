/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataAccessTier;

import java.util.ResourceBundle;
import userInterfaceTier.Application;

/**
 * Factory class to manage user data access by choosing between database access
 * and file-based access.
 *
 * @author Irati and Elbire
 */
public class UserManagerFactory extends Application {

    /**
     * Retrieves the data access method (database or file) from the properties
     * file.
     */
    private static final String GETDATAACCESS = ResourceBundle.getBundle("dataAccessTier.properties").getString("DATA_BASE");

    /**
     * Returns the appropriate data accessor (database or file) based on the
     * configuration in the properties file.
     *
     * @return a DataAccesible object, either {@link DBUserDataAccessor} or
     * {@link FileUserDataAccessor}
     */
    public static DataAccesible getData() {

        if (GETDATAACCESS.equalsIgnoreCase("true")) {
            return new DBUserDataAccessor();
        } else {
            return new FileUserDataAccessor();
        }
    }
}
