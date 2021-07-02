/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import DAO.CommercialDAO;
import DAO.EquipeDAO;
import Entites.Commercial;
import Entites.EquipeCommerciale;
import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class organisationEquipeController implements Initializable {
    CommercialDAO cmr = new CommercialDAO();
    EquipeDAO eq= new EquipeDAO();
   

    @FXML
    private Button valider;
    @FXML
    private Button buttonok;
    @FXML
    private Button AjoutButton;
    @FXML
    private Button buttonmodifier;
    @FXML
    private Button supprimer;
    @FXML
    private Button menuprincipal;
    @FXML
    private Hyperlink hyperlink;
    @FXML
    private ImageView handle;
    
    @FXML
    private Button menuprincipal1;
    @FXML
    private TextField nomequipe;
    @FXML
    private TextField nomresp;
    @FXML
    private ComboBox  comboactv;
    @FXML
    private TableView  tabcommercial;
    @FXML
    private TableColumn  colonnenom;
    @FXML
    private TableColumn  colonneprenom;
    @FXML
    private TableView tab1Comm;
    @FXML
    private TableColumn nomComm;
    @FXML
    private TableColumn prenomComm;
    @FXML
    private TableColumn  fonctComm;
    ObservableList<Commercial> listeV = FXCollections.observableArrayList();
     ObservableList<Commercial> listecomm= FXCollections.observableArrayList();
     List<EquipeCommerciale> sliste= null;
       ObservableList<Commercial> listeCom= FXCollections.observableArrayList();
    @FXML
    private TableColumn  colonnefonction;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        tab1Comm.refresh();
       prenomComm.setCellValueFactory(new PropertyValueFactory<Commercial, String>("prenom"));
        fonctComm.setCellValueFactory(new PropertyValueFactory<Commercial, String>("fonction"));
 
            ObservableList<Commercial> liste = null;
       nomComm.setCellValueFactory(new PropertyValueFactory<Commercial, String>("nom"));
        
      List<Commercial> comm = cmr.findCommercial();
        System.out.println("comm" +comm);

       for (Commercial pr : comm) {
            liste = FXCollections.observableArrayList();
            liste.add(pr);
            System.out.println("liste" + pr);
          int j = tab1Comm.getItems().size();
          tab1Comm.getItems().addAll(j, liste);
     }
//      
 tab1Comm.setOnMouseClicked(e->{ 
     events();
 });
ObservableList<String> listeAct = FXCollections.observableArrayList("Avant-vente","vente","Apres-vente");
            
      comboactv.setItems(listeAct);
        comboactv.getSelectionModel().getSelectedItem();

       }

    @FXML
    private void valideronAction(ActionEvent event) {
            //EquipeCommerciale eqp = new EquipeCommerciale(nomresp.getText(),nomequipe.getText()
              //      comboactv.getSelectionModel().getSelectedItem(),"","",i,i,d,d,"");
                    listecomm = tabcommercial.getItems();
                    int i=0;
 ObservableList<Commercial> listeCom = FXCollections.observableArrayList(listecomm);
 
        System.out.println("longueur =" +listecomm.size());
         Object cr =comboactv.getSelectionModel().getSelectedItem();
         String act = cr.toString();
       
       
        for (Commercial pr: listeCom) {
            System.out.println("listeAjout" +sliste);
           
            
            EquipeCommerciale eqp = new EquipeCommerciale(nomequipe.getText(),act,nomresp.getText(),"",pr.getNom(),pr.getPrenom(),pr.getFonction(),i,i,"") ;     
            eq.insert(eqp);
        }
        System.out.println("sous for");
       
           Alert alert = new Alert(Alert.AlertType.INFORMATION);

          alert.setTitle("Message Enregistrement");

          alert.setContentText("L'ajout d'une equipe est bien effectué");
          alert.showAndWait();
    }

    @FXML
    private void handleAjouterButtonAction(ActionEvent event) throws IOException {
         FXMLLoader loader = new FXMLLoader(getClass().getResource("ajoutComm.fxml"));
            Parent root2 = loader.load();
            Stage stage = new Stage();
            stage.setTitle("Ajout");
            stage.setScene(new Scene(root2));
            stage.show();
    }

    @FXML
    private void ButtonmodifierAction(ActionEvent event) throws IOException {
          FXMLLoader loader = new FXMLLoader(getClass().getResource("modifiercomm.fxml"));
            Parent root2 = loader.load();
            Stage stage = new Stage();
            stage.setTitle("Ajout");
            stage.setScene(new Scene(root2));
            stage.show();
    }

    @FXML
    private void supprimerButtonAction(ActionEvent event) throws IOException {
         FXMLLoader loader = new FXMLLoader(getClass().getResource("suppressionComm.fxml"));
            Parent root2 = loader.load();
            Stage stage = new Stage();
            stage.setTitle("Ajout");
            stage.setScene(new Scene(root2));
            stage.show();
    }

    @FXML
    private void handlemenuButtonAction(ActionEvent event) throws IOException {
         Parent test2_parent = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
            Scene test2_scene = new Scene(test2_parent);
            
            
           
            Stage test1_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            test1_stage.setTitle("Bienvenue");
            test1_stage.setScene(test2_scene);
            
            
            
     
            test1_stage.show();
    }

    @FXML
    private void handle(ActionEvent event) {
        try {
            Desktop.getDesktop().browse(new URI("https://www.google.com/"));
        } catch (IOException e1) {
            e1.printStackTrace();
        } catch (URISyntaxException e1) {
            e1.printStackTrace();
        }
    }


    @FXML
    private void annuleronaction(ActionEvent event) {
        nomequipe.clear(); 
        nomresp.clear();
        for ( int i = 0; i<tabcommercial.getItems().size(); i++) {
    tabcommercial.getItems().clear();
}
    }



    @FXML
    private void handlegestclientButtonAction(ActionEvent event) throws IOException {
        Parent test2_parent = FXMLLoader.load(getClass().getResource("GestionComm.fxml"));
            Scene test2_scene = new Scene(test2_parent);
            
            
           
            Stage test1_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            test1_stage.setTitle("Gestion client et commercial");
            test1_stage.setScene(test2_scene);
            
            
            
     
            test1_stage.show();
        
    }




    private void events() {
    // listecom = tab1Comm.getSelectionModel().getSelectedItem();
         colonneprenom.setCellValueFactory(new PropertyValueFactory<Commercial, String>("prenom"));
        colonnenom.setCellValueFactory(new PropertyValueFactory<Commercial, String>("nom"));
        colonnefonction.setCellValueFactory(new PropertyValueFactory<Commercial, String>("fonction"));
       
         tabcommercial.getItems().addAll(tab1Comm.getSelectionModel().getSelectedItem());
        
        }
    
}
