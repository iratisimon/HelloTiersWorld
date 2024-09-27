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
 * This class is a controller for the user application window.
 *
 * @author Irati and Elbire
 */
public class Application extends javafx.application.Application {

    /**
     * Initializes the main application window.
     *
     * @param stage the primary stage for this application
     * @throws Exception when the FXML view cannot be found or loaded
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
     * The main entry point for the JavaFX application.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
