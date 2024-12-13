package edu.uagrm.fich.navegadorweb;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        InterfazGrafica interfazGrafica = new InterfazGrafica();
        Scene scene = new Scene(interfazGrafica, 640, 480);
        stage.setTitle("Navegador Web UAGRM-FICH");
        stage.setScene(scene);
        Image image = new Image("/images/icono.png");
        stage.getIcons().add(image);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}
