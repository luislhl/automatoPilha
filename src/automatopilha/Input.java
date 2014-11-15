package automatopilha;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Input {
    String alfabeto;
    String estados;
    String funcaoPrograma;
    String estadoInicial;
    String estadosFinais;
    String alfabetoPilha;
    String simboloInicialPilha;
    
    public AutomatoPilha criarAP(){
        AutomatoPilha automato = new AutomatoPilha();
        automato.alfabeto = processaAlfabeto(alfabeto);
        automato.estados = processaEstados();
        processaFuncaoPrograma(automato);
        automato.alfabetoPilha = processaAlfabeto(alfabetoPilha);
        automato.pilhaInicial = processaPilhaInicial();
        
        return automato;
    }
    
    private ArrayList<String> processaPilhaInicial(){
        ArrayList<String> pilhaInicial = new ArrayList<>();
        pilhaInicial.add(simboloInicialPilha);
        
        return pilhaInicial;
    }
     
    private ArrayList<String> processaAlfabeto(String alf){
        ArrayList<String> alfabeto_retorno = new ArrayList<>();
        
        String alfabeto = alf.replace(" ", "");
        alfabeto = alfabeto.split("=")[1];
        String[] simbolos = alfabeto.split(",");
        alfabeto_retorno.addAll(Arrays.asList(simbolos));
        
        return alfabeto_retorno;
    }
    
    private Map<String, Estado> processaEstados(){
        Map<String, Estado> estados_list = new HashMap<>();
        
        String estados = this.estados.replace(" ", "");
        estados = estados.split("=")[1];
        String[] estados_array = estados.split(",");
        for(String est : estados_array){
            estados_list.put(est, new Estado(est));
        }
        
        return estados_list;
    }
    
    private void processaFuncaoPrograma(AutomatoPilha automato){
        String funcao = this.funcaoPrograma.replace(" ", "");
        funcao = funcao.split("=")[1];
        String[] transicoes = funcao.split(",");
        for (String transicao : transicoes){
            processaTransicao(transicao, automato);
        }
    }
    
    private void processaTransicao(String transicao, AutomatoPilha automato){
        String[] lados = transicao.split("->");
        String[] simbolos_esquerda = lados[0].split(",");
        String[] simbolos_direita = lados[1].split(",");
        
        Estado estado_origem = automato.estados.get(simbolos_direita[0]);
        Estado estado_destino = automato.estados.get(simbolos_esquerda[1]);
        
        Transicao transi = new Transicao(simbolos_direita[1], simbolos_direita[2], simbolos_esquerda[0], estado_destino);
        estado_origem.transicoes.add(transi);
        
    }
    
}
