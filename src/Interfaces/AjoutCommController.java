/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import DAO.EquipeDAO;
import Entites.ClientParticulier;
import Entites.Commercial;
import Entites.EquipeCommerciale;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class AjoutCommController implements Initializable {

    @FXML
    private Button validercomm;
    @FXML
    private TextField txtnom_commerc;
    @FXML
    private TextField txtprenomcommerc;
    @FXML
    private TableView tabcommerc;
    @FXML
    private TableColumn  nomcommerc;
    @FXML
    private TableColumn  prenomcommerc;
    @FXML
    private TableColumn  fonctioncommerc;
    @FXML
    private TextField txtfonction;
    @FXML
    private ComboBox comboequipe;
    EquipeDAO equipe= new EquipeDAO();
ObservableList<EquipeCommerciale> listecomm= FXCollections.observableArrayList();
    @FXML
    private Button btnactualiser;
    @FXML
    private TextField txtresp;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         List listequipe = equipe.findNomEquipe();
      ObservableList<EquipeCommerciale> liste = FXCollections.observableArrayList(listequipe);
        comboequipe.setItems(liste);
        
         
    }    

    @FXML
    private void handlecomm(ActionEvent event) {
      
         Object cr =comboequipe.getSelectionModel().getSelectedItem();
         String act = cr.toString();
       
       int i=0;
           
            
           
            EquipeCommerciale eqp = new EquipeCommerciale(act,"",txtresp.getText(),"",txtnom_commerc.getText(),txtprenomcommerc.getText()
                    ,txtfonction.getText(),i,i,"") ;     
            equipe.insert(eqp);
       
        System.out.println("sous for");
       
           Alert alert = new Alert(Alert.AlertType.INFORMATION);

          alert.setTitle("Message Enregistrement");

          alert.setContentText("L'ajout d'un commercial est bien effectué");
          alert.showAndWait();
    }

    @FXML
    private void comboonaction(ActionEvent event) {
         try {
            tabcommerc.refresh();

            Object comm = comboequipe.getSelectionModel().getSelectedItem();
            List liste = equipe.findlistCommerc(comm.toString());
            ObservableList<String> data = FXCollections.observableArrayList(liste);
            System.out.println(liste);
           //  tabcommerc.setItems(data);
              nomcommerc.setCellValueFactory(new PropertyValueFactory<EquipeCommerciale, String>("nom"));
             prenomcommerc.setCellValueFactory(new PropertyValueFactory<EquipeCommerciale, String>("prenom"));
             fonctioncommerc.setCellValueFactory(new PropertyValueFactory<EquipeCommerciale, String>("fonction"));
             tabcommerc.getItems().addAll(data);
//             Object pr=comboequipeenrep.getSelectionModel().getSelectedItem();
//             List text1= equipe.findRespo(pr.toString());
//            int i= 0; 
//            txtresp1.setText((String) text1.get(i));
           Object pr=comboequipe.getSelectionModel().getSelectedItem();
             List text1= equipe.findRespo(pr.toString());
            int i= 0; 
            txtresp.setText((String) text1.get(i));

        } catch (UnsupportedOperationException e1) {
            e1.printStackTrace();
        }
    }

    @FXML
    private void btnactualiseronaction(ActionEvent event) {
        tabcommerc.getItems().clear();
         ObservableList<EquipeCommerciale> liste=null;
     Object cr =comboequipe.getSelectionModel().getSelectedItem();
         String act = cr.toString();
        List<EquipeCommerciale> eq = equipe.findlistCommerc(act);
        System.out.println(eq);
        for (EquipeCommerciale equi : eq) {
            liste = FXCollections.observableArrayList();
            liste.add(equi);
            System.out.println("liste" + liste);
            int j = tabcommerc.getItems().size();
            tabcommerc.getItems().addAll(j, liste);
           
    }
    }
    
}
