/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private Button btnApplication;
    @FXML
    private Button btnApplication1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handleApplicationButtonAction(ActionEvent event) 
        throws IOException {
         
        Parent test2_parent = FXMLLoader.load(getClass().getResource("login.fxml"));
            Scene test2_scene = new Scene(test2_parent);
            
            
           
            Stage test1_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            test1_stage.setTitle("Bienvenue");
            test1_stage.setScene(test2_scene);
            
            
            
     
            test1_stage.show();
     
    
    }

    @FXML
    private void handleExitButtonAction(ActionEvent event) {
         System.exit(0);
    }
    
}
