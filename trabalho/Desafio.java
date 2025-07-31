package trabalho;

import java.util.Scanner;

public class Desafio {
    public static void main(String[] args) {
        Scanner leia = new Scanner(System.in);

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

        while (true) {
            
            mostraVetor(torre1, torre2, torre3);

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
            if (torreAtual == 1) {
                torre1 = resultadoFinalJogada[0];
            
            } else if (torreAtual == 2) {
                torre2 = resultadoFinalJogada[0];
            
            } else if (torreAtual == 3) {
                torre3 = resultadoFinalJogada[0];
            }

            
            if (torreDestino == 1) {
                torre1 = resultadoFinalJogada[1];
            
            } else if (torreDestino == 2) {
                torre2 = resultadoFinalJogada[1];
            
            } else if (torreDestino == 3) {
                torre3 = resultadoFinalJogada[1];
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
    public static int[][] jogada(int valor, int[] tAtual, int[] tDestino) {

        // tirada da peça da torre atual
        for (int i = 0; i < tAtual.length; i++){
            
            if (valor == tAtual[i] && (i == 0 || tAtual[i-1] == 0)){  // corrigi para evitar index negativo
                
                tAtual[i] = 0;
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
}
