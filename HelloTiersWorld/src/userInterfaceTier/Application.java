/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterfaceTier;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * This class os a controller for the user application window
 * @author 2dam
 */
public class Application extends javafx.application.Application {
    /**
     * 
     * @param stage The main window
     * @throws Exception when view cannot be found
     */
    @Override
    public void start(Stage stage) throws Exception {
        //Load DOM from FXML view
        Parent root = FXMLLoader.load(getClass().getResource("UserDataView.fxml"));
        //Create Scene with our view
        Scene scene = new Scene(root);
        //Put Scene on Stage
        stage.setScene(scene);
        //Show Stage
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}