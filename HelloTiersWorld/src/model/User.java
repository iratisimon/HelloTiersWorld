/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 * Class representing a user in the system.
 *
 * @author Irati and Elbire
 */
public class User {

    private String DNI;
    private String NameU;
    private String Surname;
    private String Passwd;

    /**
     * Default constructor for User.
     */
    public User() {
    }

    /**
     * Gets the user's DNI.
     *
     * @return the user's DNI
     */
    public String getDNI() {
        return DNI;
    }

    /**
     * Sets the user's DNI.
     *
     * @param DNI the user's DNI to set
     */
    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    /**
     * Gets the user's name.
     *
     * @return the user's name
     */
    public String getNameU() {
        return NameU;
    }

    /**
     * Sets the user's name.
     *
     * @param NameU the user's name to set
     */
    public void setNameU(String NameU) {
        this.NameU = NameU;
    }

    /**
     * Gets the user's surname.
     *
     * @return the user's surname
     */
    public String getSurname() {
        return Surname;
    }

    /**
     * Sets the user's surname.
     *
     * @param Surname the user's surname to set
     */
    public void setSurname(String Surname) {
        this.Surname = Surname;
    }

    /**
     * Gets the user's password.
     *
     * @return the user's password
     */
    public String getPasswd() {
        return Passwd;
    }

    /**
     * Sets the user's password.
     *
     * @param Passwd the user's password to set
     */
    public void setPasswd(String Passwd) {
        this.Passwd = Passwd;
    }

}
