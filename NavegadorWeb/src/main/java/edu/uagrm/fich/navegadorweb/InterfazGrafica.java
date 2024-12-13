package edu.uagrm.fich.navegadorweb;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebView;

/**
 *
 * @author Francisco
 */
public class InterfazGrafica extends VBox{
    
    private TextField txtBuscador = new TextField();
    private Button btnBuscar = new Button("Buscar");
    private Button btnAtras = new Button("Atras");
    private Button btnAdelante = new Button("Adelante");
    private HBox boxBuscar = new HBox(5, txtBuscador, btnBuscar, btnAtras, btnAdelante);

    
    private WebView webView = new WebView();
        
    public InterfazGrafica(){
        super(10);        
        getChildren().addAll(boxBuscar, webView);
        configurarPresentacion();
    }

    private void configurarPresentacion() {
        setPadding(new Insets(15));
        txtBuscador.setMaxWidth(Double.MAX_VALUE);
        HBox.setHgrow(txtBuscador, Priority.ALWAYS);
        
    }
}
