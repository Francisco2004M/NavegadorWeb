package edu.uagrm.fich.navegadorweb;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

/**
 *
 * @author Francisco
 */
public class InterfazGrafica extends VBox {

    private TextField txtBuscador = new TextField();
    private Button btnBuscar = new Button("Buscar");
    private Button btnAtras = new Button();
    private Button btnAdelante = new Button();
    private HBox boxBuscar = new HBox(5, txtBuscador, btnBuscar, btnAtras, btnAdelante);

    private WebView webView = new WebView();
    WebEngine webEngine = webView.getEngine();

    public InterfazGrafica() {
        super(10);
        getChildren().addAll(boxBuscar, webView);
        configurarPresentacion();
        configurarAcciones();
    }

    private void configurarPresentacion() {
        setPadding(new Insets(15));
        txtBuscador.setMaxWidth(Double.MAX_VALUE);
        HBox.setHgrow(txtBuscador, Priority.ALWAYS);
        agregarIconos();
    }

    private void agregarIconos() {
        FontAwesomeIconView buscarIcon = new FontAwesomeIconView(FontAwesomeIcon.SEARCH);
        FontAwesomeIconView atrasIcon = new FontAwesomeIconView(FontAwesomeIcon.ARROW_LEFT);
        FontAwesomeIconView adelanteIcon = new FontAwesomeIconView(FontAwesomeIcon.ARROW_RIGHT);

        buscarIcon.setSize("16px");
        atrasIcon.setSize("16px");
        adelanteIcon.setSize("16px");

        btnBuscar.setGraphic(buscarIcon);
        btnBuscar.setTooltip(new Tooltip("Buscar página indicada en la barra de busqueda"));
        btnAtras.setGraphic(atrasIcon);
        btnAtras.setTooltip(new Tooltip("Ir a la página anterior en el Historial"));
        btnAdelante.setGraphic(adelanteIcon);
        btnAdelante.setTooltip(new Tooltip("Ir a la siguiente Página en el Historial"));
    }

    private void configurarAcciones() {
        btnBuscar.setOnAction((evt) -> buscar(txtBuscador.getText()));
        txtBuscador.setOnKeyPressed(evt -> {
            if (evt.getCode() == KeyCode.ENTER) {
                buscar(txtBuscador.getText());
            }
        });
    }

    private void buscar(String consulta) {
        if (consulta.toLowerCase().contains("http") || consulta.toLowerCase().contains("ftp")) {
            webEngine.load(consulta.replace(" ", "+"));
        } else {
            webEngine.load("https://www.google.com/search?q=" + consulta);
        }
    }
}
