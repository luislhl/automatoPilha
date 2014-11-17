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
public class RespostaUsuario {
    
    Boolean cadeiaAceita;
    ArrayList<Estado> caminhoAceito = new ArrayList<Estado>();
    ArrayList<Estado> logEstados;
    
    public RespostaUsuario(EstadoAtual estadofinal, ArrayList<Estado> logEstados){
        this.logEstados = logEstados;
        this.cadeiaAceita = estadofinal.cadeiaAceita;
        /*for (Log log: estadofinal.logs){
            caminhoAceito.add(log.estado);
        }*/
    }
}
