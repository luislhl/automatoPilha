package automatopilha;

enum criterioParada {
    ESTADOFINAL, PILHAVAZIA;
}

public class RequisicaoUsuario { 
    String palavra;
    int tempoMaximo;
    criterioParada criterio;
    
    public void setCriterioEstadoFinal(){
        this.criterio = criterioParada.ESTADOFINAL;
    }
    
    public void setCriterioPilhaVazia(){
        this.criterio = criterioParada.PILHAVAZIA;
    }
}
