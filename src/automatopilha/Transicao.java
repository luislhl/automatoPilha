/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package automatopilha;

/**
 *
 * @author helder
 */
public class Transicao{
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
