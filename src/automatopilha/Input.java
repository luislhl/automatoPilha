/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package automatopilha;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author helder
 */
public class Input {
    String alfabeto;
    String estados;
    String funcaoPrograma;
    String estadoInicial;
    String estadosFinais;
    String alfabetoPilha;
    String simboloInicialPilha;
    
    public AutomatoPilha criarAP(){
        AutomatoPilha automato = new AutomatoPilha();
        automato.alfabeto = processaAlfabeto();
        
        return automato;
    }
    
    private ArrayList<String> processaAlfabeto(){
        ArrayList<String> alfabeto_retorno = new ArrayList<>();
        
        String alfabeto = this.alfabeto.replace(" ", "");
        alfabeto = alfabeto.split("=")[1];
        String[] simbolos = alfabeto.split(",");
        alfabeto_retorno.addAll(Arrays.asList(simbolos));
        
        return alfabeto_retorno;
    }
    
}
