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
    
    public ArrayList<Transicao> verificarCaminhosPossiveis(String letra, String simboloPilha){
        ArrayList<Transicao> transicoesPossiveis = new ArrayList<Transicao>();
        for(Transicao transicao : transicoes){
            if((transicao.letraInput.equals(letra)||transicao.letraInput.equals("&"))&&
                    transicao.pilhaInput.equals(simboloPilha)||transicao.pilhaInput.equals("&"))
                transicoesPossiveis.add(transicao);
        }
        return transicoesPossiveis;
    }
}
