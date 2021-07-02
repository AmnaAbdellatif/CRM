/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import DAO.EquipeDAO;
import DAO.HistoriqueDAO;
import Entites.ClientParticulier;
import Entites.EquipeCommerciale;
import Entites.Historique;


import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.String.format;
import java.net.URL;
import static java.text.MessageFormat.format;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.util.Callback;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javafx.beans.binding.Bindings.format;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;
import javax.swing.JFileChooser;
import static jdk.nashorn.internal.runtime.ErrorManager.format;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class FicheClientController implements Initializable {

    @FXML
    private AnchorPane imprimepage;
    @FXML
    private TextField txtequipe;
    @FXML
    private TextField txttypeclient;
    @FXML
    private TextField txtdate;
    
    @FXML
    private TextField txtnomclient;
    @FXML
    private TextField txtprenomclient;
    @FXML
    private TextField txtresp;
HistoriqueDAO equipe= new HistoriqueDAO();
    private EquipeCommerciale selectedeq;
    
    @FXML
    private TextArea txtnomcomm;
    @FXML
    private TextArea txtprenomcomm;
    @FXML
    private TextArea txtnumordre;
    /**
     * Initializes the controller class.
     */
    FileChooser fileChooser= new FileChooser();
    @FXML
    private Button btnimprimer;
    @FXML
    private Button btnsave;
    @FXML
    private Label labelnomclient;
    @FXML
    private Label labelprenomclient;
    @FXML
    private Label labelequipe;
    @FXML
    private Label labeltype;
    @FXML
    private Label labeldate;
    @FXML
    private Label labelcommerciaux;
    @FXML
    private Label labelresp;
    @FXML
    private Label labelnomcomm;
    @FXML
    private Label labelprenomcomm;
    @FXML
    private Label labelnumordre;
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        fileChooser.setInitialDirectory(new File("C:\\Users\\HP\\Desktop\\historique"));
    }    

    @FXML
    private void btnimprimerAction(ActionEvent event) throws IOException {
         
          //  FileChooser fileChooser = new FileChooser();
 
            //Set extension filter for text files
            FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
            fileChooser.getExtensionFilters().add(extFilter);
        Window primaryStage =imprimepage.getScene().getWindow();
 
 String s= txtdate.getText();
 Text sample = new Text(s);
            //Show save file dialog
            File file = fileChooser.showSaveDialog(primaryStage);
 
            if (file != null) {
                saveTextToFile(labeldate.getText(),txtdate.getText(),labelnomclient.getText(),txtnomclient.getText(),
                        labelprenomclient.getText(),txtprenomclient.getText(),
                       labelequipe.getText(), txtequipe.getText(),labeltype.getText(),
                       txttypeclient.getText(),labelresp.getText(),txtresp.getText(),labelcommerciaux.getText(),labelnomcomm.getText(),txtnomcomm.getText(),
                       labelprenomcomm.getText(), txtprenomcomm.getText(),labelnumordre.getText(),txtnumordre.getText(),file);
            }
        ;}
        
 
        
 
       
//        Window stage =imprimepage.getScene().getWindow();
//        filechooser.setTitle("save dialog");
//        filechooser.setInitialFileName("mysave");
//        filechooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("txt file ", " *.txt"),
//                new FileChooser.ExtensionFilter( "pdf", " *.pdf"));
//       //  new FileChooser.ExtensionFilter( "pdf", "*.pdf"));
//                 
//        try {
//            File file =filechooser.showSaveDialog(stage);
//            filechooser.setInitialDirectory(file.getParentFile());
//        }
//        catch(Exception ex){
//            
//        }
            
       
    
private void saveTextToFile(String content,String content1,String content2,String content3,String content4,String content5 ,
        String content6,String content7,String content8,String content9,String content10,String content11,String content12,
        String content13,String content14,String content15,String content16,String content17,String content18,File file) {
        try {
            PrintWriter writer;
            writer = new PrintWriter(file);
            writer.println(content);
            writer.println(content1);
            writer.println(content2);
            writer.println(content3);
            writer.println(content4);
            writer.println(content5);
            writer.println(content6);
            writer.println(content7);
            writer.println(content8);
             writer.println(content9);
              writer.println(content10);
               writer.println(content11);
                writer.println(content12);
                 writer.println(content13);
                  writer.println(content14);
                   writer.println(content15);
                   writer.println(content16);
                   writer.println(content17);
                   writer.println(content18);
            writer.close();
        } catch (IOException ex) {
            Logger.getLogger(FicheClientController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void btnsaveAction(ActionEvent event) throws ParseException {
        
        
     String S1 = txtdate.getText();
     SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
      Date datesaisie = format.parse(S1);
      int i=0;
       Historique  s = new Historique("","",txttypeclient.getText(), txtequipe.getText(), txtnomcomm.getText(),
               txtprenomcomm.getText(), txtresp.getText(), txtnumordre.getText(),datesaisie);
        equipe.insert(s);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
//        alert.initOwner(App.getPrimaryStage());
        alert.setTitle("Message Enregistrement");
//          alert.setHeaderText("No Person Selected");
        alert.setContentText("Les données sont bien Enregistrées");
        alert.showAndWait();
    }
     public void settext1(String nomClient, String prenomClient,String nom_equipe,String typeclient,String resp) {
        this.txtnomclient.setText(nomClient);
        this.txtprenomclient.setText(prenomClient);
       this.txtequipe.setText(nom_equipe);
         this.txttypeclient.setText(typeclient);
         this.txtresp.setText(resp);
//         this.nomcommerce.setCellValueFactory(new PropertyValueFactory<>(x.toString()));;
  //       tabcomm.getItems().addAll(x);
         
         
//        String affichage= txtequipe.getText();
//        
//            List liste = equipe.findlistCommerc(affichage);
//            
//            ObservableList<String> data = FXCollections.observableArrayList(liste);
//             System.out.println("listaa" +liste);
//            System.out.println(liste);
//           //  tabcommerc.setItems(data);
//              nomcommerce.setCellValueFactory(new PropertyValueFactory<Historique, String>("nomComm"));
//             prenomcommerce.setCellValueFactory(new PropertyValueFactory<Historique, String>("prenomComm"));
//             numordre.setCellValueFactory(new PropertyValueFactory<Historique, String>("numordre"));
//             tabcomm.getItems().addAll(data);
    
} 
public void initData(EquipeCommerciale person)
    {
        selectedeq = person;
//         nomcommerce.setCellValueFactory(new PropertyValueFactory<EquipeCommerciale, String>(selectedeq.getNom()));
//         prenomcommerce.setCellValueFactory(new PropertyValueFactory<EquipeCommerciale, String>(selectedeq.getPrenom()));
//          numordre.setCellValueFactory(new PropertyValueFactory<EquipeCommerciale, String>(selectedeq.getNumOrdre()));
//        
txtnomcomm.setText(selectedeq.getNom());
        txtprenomcomm.setText(selectedeq.getPrenom());
        txtnumordre.setText(selectedeq.getNumOrdre());
    }



}
