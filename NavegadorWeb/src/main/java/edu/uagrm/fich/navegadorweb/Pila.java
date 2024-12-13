package edu.uagrm.fich.navegadorweb;

import java.io.Serializable;

public class Pila implements Serializable {

    private static final long serialVersionUID = 1L;
    public static final int MAX = 50;
    private String V[];
    private int cima;

    public Pila() {
        V = new String[MAX + 1];
        cima = -1;
    }

    public boolean vacia() {
        return (cima == -1);
    }

    public boolean llena() {
        return (cima == MAX);
    }

    public void push(String x) {
        if (llena()) {
            throw new ArrayStoreException("Error: Pila llena");
        }
        cima++;
        V[cima] = x;
    }

    public String pop() {
        if (vacia()) {
            throw new NegativeArraySizeException("Error: Pila vacía");
        }
        String x = V[cima];
        cima--;
        return x;
    }

    public int cant() {
        return cima + 1;
    }

    public String tope() {
        if (vacia()) {
            throw new NegativeArraySizeException("Error: Pila vacía");
        }
        return V[cima];
    }

    public void limpiar() {
        cima = -1;
    }

    @Override
    public String toString() {
        String cad = "Pila\n[";
        for (int i = cima; i >= 0; i--) {
            cad += V[i] + ",\n";
        }
        cad += "]";
        return cad;
    }
}
