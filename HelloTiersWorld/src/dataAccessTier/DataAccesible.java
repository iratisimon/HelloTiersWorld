/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataAccessTier;

import model.User;

/**
 * Interface for accessing user data from the data source.
 * 
 * @author Irati and Elbire
 */
public interface DataAccesible {
    
    /**
     * Retrieves user data from the data source.
     * 
     * @return a User object containing user data
     * @throws Exception if an error occurs while retrieving the data
     */

    public User getUserData() throws Exception;
}
