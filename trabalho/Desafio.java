package trabalho;

import java.util.Scanner;

public class Desafio {
    public static void main(String[] args) {
        Scanner leia = new Scanner(System.in);

        System.out.println("Informe o tamanho da torre: ");
        int tamanhoTorre = leia.nextInt();

        int torre1[] = new int[tamanhoTorre];
        int torre2[] = new int[tamanhoTorre];
        int torre3[] = new int[tamanhoTorre];
        
        System.out.println();

        // Atribuirá valores da torre1 de acordo com o tamanho
        for (int i = 0; i < torre1.length; i++){
            torre1[i] = i+1;
        }

        int pecaEscolhida = 0;
        int torreAtual = 0;
        int torreDestino = 0;

        while (true) {
            
            mostraVetor(torre1, torre2, torre3);

            System.out.println("Faça sua jogada!");

            // verifica se a peça existe
            while (true) {
              
                System.out.println("Escolha a peça que deseja mover:");
                for (int p = 1; p <= tamanhoTorre; p++){
                    System.out.printf("peça %d\n", p);
                }

                pecaEscolhida = leia.nextInt();

                if (pecaEscolhida > tamanhoTorre || pecaEscolhida <= 0) {
                    System.out.println("Essa peça não existe!");
                } else{
                    break;
                }
            }

            // verifica se a peça está na torre atual
            while (true) {
                boolean estaNaTorre = false;
                
                System.out.println("Informe a torre em que se encontra esta peça");
                torreAtual = leia.nextInt();

                switch (torreAtual) {
                    case 1:
                        for (int i = 0; i < torre1.length; i++){
                            
                            if (pecaEscolhida == torre1[i]){
                                estaNaTorre = true;
                            }
                        }
  
                    case 2:
                        for (int i = 0; i < torre2.length; i++){
                            
                            if (pecaEscolhida == torre2[i]){
                                estaNaTorre = true;
                            }
                        }

                    case 3:
                        for (int i = 0; i < torre3.length; i++){
                            
                            if (pecaEscolhida == torre3[i]){
                                estaNaTorre = true;
                            }
                        }

                    default:
                        System.out.println("Peça não encontrada!");
                        break;
                }
                
                if (estaNaTorre == true) {
                    break;
                }
            }

            // verifica se a torre existe
            while (true) {
                
                System.out.println("Escolha o torre que deseja mover a peça:\n1\n2\n3");
                torreDestino = leia.nextInt();

                if (torreDestino > 3 || torreDestino <= 0) {
                    System.out.println("Essa torre não existe!");
                } else{
                    break;
                }
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

    // função que faz a jogada

    // O usuário irá informar a torre em que se encontra a peça e para onde deseja mover
    public static void jogada(int valor, int[] tAtual, int[] tDestino) {
        
        
    }

    // função que verifica se o jogador ganhou
    // public static boolean vitoria(int[] torre) {
        
    // }

}

