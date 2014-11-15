package automatopilha;

import java.util.ArrayList;
import java.util.Stack;

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
        RespostaUsuario respostausuario = new RespostaUsuario(estadofinal, logEstados);
        return respostausuario;
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
        ArrayList<Transicao> listaTransicoes = estado.estadoAtual.verificarCaminhosPossiveis(estado.palavraAtual.get(0), estado.pilhaAtual.get(estado.pilhaAtual.size()-1));
        while(!(listaTransicoes.isEmpty()) && estado.cadeiaAceita != true){
            EstadoAtual estadoQueSeraEnviado = new EstadoAtual(estado.estadoAtual, new ArrayList<String>(estado.pilhaAtual), new ArrayList<String>(estado.palavraAtual));
            Transicao proximaTransicao = listaTransicoes.remove(0);
            if(!proximaTransicao.letraInput.equals("&"))
                estado.palavraAtual.remove(0);
            if(!proximaTransicao.pilhaInput.equals("&"))
                
            estado = computarPalavra(estado);
        }
        return estado;
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
        return estado.pilhaAtual.isEmpty();
    }
    
    private boolean excedeuTempoMaximo(){
        long tempoAtual = System.currentTimeMillis();
        long delta = (tempoAtual - tempoInicio)/1000;
        return delta > requisicaoUsuario.tempoMaximo;
    }
}
