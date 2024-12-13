package edu.uagrm.fich.navegadorweb;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    private Stage stage;
    private final Image icon = new Image("/images/icono.png");

    @Override
    public void start(Stage stage) {
        this.stage = stage;
        InterfazGrafica interfazGrafica = new InterfazGrafica();
        interfazGrafica.mostrarDialogoHistorial(evt -> mostrarDialogoHistorial());
        Scene scene = new Scene(interfazGrafica, 640, 480);
        stage.setTitle("Navegador Web UAGRM-FICH");
        stage.setScene(scene);
        stage.getIcons().add(icon);
        stage.setMaximized(true);
        stage.show();
    }

    private void mostrarDialogoHistorial() {
        Stage dialog = new Stage();
        dialog.setTitle("Historial de Navegacion");
        dialog.getIcons().add(icon);
        dialog.initOwner(stage);
        dialog.initModality(Modality.APPLICATION_MODAL);
        dialog.showAndWait();
    }

    public static void main(String[] args) {
        launch();
    }

}
