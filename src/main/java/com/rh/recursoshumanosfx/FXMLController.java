package com.rh.recursoshumanosfx;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class FXMLController implements Initializable {
    
 
    @FXML
    private AnchorPane anchorPanePrincipal;
    @FXML
    private Pane painelPrincipal;
    
    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {
 
 
 Pane painel = FXMLLoader.load(getClass().getResource("/fxml/FXMLFuncionario.fxml"));
//        AnchorPane a = (AnchorPane) FXMLLoader.load(getClass().getResource("/fxml/FXMLFuncionario.fxml"));
//        anchorPanePrincipal.getChildren().setAll(a);
painelPrincipal.getChildren().setAll(painel);
    
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
}
