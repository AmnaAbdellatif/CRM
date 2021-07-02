/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import DAO.CommercialDAO;
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
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class SuppressionCommController implements Initializable {

    @FXML
    private AnchorPane comboboxvariant;
    @FXML
    private ComboBox comboboxcomm;
    @FXML
    private TableView  tableequipe;
    @FXML
    private TableColumn  colonnenom;
    @FXML
    private TableColumn  colonneprenom;
    @FXML
    private Button supprimerbutton;
    @FXML
    private TextField nomResponsable;
    @FXML
    private AnchorPane comboboxvariant1;
    @FXML
    private TableView  tablecomm;
    @FXML
    private TableColumn colonnecode;
    @FXML
    private TableColumn colonnenomcomm;
    @FXML
    private TableColumn  colonneprenomcomm;
    @FXML
    private TableColumn  colonnefctcomm;
    @FXML
    private TableColumn colonnesalaire;
    @FXML
    private Button supprimerbuttoncomm;
 EquipeDAO equipe= new EquipeDAO();
 CommercialDAO com= new CommercialDAO();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         List listequipe = equipe.findNomEquipe();
      ObservableList<EquipeCommerciale> liste = FXCollections.observableArrayList(listequipe);
        comboboxcomm.setItems(liste);
        
       //**affichage table commercial
       colonnecode.setCellValueFactory(new PropertyValueFactory<Commercial, String>("codeUnique"));
        colonnenomcomm.setCellValueFactory(new PropertyValueFactory<Commercial, String>("nom"));
         colonneprenomcomm.setCellValueFactory(new PropertyValueFactory<Commercial, String>("prenom"));
        colonnefctcomm.setCellValueFactory(new PropertyValueFactory<Commercial, String>("fonction"));
         colonnesalaire.setCellValueFactory(new PropertyValueFactory<Commercial, String>("salaireBase"));
         
         
        ObservableList<Commercial> listecom = null;
        List<Commercial> comr = com.findCommercial();
        System.out.println("liste commerc" +comr);
        
        for (Commercial pr : comr) {
            listecom = FXCollections.observableArrayList();
            listecom.add(pr);
            System.out.println("liste" + listecom);
            int j = tablecomm.getItems().size();
            tablecomm.getItems().addAll(j, listecom);

        }
        
        
        
        
        
        
        
        
    }    

    @FXML
    private void comboboxequipeAction(ActionEvent event) {
        Object pr=comboboxcomm.getSelectionModel().getSelectedItem();
             List text1= equipe.findRespo(pr.toString());
            int i= 0; 
            nomResponsable.setText((String) text1.get(i));
            
            
            
            Object comm = comboboxcomm.getSelectionModel().getSelectedItem();
            List liste = equipe.findlistCommerc(comm.toString());
            ObservableList<String> data = FXCollections.observableArrayList(liste);
            System.out.println(liste);
           //  tabcommerc.setItems(data);
              colonnenom.setCellValueFactory(new PropertyValueFactory<EquipeCommerciale, String>("nom"));
             colonneprenom.setCellValueFactory(new PropertyValueFactory<EquipeCommerciale, String>("prenom"));
            tableequipe.getItems().addAll(data);
    }

    @FXML
    private void supprimerbuttonAction(ActionEvent event) {
         ObservableList<EquipeCommerciale> CommSelected, allComm;
        allComm = tableequipe.getItems();
        CommSelected = tableequipe.getSelectionModel().getSelectedItems();
        System.out.println("projet selectionnee" +CommSelected.get(0));
        equipe.delete(CommSelected.get(0));
        System.out.println(CommSelected);
        CommSelected.forEach(allComm::remove);
        System.out.println(CommSelected);
        tableequipe.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
//        alert.initOwner(App.getPrimaryStage());
        alert.setTitle("Message Suppression");
//          alert.setHeaderText("No Person Selected");
        alert.setContentText("Le commercial souhaité est supprimé de l'equipe");
        alert.showAndWait();
    }

    @FXML
    private void supprimercommbuttonAction(ActionEvent event) {
        ObservableList<Commercial> CommSelected, allComm;
        allComm = tablecomm.getItems();
        CommSelected = tablecomm.getSelectionModel().getSelectedItems();
        System.out.println("projet selectionnee" +CommSelected.get(0));
        com.delete(CommSelected.get(0));
        System.out.println(CommSelected);
        CommSelected.forEach(allComm::remove);
        System.out.println(CommSelected);
        tablecomm.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
//        alert.initOwner(App.getPrimaryStage());
        alert.setTitle("Message Suppression");
//          alert.setHeaderText("No Person Selected");
        alert.setContentText("Le commercial souhaité est supprimé");
        alert.showAndWait();
    }
    
}
