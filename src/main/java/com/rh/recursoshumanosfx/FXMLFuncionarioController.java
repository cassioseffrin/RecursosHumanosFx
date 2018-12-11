 
package com.rh.recursoshumanosfx;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javax.swing.JOptionPane;
import model.EmpregadoAssalariado;
import model.dao.EmpregadoAssalariadoDAO;

/**
 * FXML Controller class
 *
 * @author cassioseffrin
 */
public class FXMLFuncionarioController implements Initializable {

   @FXML
    private TextField txtNome;
    @FXML
    private TextField txtCPF;
    @FXML
    private TextField txtEndereco;
    @FXML
    private AnchorPane anchorPaneFuncionario;
 
 
    @FXML
    public void handleSalvar(ActionEvent e) throws IOException {
        System.out.println("salvando cliente...");
 
                        
                        EmpregadoAssalariado ea = new EmpregadoAssalariado();
                        ea.setNome(txtNome.getText());
                        ea.setCpf(txtCPF.getText());
                        
                        EmpregadoAssalariadoDAO dao = new EmpregadoAssalariadoDAO();
                        if (dao.inserir(ea)==true){
                            System.out.println("Ok, salvou");
                            JOptionPane.showMessageDialog(null,  "Salvou com sucesso!");
                        }else {
                             JOptionPane.showMessageDialog(null,  "problema ao salvar!");
                        }
//        handlerTelaInicial(new ActionEvent());

    }

    @FXML
    public void handlerTelaInicial(ActionEvent e) throws IOException {
          
        AnchorPane a = (AnchorPane) FXMLLoader.load(getClass().getResource("/fxml/TelaInicial.fxml"));
        anchorPaneFuncionario.getChildren().setAll(a);
    }
    
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
