/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataAccessTier;

import java.util.ResourceBundle;
import userInterfaceTier.Application;

/**
 *
 * @author 2dam
 */
public class UserManagerFactory extends Application {

    private static final String GETDATAACCESS = ResourceBundle.getBundle("dataAccessTier.properties").getString("DATA_BASE");

    public static DataAccesible getData() {

        if (GETDATAACCESS.equalsIgnoreCase("true")) {
            return new DBUserDataAccessor();
        } else {
            return new FileUserDataAccessor();
        }
    }
}
