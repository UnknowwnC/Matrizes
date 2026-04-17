/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package matdisper;

/**
 *
 * @author Me
 */
public class Nodo {
    //Atributos
    private int Fila, Col, Dato;
    private Nodo Liga, Lf, Lc;
    
    //Constructor

    public Nodo(int Fila, int Col, int Dato) {
        this.Fila = Fila;
        this.Col = Col;
        this.Dato = Dato;
        this.Liga = null;
        this.Lf = null;
        this.Lc = null;
    }

    public int getFila() {
        return Fila;
    }

    public void setFila(int Fila) {
        this.Fila = Fila;
    }

    public int getCol() {
        return Col;
    }

    public void setCol(int Col) {
        this.Col = Col;
    }

    public int getDato() {
        return Dato;
    }

    public void setDato(int Dato) {
        this.Dato = Dato;
    }

    public Nodo getLiga() {
        return Liga;
    }

    public void setLiga(Nodo Liga) {
        this.Liga = Liga;
    }

    public Nodo getLf() {
        return Lf;
    }

    public void setLf(Nodo Lf) {
        this.Lf = Lf;
    }

    public Nodo getLc() {
        return Lc;
    }

    public void setLc(Nodo Lc) {
        this.Lc = Lc;
    }
    
    
}