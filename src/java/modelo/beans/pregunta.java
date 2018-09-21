/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.beans;

import java.awt.List;
import java.util.ArrayList;

/**
 *
 * @author sebastian
 */
public class pregunta {
    int id;
    int orden;
    String enunciado;
    int tipo;
    ArrayList<respuesta> lista = new ArrayList<>();
    pregunta(String penunciado,int pid,int porden){
        id=pid;
        orden=porden;
        enunciado=penunciado;
        tipo=1;
    }
    
    pregunta(String penunciado,int pid,int porden,int tipo){
        id=pid;
        orden=porden;
        enunciado=penunciado;
        this.tipo=tipo;
    }
}
