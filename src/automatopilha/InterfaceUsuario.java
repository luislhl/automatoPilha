package automatopilha;

import java.io.File;

public class InterfaceUsuario {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        AutomatoPilha ap = criarAP();
        RequisicaoUsuario requisicaousuario = criarRequisicao();
        SimuladorAutomatoPilha simulador = new SimuladorAutomatoPilha(ap, requisicaousuario);
        RespostaUsuario resposta = simulador.executarSimulacao();
        interpretaResposta(resposta);
    }
    
    public static void lerInput(){
        File f = new File("input");
    }
    
    public static AutomatoPilha criarAP(){
        
    }
    
    public static RequisicaoUsuario criarRequisicao(){
        
    }
    
    public static void interpretaResposta(RespostaUsuario resposta){
        
    }
    
}
