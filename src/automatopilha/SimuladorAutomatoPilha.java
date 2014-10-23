package automatopilha;

import java.util.ArrayList;
//Linha comentada
//Linha comentada 2
public class SimuladorAutomatoPilha {
    AutomatoPilha ap;
    RequisicaoUsuario requisicaoUsuario;
    ArrayList<Estado> logEstados;

    public SimuladorAutomatoPilha(AutomatoPilha ap, RequisicaoUsuario requisicaoUsuario) {
        this.ap = ap;
        this.requisicaoUsuario = requisicaoUsuario;
    }
    
    public RespostaUsuario executarSimulacao(){
        EstadoAtual estadoatual = new EstadoAtual(ap.estadoInicial, ap.pilhaInicial, requisicaoUsuario.palavra);
        EstadoAtual estadofinal = computarPalavra(estadoatual);
    }
    
    public EstadoAtual computarPalavra(EstadoAtual estado){
        if(verificarCriterioParada()){
            estado.cadeiaAceita = true;
            return estado;
        }
        
        if(verificarLoop()){
            return estado;
        }
        
        // TODO Gravar estado
        ArrayList<Estado> listaEstados = verificarCaminhosPossiveis();
        while(!(listaEstados.isEmpty()) && estado.cadeiaAceita != true){
            estado = computarPalavra(estado);
        }
    }
}
