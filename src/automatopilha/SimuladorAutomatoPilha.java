package automatopilha;

import java.util.ArrayList;

public class SimuladorAutomatoPilha {
    AutomatoPilha ap;
    RequisicaoUsuario requisicaoUsuario;
    ArrayList<Estado> logEstados;
    long tempoInicio;

    public SimuladorAutomatoPilha(AutomatoPilha ap, RequisicaoUsuario requisicaoUsuario) {
        this.ap = ap;
        this.requisicaoUsuario = requisicaoUsuario;
    }
    
    public RespostaUsuario executarSimulacao(){
        this.tempoInicio = System.currentTimeMillis();
        EstadoAtual estadoatual = new EstadoAtual(ap.estadoInicial, ap.pilhaInicial, requisicaoUsuario.palavra);
        EstadoAtual estadofinal = computarPalavra(estadoatual);
    }
    
    public EstadoAtual computarPalavra(EstadoAtual estado){
        if(excedeuTempoMaximo()){
            estado.cadeiaAceita = false;
            return estado;
        }
        
        if(verificarCriterioParada(estado)){
            estado.cadeiaAceita = true;
            return estado;
        }
        
        // TODO Gravar estado
        ArrayList<Estado> listaEstados = verificarCaminhosPossiveis();
        while(!(listaEstados.isEmpty()) && estado.cadeiaAceita != true){
            estado = computarPalavra(estado);
        }
    }
    
    private boolean verificarCriterioParada(EstadoAtual estado){
        if (requisicaoUsuario.criterio == criterioParada.ESTADOFINAL){
            return verificarParadaEstadoFinal(estado);
        }
        else if (requisicaoUsuario.criterio == criterioParada.PILHAVAZIA){
            return verificarParadaPilhaVazia(estado);
        }
        else{
            throw new AssertionError("Nunca deveria entrar aqui");
        }
    }
    
    private boolean verificarParadaEstadoFinal(EstadoAtual estado){
        return ap.estadosFinais.contains(estado.estadoAtual);
    }
    
    private boolean verificarParadaPilhaVazia(EstadoAtual estado){
        return estado.pilhaAtual.empty();
    }
    
    private boolean excedeuTempoMaximo(){
        long tempoAtual = System.currentTimeMillis();
        long delta = (tempoAtual - tempoInicio)/1000;
        return delta > requisicaoUsuario.tempoMaximo;
    }
}
