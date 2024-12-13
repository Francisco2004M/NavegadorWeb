package edu.uagrm.fich.navegadorweb;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 * JavaFX App
 */
public class App extends Application {

    private Stage stage;
    private final Image icon = new Image("/images/icono.png");
    private final Historial historial = new Historial();

    @Override
    public void start(Stage stage) {
        this.stage = stage;
        InterfazGrafica interfazGrafica = new InterfazGrafica(historial);
        interfazGrafica.mostrarDialogoHistorial((evt) -> mostrarDialogoHistorial());
        Scene scene = new Scene(interfazGrafica, 640, 480);
        stage.setTitle("Navegador Web UAGRM-FICH");
        stage.setScene(scene);
        stage.getIcons().add(icon);
        stage.setMaximized(true);
        stage.show();        

        stage.setOnCloseRequest((WindowEvent event) -> {
            historial.guardarHistorial();
        });
    }

    private void mostrarDialogoHistorial() {
        Stage dialog = new Stage();
        dialog.setTitle("Historial de Navegacion");
        dialog.getIcons().add(icon);        
        dialog.initOwner(stage);
        
        ListView<String> listView = new ListView<>(); 
        listView.getItems().addAll(historial.obtenerHistorialCompleto());
        
        Scene scene = new Scene(new StackPane(listView), 640, 480);
        dialog.setScene(scene);
        dialog.initModality(Modality.APPLICATION_MODAL);
        dialog.showAndWait();
    }

    public static void main(String[] args) {
        launch();
    }

}
