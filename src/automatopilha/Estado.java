/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package automatopilha;

import java.util.ArrayList;

/**
 *
 * @author helder
 */
public class Estado {
    String id;
    ArrayList<Transicao> transicoes;
    
    public Estado(String id){
        this.id = id;
        transicoes = new ArrayList<>();
    }
    
    public void addTransicao(String letraInput, String pilhaInput, String pilhaOutput, Estado destino){
        transicoes.add(new Transicao(letraInput, pilhaInput, pilhaOutput, destino));
    }
}

class Transicao{
    String letraInput;
    String pilhaInput;
    String pilhaOutput;
    Estado destino;    
    
    Transicao(String letraInput, String pilhaInput, String pilhaOutput, Estado destino){
        this.letraInput = letraInput;
        this.pilhaInput = pilhaInput;
        this.pilhaOutput = pilhaOutput;
        this.destino = destino;
    }
}
