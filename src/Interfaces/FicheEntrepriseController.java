/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import DAO.HistoriqueDAO;
import Entites.EquipeCommerciale;
import Entites.Historique;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Window;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class FicheEntrepriseController implements Initializable {

    @FXML
    private AnchorPane imprimepage;
    @FXML
    private TextField txtequipe;
    @FXML
    private TextField txttypeclient;
    @FXML
    private TextField txtraison1;
    @FXML
    private TextField txtdate1;
    @FXML
    private Button btnimprimer1;
    @FXML
    private Button btnsave1;
    @FXML
    private TextField txtresp;
    @FXML
    private TextArea txtnomcomm1;
    @FXML
    private TextArea txtprenomcomm1;
    @FXML
    private TextArea txtnumordre1;
        FileChooser fileChooser= new FileChooser();
  private EquipeCommerciale selectedeq;
  HistoriqueDAO equipe= new HistoriqueDAO();
    @FXML
    private Label labelraison;
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
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
       //  filechooser.setInitialDirectory(new File("C:\\Users\\HP\\Desktop\\historique"));
    }    

    @FXML
    private void btnimprimerAction(ActionEvent event) {
         FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
            fileChooser.getExtensionFilters().add(extFilter);
        Window primaryStage =imprimepage.getScene().getWindow();
 
 String s= txtdate1.getText();
 Text sample = new Text(s);
            //Show save file dialog
            File file = fileChooser.showSaveDialog(primaryStage);
 
            if (file != null) {
                saveTextToFile(labeldate.getText(),txtdate1.getText(),labelraison.getText(),txtraison1.getText(),
                        labelequipe.getText(),txtequipe.getText(),
                       labeltype.getText(), txttypeclient.getText(),labelresp.getText(),
                       txtresp.getText(),labelresp.getText(),txtresp.getText(),labelcommerciaux.getText(),
                       labelnomcomm.getText(),
                        txtnomcomm1.getText(),labelprenomcomm.getText(),
                        txtprenomcomm1.getText(),labelnumordre.getText(),txtnumordre1.getText(),file);
            }
        ;
        
        
        
        
        
//          Window stage =imprimepage.getScene().getWindow();
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
    }
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
        String S1 = txtdate1.getText();
     SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
      Date datesaisie = format.parse(S1);
      int i=0;
       Historique  s = new Historique(txtraison1.getText(),"",txttypeclient.getText(), txtequipe.getText(), txtnomcomm1.getText(),
               txtprenomcomm1.getText(), txtresp.getText(), txtnumordre1.getText(),datesaisie);
        equipe.insert(s);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
//        alert.initOwner(App.getPrimaryStage());
        alert.setTitle("Message Enregistrement");
//          alert.setHeaderText("No Person Selected");
        alert.setContentText("Les données sont bien Enregistrées");
        alert.showAndWait();
    }
    
   

    void settext1(String raison, String nom_equipe, String typeclient, String resp) {
        this.txtraison1.setText(raison);
        this.txtequipe.setText(nom_equipe);
      
         this.txttypeclient.setText(typeclient);
         this.txtresp.setText(resp);
        }

    void initData(EquipeCommerciale equipeCommerciale) {
         selectedeq = equipeCommerciale;      
txtnomcomm1.setText(selectedeq.getNom());
        txtprenomcomm1.setText(selectedeq.getPrenom());
        txtnumordre1.setText(selectedeq.getNumOrdre());
         }
    
}
