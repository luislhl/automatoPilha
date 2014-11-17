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
        automato.estadosFinais = processaEstadosFinais(automato);
        automato.estadoInicial = processaEstadoInicial(automato);
        
        return automato;
    }
    
    private Estado processaEstadoInicial(AutomatoPilha automato){
        String estado = estadoInicial.split("=")[1].replace(" ", "");
        return automato.estados.get(estado);
    }
    
    private ArrayList<Estado> processaEstadosFinais(AutomatoPilha automato){
        ArrayList<Estado> estadosfinais = new ArrayList<>();
        String[] estados = estadosFinais.split(",");
        for(String s : estados){
            estadosfinais.add(automato.estados.get(s.replace(" ", "")));
        }
        return estadosfinais;
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
        String[] transicoes = funcao.split(";");
        for (String transicao : transicoes){
            processaTransicao(transicao, automato);
        }
    }
    
    private void processaTransicao(String transicao, AutomatoPilha automato){
        System.out.println(transicao);
        String[] lados = transicao.split("->");
        String[] simbolos_esquerda = lados[0].split(",");
        String[] simbolos_direita = lados[1].split(",");
        
        Estado estado_origem = automato.estados.get(simbolos_esquerda[0]);
        Estado estado_destino = automato.estados.get(simbolos_direita[0]);
        
        Transicao transi = new Transicao(simbolos_esquerda[1], simbolos_esquerda[2], simbolos_direita[1], estado_destino);
        estado_origem.transicoes.add(transi);
        
    }
    
}
