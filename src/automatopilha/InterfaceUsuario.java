package automatopilha;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class InterfaceUsuario {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Input input = lerInput();
        AutomatoPilha ap = input.criarAP();
        RequisicaoUsuario requisicaousuario = criarRequisicao();
        SimuladorAutomatoPilha simulador = new SimuladorAutomatoPilha(ap, requisicaousuario);
        RespostaUsuario resposta = simulador.executarSimulacao();
        interpretaResposta(resposta);
    }
    
    public static Input lerInput(){
        File f = new File("input");
        Input input = new Input();
        try {
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            
            input.alfabeto = br.readLine();
            input.estados = br.readLine();
            input.funcaoPrograma = br.readLine();
            input.estadoInicial = br.readLine();
            input.estadosFinais = br.readLine();
            input.alfabetoPilha = br.readLine();
            input.simboloInicialPilha = br.readLine();
            
            br.close();
        } catch (IOException ex) {
            Logger.getLogger(InterfaceUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return input;
    }
    
    public static RequisicaoUsuario criarRequisicao(){
        
    }
    
    public static void interpretaResposta(RespostaUsuario resposta){
        
    }
    
}
