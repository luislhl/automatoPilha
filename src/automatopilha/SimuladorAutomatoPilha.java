package automatopilha;

import java.util.ArrayList;
import java.util.Stack;

public class SimuladorAutomatoPilha {
    AutomatoPilha ap;
    RequisicaoUsuario requisicaoUsuario;
    ArrayList<Estado> logEstados = new ArrayList<Estado>();
    long tempoInicio;

    public SimuladorAutomatoPilha(AutomatoPilha ap, RequisicaoUsuario requisicaoUsuario) {
        this.ap = ap;
        this.requisicaoUsuario = requisicaoUsuario;
    }
    
    public RespostaUsuario executarSimulacao(){
        this.tempoInicio = System.currentTimeMillis();
        EstadoAtual estadoatual = new EstadoAtual(ap.estadoInicial, ap.pilhaInicial, requisicaoUsuario.palavra);
        EstadoAtual estadofinal = computarPalavra(estadoatual);
        System.out.println("Pilha no final:"+estadofinal.pilhaAtual.size());
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
        //System.out.println(estado.pilhaAtual.size());
        //System.out.println(estado.palavraAtual);
        //System.out.println(estado.estadoAtual);
        ArrayList<Transicao> listaTransicoes = estado.estadoAtual.verificarCaminhosPossiveis(estado.palavraAtual.get(0), estado.pilhaAtual.get(estado.pilhaAtual.size()-1));
        while(!(listaTransicoes.isEmpty()) && estado.cadeiaAceita != true){
            String letraRemovida = null;
            String pilhaRemovida = null;
            Transicao proximaTransicao = listaTransicoes.remove(0);
            if(!proximaTransicao.letraInput.equals("&")){
                letraRemovida = estado.palavraAtual.remove(0);
                if(!letraRemovida.equals(proximaTransicao.letraInput))
                    throw new AssertionError("Letra input diferente de letra lida. Não deveria... algo está errado na lógica");
            }
            if(!proximaTransicao.pilhaInput.equals("&")){
                pilhaRemovida = estado.pilhaAtual.remove(estado.pilhaAtual.size()-1);
                if(!pilhaRemovida.equals(proximaTransicao.pilhaInput))
                    throw new AssertionError("Pilha input diferente de letra lida. Não deveria... algo está errado na lógica");
            }
            boolean adicionouNaPilha = false;
            if(!proximaTransicao.pilhaOutput.equals("&"))
                adicionouNaPilha = true;
                estado.pilhaAtual.add(proximaTransicao.pilhaOutput);
            estado = computarPalavra(estado);
            if(letraRemovida!=null)
                estado.palavraAtual.add(0, letraRemovida);
            if(pilhaRemovida!=null&&estado.cadeiaAceita!=true)
                estado.pilhaAtual.add(pilhaRemovida);
            if(adicionouNaPilha&&estado.cadeiaAceita!=true)
                estado.pilhaAtual.remove(estado.pilhaAtual.size()-1);
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
//EstadoAtual estadoQueSeraEnviado = new EstadoAtual(estado.estadoAtual, new ArrayList<String>(estado.pilhaAtual), new ArrayList<String>(estado.palavraAtual));
         