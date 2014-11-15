package automatopilha;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class InterfaceUsuario {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Input input = lerInput();
        AutomatoPilha ap = input.criarAP();
        RequisicaoUsuario requisicaousuario = criarRequisicao();
        SimuladorAutomatoPilha simulador = new SimuladorAutomatoPilha(ap, requisicaousuario);
        RespostaUsuario resposta = simulador.executarSimulacao();
        interpretaResposta(resposta);
    }
    
    public static Input lerInput(){
        File f = new File("input");
        Input input = new Input();
        try {
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            
            input.alfabeto = br.readLine();
            input.estados = br.readLine();
            input.funcaoPrograma = br.readLine();
            input.estadoInicial = br.readLine();
            input.estadosFinais = br.readLine();
            input.alfabetoPilha = br.readLine();
            input.simboloInicialPilha = br.readLine();
            
            br.close();
        } catch (IOException ex) {
            Logger.getLogger(InterfaceUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return input;
    }
    
    public static RequisicaoUsuario criarRequisicao(){
        Scanner in = new Scanner(System.in);
        RequisicaoUsuario req = new RequisicaoUsuario();
        
        System.out.println("Entre com a palavra a ser computada, com os simbolos separados por espaço:\n");
        String palavra = in.nextLine();
        String[] simbolos = palavra.split(" ");
        req.palavra = new ArrayList();
        req.palavra.addAll(Arrays.asList(simbolos));
        System.out.println("Entre com o tempo máximo de computação:\n");
        req.tempoMaximo = in.nextInt();
        System.out.println("Escolha um critério de parada:\n1- Estado Final\n2- Pilha Vazia\n");
        int parada = in.nextInt();
        
        if(parada == 1) req.setCriterioEstadoFinal();
        else if(parada == 2) req.setCriterioPilhaVazia();
        else    throw new AssertionError("Opção inválida para o critério de parada");
        
        return req;
    }
    
    public static void interpretaResposta(RespostaUsuario resposta){
        if(resposta.cadeiaAceita){
            System.out.println("Cadeia Aceita");
            imprimirLogdeCaminhos(resposta.caminhoAceito);
        }
        else
            System.out.println("Cadeia rejeitada");
        imprimirLogdeCaminhos(resposta.logEstados);
    }
    
    public static void imprimirLogdeCaminhos(ArrayList<Estado> caminho){
        for (Estado estado : caminho){
            System.out.print(estado.id);
        }
    }
}
