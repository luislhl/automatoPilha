package automatopilha;

import java.util.ArrayList;
import java.util.Stack;

public class AutomatoPilha {
    ArrayList<String> alfabeto;
    ArrayList<Estado> estados;
    Estado estadoInicial;
    ArrayList<Estado> estadosFinais;
    ArrayList<String> alfabetoPilha;
    Stack<String> pilhaInicial;

    public AutomatoPilha(Estado estadoInicial) {
        pilhaInicial = new Stack<>();
        alfabeto = new ArrayList<>();
        alfabetoPilha = new ArrayList<>();
        estados = new ArrayList<>();
        estadosFinais = new ArrayList<>();
        this.estadoInicial = estadoInicial;
    }
    
    
}
