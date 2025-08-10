package trabalho;

import java.util.Scanner;

public class Desafio {
    public static void main(String[] args) {
        Scanner leia = new Scanner(System.in);

        System.err.println("Bem vindo ao jogo Torre de Hanoi!\nSeu objetivo é mover as peças da torre 1 para a torre 3.\nBoa sorte!");

        System.out.println("Informe o tamanho da torre: ");
        int tamanhoTorre = leia.nextInt();

        int torre1[] = new int[tamanhoTorre + 1];
        int torre2[] = new int[tamanhoTorre + 1];
        int torre3[] = new int[tamanhoTorre + 1];
        
        System.out.println();

        // Atribuirá valores da torre1 de acordo com o tamanho
        for (int i = 0; i < torre1.length; i++){
            torre1[i] = i;
        }

        int pecaEscolhida = 0;

        int torreAtual = 0;
        int vetorTA[] = new int[tamanhoTorre + 1];

        int torreDestino = 0;

        int[][] resultadoFinalJogada;

        // looping principal
        while (true) {
            
            mostraVetor(torre1, torre2, torre3);
            
            if (verificaVitoria(torre3) == true){

                System.out.println("Parabens, você venceu o jogo!!!");
                break;
            }


            System.out.println("Faça sua jogada!");
            System.out.println();

            // verifica se a peça existe
            while (true) {
              
                System.out.println("Escolha a peça que deseja mover:");
                for (int p = 1; p <= tamanhoTorre; p++){
                    
                    System.out.printf("peça %d\n", p);
                }

                pecaEscolhida = leia.nextInt();
                System.out.println();
                System.out.println();

                if (pecaEscolhida > tamanhoTorre || pecaEscolhida <= 0) {
                    
                    System.out.println("Essa peça não existe!");
                    System.out.println();
                    System.out.println();
                } else{
                    break;
                }
            }

            // identifica automaticamente a torre atual da peça escolhida
            torreAtual = encontrarTorreDaPeca(pecaEscolhida, torre1, torre2, torre3);

            if (torreAtual == -1) {
                
                System.out.println("A peça não está em nenhuma torre!");
                System.out.println();
                continue;
            }

            switch (torreAtual) {
                case 1:
                    for (int i = 0; i < torre1.length; i++) {
                        vetorTA[i] = torre1[i];
                    }
                    break;
                case 2:
                    for (int i = 0; i < torre2.length; i++) {
                        vetorTA[i] = torre2[i];
                    }
                    break;
                case 3:
                    for (int i = 0; i < torre3.length; i++) {
                        vetorTA[i] = torre3[i];
                    }
                    break;
            }

            // verifica se a torre existe
            while (true) {
                
                System.out.println("Escolha o torre que deseja mover a peça:\n1\n2\n3");
                System.out.println();
                System.out.println();
                
                torreDestino = leia.nextInt();
                System.out.println();
                System.out.println();

                switch (torreDestino) {
                    case 1:
                        resultadoFinalJogada = jogada(pecaEscolhida, vetorTA, torre1);
                        break;
                    case 2:
                        resultadoFinalJogada = jogada(pecaEscolhida, vetorTA, torre2);
                        break;
                    case 3:
                        resultadoFinalJogada = jogada(pecaEscolhida, vetorTA, torre3);
                        break;
                    default:
                        System.out.println("Essa torre não existe!");
                        System.out.println();
                        System.out.println();
                        continue;
                }

                break;
            }

            // atribuindo o resultado da função jogada para as torres
            switch (torreAtual) {
                case 1:
                    torre1 = resultadoFinalJogada[0];
                    break;
                
                case 2:
                    torre2 = resultadoFinalJogada[0];
                    break;

                case 3:
                    torre3 = resultadoFinalJogada[0];
                    break;
            }

            
            switch (torreDestino) {
                case 1:
                    torre1 = resultadoFinalJogada[1];
                    break;
                
                case 2:
                    torre2 = resultadoFinalJogada[1];
                    break;

                case 3:
                    torre3 = resultadoFinalJogada[1];
                    break;
            }

        }
        
    }

    // função que mostra os vetores
    public static void mostraVetor(int[] t1, int[] t2, int[] t3) {
        
        for(int i = 0; i < t1.length; i++){
            
            System.out.print(t1[i] + "      ");
            System.out.print(t2[i] + "      ");
            System.out.print(t3[i] + "      ");
            System.out.println();
        }
    }

    //função que faz a jogada
    public static int[][] jogada(int valor, int[] torreOrigem, int[] torreDestino) {

        // cópia dos vetores de origem e destino
        int[] tAtual = new int[torreOrigem.length];
        
        for (int i = 0; i < torreOrigem.length; i++) {
            
            tAtual[i] = torreOrigem[i];
        }

        
        int[] tDestino = new int[torreDestino.length];
        
        for (int i = 0; i < torreDestino.length; i++) {
            
            tDestino[i] = torreDestino[i];
        }

        
        // tirada da peça da torre atual
        for (int i = 0; i < tAtual.length; i++){
            
            if (valor == tAtual[i] && (i == 0 || tAtual[i-1] == 0)){  
                
                tAtual[i] = 0;
                break;
            }
        }

        // adição da peça na torre destino
        for (int i = tDestino.length - 1; i >= 0; i--){

            if (i < tDestino.length - 1 && tDestino[i + 1] == 0){

                tDestino[i+1] = valor;
                break;
            }
        }
        
        return new int[][] {tAtual, tDestino};
    }

    // função para encontrar a torre que contém a peça
    public static int encontrarTorreDaPeca(int peca, int[] t1, int[] t2, int[] t3) {
        
        for (int i = 0; i < t1.length; i++) {
            
            if (t1[i] == peca) {
                return 1;
            }
        }

        for (int i = 0; i < t2.length; i++) {
            
            if (t2[i] == peca) {
                return 2;
            }
        }

        for (int i = 0; i < t3.length; i++) {
            
            if (t3[i] == peca) {
                return 3;
            }
        }

        return -1;
    }

    // // função que verifica a vitória
    public static boolean verificaVitoria(int[] t3) {
        
        boolean verificador = true;

        for (int i = 0; i < t3.length; i++){
            
            if (i != t3[i]){

                verificador = false;
            }
        }

        return verificador;
    }
}
