/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import DAO.CommercialDAO;
import Entites.Commercial;
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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class LoginController implements Initializable {

    @FXML
    private TextField Login;
    @FXML
    private Button annuler;
    @FXML
    private Button valider;
    @FXML
    private PasswordField motPasse;

    /**
     * Initializes the controller class.
     */
     public CommercialDAO sp = new CommercialDAO();
    public Commercial loggedMember;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handleCancelButtonAction(ActionEvent event) throws IOException {
         Parent test2_parent = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        Scene test2_scene = new Scene(test2_parent);
        Stage test1_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        test1_stage.setScene(test2_scene);
        test1_stage.show();
    }

    
    
    @FXML
    private void handleLoginButtonAction(ActionEvent event)  throws IOException{
         System.out.println("Normalement avant connecté");
        loggedMember = sp.findbylogin(Login.getText(), motPasse.getText());
//        
         if  ( motPasse.getText().isEmpty()&&
                 Login.getText().isEmpty()){
             JOptionPane.showMessageDialog(null, "Veuillez saisir vos données");
            Login.setText("");
            motPasse.setText("");
             
         }
         else if  ( motPasse.getText().isEmpty()||
                 Login.getText().isEmpty()){
             JOptionPane.showMessageDialog(null, "Veuillez saisir vos données");
            Login.setText("");
            motPasse.setText("");
             
         }
          else  if ( loggedMember != null && !Login.getText().isEmpty()&& !motPasse.getText().isEmpty()) {
        if( loggedMember.getNom().equals(Login.getText()) && 
                loggedMember.getCodeUnique().equals(motPasse.getText())) {
            System.out.println("different null");
           String x= loggedMember.getFonction();
            if ("responsable".equalsIgnoreCase(x)) { //Foction est une colonne de base
System.out.println("dans responsable");
                Parent test2_parent = FXMLLoader.load(getClass().getResource("organisationEquipe.fxml"));
                Scene test2_scene;
                test2_scene = new Scene(test2_parent);
                Stage test1_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                // Scene scene = new ;
                test1_stage.setScene(test2_scene);
                test1_stage.show();
                test1_stage.setTitle("Gestion equipe");
                test1_stage.setMaximized(true);
        
        
    
    
     }else {
            JOptionPane.showMessageDialog(null, "Vérifier le saisie de vos données");
            Login.setText("");
            motPasse.setText("");} 
        } else  {
            JOptionPane.showMessageDialog(null, " Données erronées");
            Login.setText("");
            motPasse.setText("");
        }}}}
          
