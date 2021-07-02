/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import DAO.EquipeDAO;
import Entites.ClientParticulier;
import Entites.EquipeCommerciale;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.value.ObservableValue;
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
public class ModifiercommController implements Initializable {

    @FXML
    private Button charger1;
    @FXML
    private Button actualiser;
    private ComboBox ComboProjet;
    @FXML
    private Button Enregistrer;
    @FXML
    private Button actualiser1;
    @FXML
    private TextField txtprenom;
    @FXML
    private TableView  tableresp;
    @FXML
    private TableColumn  colonnenomresp;
    @FXML
    private TableColumn  colprenomresp;
    @FXML
    private TextField txtnom;
    @FXML
    private TableColumn  colonnenom;
    @FXML
    private TableColumn  colonnefct;
    @FXML
    private TextField txtfonction;
    @FXML
    private ComboBox  comborespeq;
    @FXML
    private TableView tablevcommerc;
    @FXML
    private ComboBox comboequipe;
EquipeDAO equipe= new EquipeDAO();
EquipeCommerciale eq = new EquipeCommerciale();
    @FXML
    private TableColumn  colonneprencommerc;
    @FXML
    private TextField txtact;
    @FXML
    private ListView listresp;
    @FXML
    private TextField txtnomresp;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        List listequipe = equipe.findNomEquipe();
      ObservableList<EquipeCommerciale> liste = FXCollections.observableArrayList(listequipe);
        comboequipe.setItems(liste);
         tablevcommerc.getSelectionModel().selectedItemProperty().addListener(
                (ObservableValue observable, Object oldValue, Object newValue) -> afficheLaSelection((EquipeCommerciale) newValue));
          
        comborespeq.setItems(liste);
          listresp.getSelectionModel().selectedItemProperty().addListener(
                (ObservableValue observable, Object oldValue, Object newValue) -> afficheLaSelectionresp((String) newValue));
        
         
         
    }    

   
    @FXML
    private void ComboboxonAction(ActionEvent event) {
         tablevcommerc.refresh();
try{
            Object comm = comboequipe.getSelectionModel().getSelectedItem();
            List liste = equipe.findlistCommerc(comm.toString());
            ObservableList<String> data = FXCollections.observableArrayList(liste);
            System.out.println(liste);
           //  tabcommerc.setItems(data);
              colonnenom.setCellValueFactory(new PropertyValueFactory<EquipeCommerciale, String>("nom"));
             colonneprencommerc.setCellValueFactory(new PropertyValueFactory<EquipeCommerciale, String>("prenom"));
             colonnefct.setCellValueFactory(new PropertyValueFactory<EquipeCommerciale, String>("fonction"));
             tablevcommerc.getItems().addAll(data);
              Object pr=comboequipe.getSelectionModel().getSelectedItem();
             List text1= equipe.findact(pr.toString());
            int i= 0; 
            txtact.setText((String) text1.get(i));

        } catch (UnsupportedOperationException e1) {
            e1.printStackTrace();
        }
    }

    @FXML
    private void comborespeqonaction(ActionEvent event) {
         
try{
            Object comm = comborespeq.getSelectionModel().getSelectedItem();
            List liste = equipe.findRespo(comm.toString());
            ObservableList<String> data = FXCollections.observableArrayList(liste);
            System.out.println(liste);
           //  tabcommerc.setItems(data);
           //   colonnenomresp.setCellValueFactory(new PropertyValueFactory<EquipeCommerciale, String>("responsableEquipe"));
           //  colprenomresp.setCellValueFactory(new PropertyValueFactory<EquipeCommerciale, String>("prenom"));
             listresp.getItems().addAll(data);
         //    tableresp.getItems().addAll(data);
             

        } catch (UnsupportedOperationException e1) {
            e1.printStackTrace();
        }
    }


    private void afficheLaSelection(EquipeCommerciale selection) {
        System.out.println("selection" + selection);
        if (selection!=null){
        txtnom.setText(selection.getNom());
        txtprenom.setText(selection.getPrenom());
        txtfonction.setText(selection.getFonction());
        eq.setNom(selection.getNom());
        eq.setPrenom(selection.getPrenom());
        eq.setFonction(selection.getFonction());
        
        }
       
      }

    @FXML
    private void handleupdateresButtonAction(ActionEvent event) {
         Object comm = comborespeq.getSelectionModel().getSelectedItem();
         String s=comm.toString();
         int i=0;
           List<EquipeCommerciale> eqcomm= equipe.findlistCommerc(s);
        System.out.println("comm" +eqcomm);
  ObservableList<EquipeCommerciale> liste = null;
       for (EquipeCommerciale pr : eqcomm) {
            liste = FXCollections.observableArrayList();
            liste.add(pr);
            System.out.println("liste" + pr);
          
     
        EquipeCommerciale eqq= new EquipeCommerciale(s,pr.getTypeActivEquipe(),txtnomresp.getText(),
                pr.getCodeUnique(),pr.getNom(),
        pr.getPrenom(),pr.getFonction(),pr.getSalaireDeBase(),pr.getTauxCommis(),pr.getNumOrdre());
          
       eq.setResponsableEquipe(txtnomresp.getText());
        
        equipe.update(eqq);
       }
        System.out.println("update");
        Alert alert=new Alert(Alert.AlertType.INFORMATION);
//        alert.initOwner(App.getPrimaryStage());
          alert.setTitle("Message Enregistrement");
//          alert.setHeaderText("No Person Selected");
          alert.setContentText("Les modifications sont bien Enregistrées");
          alert.showAndWait();
        
    }

    @FXML
    private void handleactualiserresAction(ActionEvent event) {
         Object comm = comborespeq.getSelectionModel().getSelectedItem();
            List liste = equipe.findRespo(comm.toString());
        ObservableList<EquipeCommerciale> listeeq = null;
        int j = 0;
        listeeq = FXCollections.observableArrayList();
         listresp.getItems().clear();
        listeeq.addAll(liste);
        System.out.println("liste" + liste);
        //  int j = tableProjet.getItems().size();
        listresp.getItems().clear();
        System.out.println("sous liste");
       listresp.getItems().addAll(liste);
    }

    @FXML
    private void handleenregistrercommButtonAction(ActionEvent event) {
         Object comm = comboequipe.getSelectionModel().getSelectedItem();
         String s=comm.toString();
         int i=0;
        EquipeCommerciale eqq= new EquipeCommerciale(s,txtact.getText(),"","",txtnom.getText(),txtprenom.getText(),
        txtfonction.getText(),i,i,"");
          eq.setNom(txtnom.getText());
        eq.setPrenom(txtprenom.getText());
        eq.setFonction(txtfonction.getText());
       
        
        equipe.update(eqq);
        System.out.println("update");
        Alert alert=new Alert(Alert.AlertType.INFORMATION);
//        alert.initOwner(App.getPrimaryStage());
          alert.setTitle("Message Enregistrement");
//          alert.setHeaderText("No Person Selected");
          alert.setContentText("Les modifications sont bien Enregistrées");
          alert.showAndWait();
        
    }

    @FXML
    private void handleactualisercommButtonAction(ActionEvent event) {
        
          Object comm = comboequipe.getSelectionModel().getSelectedItem();
            List liste = equipe.findlistCommerc(comm.toString());
        ObservableList<EquipeCommerciale> listeeq = null;
        int j = 0;
        listeeq = FXCollections.observableArrayList();
         tablevcommerc.getItems().clear();
        listeeq.addAll(liste);
        System.out.println("liste" + liste);
        //  int j = tableProjet.getItems().size();
        tablevcommerc.getItems().clear();
        tablevcommerc.setItems(listeeq);
        
    }

    private void afficheLaSelectionresp(String selection1) {
        System.out.println("selection" + selection1);
        if (selection1!=null){
             System.out.println("selection1" + selection1);
      txtnomresp.setText(selection1);
       // txtprenom.setText(selection.getPrenom());
         System.out.println("selection2" + selection1);
       // eq.setResponsableEquipe(selection1.getResponsableEquipe());
       // eq.setPrenom(selection.getPrenom());
       
        
        }
       }

    


    
}
