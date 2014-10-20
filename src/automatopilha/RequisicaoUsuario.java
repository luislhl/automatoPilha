package automatopilha;

enum criterioParada {
    ESTADOFINAL, PILHAVAZIA;
}

public class RequisicaoUsuario { 
    String palavra;
    int tempoMaximo;
    criterioParada criterio;
}
