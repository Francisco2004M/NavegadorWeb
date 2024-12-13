package edu.uagrm.fich.navegadorweb;

import java.io.IOException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public final class Historial {

    private Pila historialAtras = new Pila();
    private Pila historialAdelante = new Pila();
    private String actualURL = null;
    private final List<String> historialCompleto = new ArrayList<>();
    private static final String FILE_NAME = "historial.txt";

    public Historial() {
        this.actualURL = null;
        this.historialAdelante = new Pila();
        this.historialAtras = new Pila();
        cargarHistorial();
    }

    public void agregarBusqueda(String url) {
        if (actualURL != null) {
            historialAtras.push(actualURL);
        }
        actualURL = url;
        historialCompleto.add(url);
        historialAdelante.limpiar();
    }

    public List<String> obtenerHistorialCompleto() {
        return historialCompleto;
    }

    public String atras() {
        if (!historialAtras.vacia()) {
            historialAdelante.push(actualURL);
            actualURL = historialAtras.pop();
            return actualURL;
        }
        return null;
    }

    public String adelante() {
        if (!historialAdelante.vacia()) {
            historialAtras.push(actualURL);
            actualURL = historialAdelante.pop();
            return actualURL;
        }
        return null;
    }

    public void limpiarHistorial() {
        historialAtras = new Pila();
        historialAdelante = new Pila();
        historialCompleto.clear();
        actualURL = null;
    }

    public String[][] mostrarHistorial() {
        String[][] datos = new String[historialCompleto.size()][1];
        for (int i = 0; i < historialCompleto.size(); i++) {
            datos[i][0] = historialCompleto.get(i);
        }
        return datos;
    }

    public void guardarHistorial() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (String url : historialCompleto) {
                writer.write(url);
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void cargarHistorial() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String url;
            while ((url = reader.readLine()) != null) {
                historialCompleto.add(url);
                if (actualURL == null) {
                    actualURL = url;
                } else {
                    historialAtras.push(url);
                }
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
