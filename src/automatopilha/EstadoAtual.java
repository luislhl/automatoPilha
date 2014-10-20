package automatopilha;

import java.util.ArrayList;
import java.util.Stack;

public class EstadoAtual {
    Estado estadoAtual;
    Stack<String> pilhaAtual;
    String palavraAtual;
    ArrayList<Log> logs;
    boolean cadeiaAceita = false;

    public EstadoAtual(Estado estadoAtual, Stack<String> pilhaAtual, String palavraAtual) {
        this.estadoAtual = estadoAtual;
        this.pilhaAtual = pilhaAtual;
        this.palavraAtual = palavraAtual;
    }
    
    
    
}
