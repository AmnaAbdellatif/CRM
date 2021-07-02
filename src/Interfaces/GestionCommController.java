/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import DAO.ClientEntrepriseDAO;
import DAO.ClientparticDAO;
import DAO.EquipeDAO;
import DAO.HistoriqueDAO;
import Entites.ClientEntreprise;
import Entites.ClientParticulier;

import Entites.EquipeCommerciale;
import Entites.Historique;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.ImageView;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.util.Callback;
import javax.swing.ButtonGroup;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class GestionCommController implements Initializable {

    @FXML
    private Button valider;
    @FXML
    private TableView  tabcomm;
    @FXML
    private TableColumn  nomcomm;
    @FXML
    private TableColumn  prenomcomm;
    @FXML
    private TableColumn numordre;
    @FXML
    private Button buttonok;
    @FXML
    private Button buttonmodifier;
    @FXML
    private Button supprimer;
    @FXML
    private Button menuprincipal;
    @FXML
    private Button menuprincipal1;
    @FXML
    private Hyperlink hyperlink;
    @FXML
    private ImageView handle;
    
    @FXML
    private ComboBox  comboequipe;
    ClientparticDAO clpartic = new ClientparticDAO();
    ClientEntrepriseDAO clentrepr = new ClientEntrepriseDAO();
    ClientParticulier cl= new ClientParticulier();
      ClientEntreprise ET= new ClientEntreprise();
    EquipeDAO equipe= new EquipeDAO();
    Historique his = new Historique();
     HistoriqueDAO hisdao = new HistoriqueDAO();
    
    @FXML
    private TableView  tabclientparticul;
    @FXML
    private TableColumn  colonnenom;
    @FXML
    private TableColumn  colonneprenom;
    @FXML
    private TableColumn  colonneadresse;
    @FXML
    private TableView  tabcommerc;
    @FXML
    private TableColumn  fonctioncomm;
    
    @FXML
    private TableView tabentreprise;
    @FXML
    private TableColumn  colonnenomrep;
    @FXML
    private TableColumn colonneprenomrep;
    @FXML
    private TableColumn  colonneraison;
    @FXML
    private TextField textraison;
    @FXML
    private TableView tabcommerc1;
    @FXML
    private TableColumn  fonctioncomm1;
    @FXML
    private Button valider1;
    @FXML
    private TextField textnomclient;
    @FXML
    private TextField txtprenomclient;
    @FXML
    private RadioButton radioprepsect;
    @FXML
    private RadioButton radioreel;
    @FXML
    private RadioButton radioprospectentr;
    @FXML
    private RadioButton radioreelentre;
    @FXML
    private TableColumn nomcommerce;
    @FXML
    private TableColumn  prenomcommerce;
    @FXML
    private ComboBox  comboequipeenrep;
    @FXML
    private TableColumn  nomcomm1;
    @FXML
    private TableColumn prenomcomm1;
    @FXML
    private TableView  tabcommEntr;
    @FXML
    private TableColumn nomcommEntr;
    @FXML
    private TableColumn  prenomcommEntr;
    @FXML
    private TableColumn  numordreEntr;
    @FXML
    private Label txtnomequipe;
    @FXML
    private Label txtequipeentreprise;
    public RadioButton chk;
     public RadioButton chk1;
    
    ObservableList<EquipeCommerciale> listecomm= FXCollections.observableArrayList();
    @FXML
    private TextField txtresp;
    @FXML
    private TextField txtresp1;
    @FXML
    private Button AjoutButton1;
    @FXML
    private Button planifier;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
      
         
         tabclientparticul.refresh();
       colonnenom.setCellValueFactory(new PropertyValueFactory<ClientParticulier, String>("nom"));
        colonneprenom.setCellValueFactory(new PropertyValueFactory<ClientParticulier, String>("prenom"));
            colonneadresse.setCellValueFactory(new PropertyValueFactory<ClientParticulier, String>("adresse"));
        
         ObservableList<ClientParticulier> listeclient = null;  
      List<ClientParticulier> client = clpartic.findClientpartic();
        

       for (ClientParticulier cl : client) {
            listeclient = FXCollections.observableArrayList();
            listeclient.add(cl);
            System.out.println("liste" + cl);
          int j = tabclientparticul.getItems().size();
          tabclientparticul.getItems().addAll(j, listeclient);
     }
         
    tabclientparticul.getSelectionModel().selectedItemProperty().addListener(
                (ObservableValue observable, Object oldValue, Object newValue) -> afficheLaSelection((ClientParticulier) newValue));
              
     final ToggleGroup group = new ToggleGroup();      
    radioprepsect.setToggleGroup(group);
    radioreel.setToggleGroup(group);
   //  radioprepsect.setSelected(true);
    group.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
        @Override
        public void changed(ObservableValue<? extends Toggle> ov, Toggle t, Toggle t1) {

             chk = (RadioButton)t1.getToggleGroup().getSelectedToggle(); // Cast object to radio button
            System.out.println("Selected Radio Button - "+chk.getText());

        }
    });
    
     List listequipe = equipe.findNomEquipe();
      ObservableList<EquipeCommerciale> liste = FXCollections.observableArrayList(listequipe);
        comboequipe.setItems(liste);
        
     tabcommerc.setOnMouseClicked(e->{ 
     events();
 });
     //tabpaneEntreprise
     
       tabentreprise.refresh();
        colonnenomrep.setCellValueFactory(new PropertyValueFactory<ClientEntreprise, String>("nom"));
        colonneprenomrep.setCellValueFactory(new PropertyValueFactory<ClientEntreprise, String>("prenom"));
            colonneraison.setCellValueFactory(new PropertyValueFactory<ClientEntreprise, String>("raisonSociale"));
        
         ObservableList<ClientEntreprise> listeentreprise = null;  
      List<ClientEntreprise> entreprise = clentrepr.findClientEntreprise();
        

       for (ClientEntreprise cl : entreprise) {
            listeentreprise = FXCollections.observableArrayList();
            listeentreprise.add(cl);
            System.out.println("liste" + cl);
          int j = tabentreprise.getItems().size();
          tabentreprise.getItems().addAll(j, listeentreprise);
     }
        tabentreprise.getSelectionModel().selectedItemProperty().addListener(
                (ObservableValue observable, Object oldValue, Object newValue) -> afficheLaSelectionentreprise((ClientEntreprise) newValue));
     
final ToggleGroup group1 = new ToggleGroup();      
    radioprospectentr.setToggleGroup(group1);
    radioreelentre.setToggleGroup(group1);
    group1.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
        @Override
        public void changed(ObservableValue<? extends Toggle> ov, Toggle t, Toggle t1) {

             chk1 = (RadioButton)t1.getToggleGroup().getSelectedToggle(); // Cast object to radio button
            System.out.println("Selected Radio Button - "+chk1.getText());

        }
    });
    
    
    List listequipe1 = equipe.findNomEquipe();
      ObservableList<EquipeCommerciale> liste1 = FXCollections.observableArrayList(listequipe1);
        comboequipeenrep.setItems(liste1);
        
     tabcommerc1.setOnMouseClicked(e->{ 
     eventsentreprise();
 });
    
    
   
    
    }    


    @FXML
    private void valideronAction(ActionEvent event) throws IOException {
         FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("ficheClient.fxml"));
       // Parent test2_parent = loader.load();
        Parent root2 = loader.load();
     // Scene test2_scene = new Scene(test2_parent);
      String nomclient=textnomclient.getText();
      String prenomclient=txtprenomclient.getText();
       String nom_equipe= txtnomequipe.getText();
       String typeclient= chk.getText();
        String resp= txtresp.getText();
       
       
      // String typeclient=txtNomProjet.getText();
       
        //access the controller and call a method
            FicheClientController controller = loader.getController();
      Object cr =comboequipe.getSelectionModel().getSelectedItem();
         String act = cr.toString();
       
       
          listecomm = tabcomm.getItems();
        //  String x= listecomm.toString();
        //   Callback w=nomcommerce.getCellFactory();
           controller.settext1(nomclient, prenomclient,nom_equipe,typeclient,resp);
           controller.initData((EquipeCommerciale) tabcomm.getSelectionModel().getSelectedItem());
//                    int i=0;
// ObservableList<EquipeCommerciale> listeCom = FXCollections.observableArrayList(listecomm);
//  for (EquipeCommerciale pr: listeCom) {
//            System.out.println("listeAjout" +listeCom);
//           
//            
//            Historique his = new Historique(i,"","","",act,pr.getNom(),pr.getPrenom(),"",pr.getNumOrdre()) ;     
//            hisdao.insert(his);
//        }
//        System.out.println("done");
     


//This line gets the Stage information
        Stage stage = new Stage();
        stage.setTitle("");
        stage.setScene(new Scene (root2));
        stage.show();
        
        
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

    private void afficheLaSelection(ClientParticulier selection) {
         if (selection!=null){
        textnomclient.setText(selection.getNom());
        txtprenomclient.setText(selection.getPrenom());
        cl.setNom(selection.getNom());
        cl.setPrenom(selection.getPrenom());
        }
        }

    @FXML
    private void comboequipeonaction(ActionEvent event) {
         try {
            tabcommerc.refresh();

            Object comm = comboequipe.getSelectionModel().getSelectedItem();
            List liste = equipe.findlistCommerc(comm.toString());
            ObservableList<String> data = FXCollections.observableArrayList(liste);
            System.out.println(liste);
           //  tabcommerc.setItems(data);
              nomcomm.setCellValueFactory(new PropertyValueFactory<ClientParticulier, String>("nom"));
             prenomcomm.setCellValueFactory(new PropertyValueFactory<ClientParticulier, String>("prenom"));
             fonctioncomm.setCellValueFactory(new PropertyValueFactory<ClientParticulier, String>("fonction"));
             tabcommerc.getItems().addAll(data);
             txtnomequipe.setText(comm.toString());
            Object pr=comboequipe.getSelectionModel().getSelectedItem();
             List text1= equipe.findRespo(pr.toString());
            int i= 0; 
            txtresp.setText((String) text1.get(i));

        } catch (UnsupportedOperationException e1) {
            e1.printStackTrace();
        }
    }

    private void events() {
        nomcommerce.setCellValueFactory(new PropertyValueFactory<EquipeCommerciale, String>("nom"));
        prenomcommerce.setCellValueFactory(new PropertyValueFactory<EquipeCommerciale, String>("prenom"));
       numordre.setCellValueFactory(new PropertyValueFactory<>(""));
       
         tabcomm.getItems().addAll(tabcommerc.getSelectionModel().getSelectedItem());
         
         numordre.setCellFactory(TextFieldTableCell.forTableColumn());

        numordre.setOnEditCommit(
            new EventHandler<CellEditEvent<EquipeCommerciale, String>>() {
                public void handle(CellEditEvent<EquipeCommerciale, String> t) {
//                   int i=Integer.parseInt(t.toString()); 
                   
                    ((EquipeCommerciale) t.getTableView().getItems().get(
                        t.getTablePosition().getRow())
                         
                        ).setNumOrdre(t.getNewValue());
                }
            }
        );
        tabcomm.setEditable(true);
        
      }

    @FXML
    private void comboequipeenreponaction(ActionEvent event) {
        try {
            tabcommerc1.refresh();

            Object comm = comboequipeenrep.getSelectionModel().getSelectedItem();
            List liste = equipe.findlistCommerc(comm.toString());
            ObservableList<String> data = FXCollections.observableArrayList(liste);
            System.out.println(liste);
           //  tabcommerc.setItems(data);
              nomcomm1.setCellValueFactory(new PropertyValueFactory<ClientParticulier, String>("nom"));
             prenomcomm1.setCellValueFactory(new PropertyValueFactory<ClientParticulier, String>("prenom"));
             fonctioncomm1.setCellValueFactory(new PropertyValueFactory<ClientParticulier, String>("fonction"));
             tabcommerc1.getItems().addAll(data);
             Object pr=comboequipeenrep.getSelectionModel().getSelectedItem();
             List text1= equipe.findRespo(pr.toString());
            int i= 0; 
            txtresp1.setText((String) text1.get(i));
           

        } catch (UnsupportedOperationException e1) {
            e1.printStackTrace();
        }
        
    }

    private void afficheLaSelectionentreprise(ClientEntreprise selection) {
        if (selection!=null){
        textraison.setText(selection.getRaisonSociale());
        
        ET.setRaisonSociale(selection.getRaisonSociale());
        }
    
    }

    private void eventsentreprise() {
        nomcommEntr.setCellValueFactory(new PropertyValueFactory<EquipeCommerciale, String>("nom"));
        prenomcommEntr.setCellValueFactory(new PropertyValueFactory<EquipeCommerciale, String>("prenom"));
       numordreEntr.setCellValueFactory(new PropertyValueFactory<>(""));
       
         tabcommEntr.getItems().addAll(tabcommerc1.getSelectionModel().getSelectedItem());
         
         numordreEntr.setCellFactory(TextFieldTableCell.forTableColumn());

        numordreEntr.setOnEditCommit(
            new EventHandler<CellEditEvent<EquipeCommerciale, String>>() {
                public void handle(CellEditEvent<EquipeCommerciale, String> t) {
//                   int i=Integer.parseInt(t.toString()); 
                   
                    ((EquipeCommerciale) t.getTableView().getItems().get(
                        t.getTablePosition().getRow())
                         
                        ).setNumOrdre(t.getNewValue());
                }
            }
        );
        tabcommEntr.setEditable(true);
        }

    @FXML
    private void valider1onAction(ActionEvent event) throws IOException {
          FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("ficheEntreprise.fxml"));
       // Parent test2_parent = loader.load();
        Parent root2 = loader.load();
     // Scene test2_scene = new Scene(test2_parent);
      String raison=textraison.getText();
      
       String nom_equipe= txtequipeentreprise.getText();
       
       String typeclient= chk1.getText();
        String resp= txtresp1.getText();
       
       
      // String typeclient=txtNomProjet.getText();
       
        //access the controller and call a method
            FicheEntrepriseController controller = loader.getController();
      Object cr =comboequipeenrep.getSelectionModel().getSelectedItem();
         String act = cr.toString();
       
       
          listecomm = tabcomm.getItems();
        //  String x= listecomm.toString();
        //   Callback w=nomcommerce.getCellFactory();
           controller.settext1(raison, nom_equipe,typeclient,resp);
           controller.initData((EquipeCommerciale) tabcommerc1.getSelectionModel().getSelectedItem());
//                    int i=0;
// ObservableList<EquipeCommerciale> listeCom = FXCollections.observableArrayList(listecomm);
//  for (EquipeCommerciale pr: listeCom) {
//            System.out.println("listeAjout" +listeCom);
//           
//            
//            Historique his = new Historique(i,"","","",act,pr.getNom(),pr.getPrenom(),"",pr.getNumOrdre()) ;     
//            hisdao.insert(his);
//        }
//        System.out.println("done");
     


//This line gets the Stage information
        Stage stage = new Stage();
        stage.setTitle("");
        stage.setScene(new Scene (root2));
        stage.show();
        
        
    }

    @FXML
    private void handleplanifierButtonAction(ActionEvent event) throws IOException {
         Parent test2_parent = FXMLLoader.load(getClass().getResource("organisationEquipe.fxml"));
            Scene test2_scene = new Scene(test2_parent);
            
            
           
            Stage test1_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            test1_stage.setTitle("Bienvenue");
            test1_stage.setScene(test2_scene);
            
            
            
     
            test1_stage.show();
    }

  
    
    
}
