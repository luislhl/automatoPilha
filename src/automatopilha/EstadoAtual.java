package automatopilha;

import java.util.ArrayList;
import java.util.Stack;

public class EstadoAtual {
    Estado estadoAtual;
    ArrayList<String> pilhaAtual;
    ArrayList<String> palavraAtual;
    ArrayList<Log> logs;
    boolean cadeiaAceita = false;

    public EstadoAtual(Estado estadoAtual, ArrayList<String> pilhaAtual, ArrayList<String> palavraAtual) {
        this.estadoAtual = estadoAtual;
        this.pilhaAtual = pilhaAtual;
        this.palavraAtual = palavraAtual;
    }
    
    
    
}
