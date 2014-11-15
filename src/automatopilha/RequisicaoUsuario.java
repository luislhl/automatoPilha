package automatopilha;

import java.util.ArrayList;

enum criterioParada {
    ESTADOFINAL, PILHAVAZIA;
}

public class RequisicaoUsuario { 
    ArrayList<String> palavra;
    int tempoMaximo;
    criterioParada criterio;
    
    public void setCriterioEstadoFinal(){
        this.criterio = criterioParada.ESTADOFINAL;
    }
    
    public void setCriterioPilhaVazia(){
        this.criterio = criterioParada.PILHAVAZIA;
    }
}
