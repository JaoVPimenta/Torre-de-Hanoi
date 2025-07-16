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
        int torreEscolhida = 0;

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

            // verifica se a torre existe
            while (true) {
                
                System.out.println("Escolha o torre que deseja mover a peça:\n1\n2\n3");
                torreEscolhida = leia.nextInt();

                if (torreEscolhida > 3 || torreEscolhida <= 0) {
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
    public static void jogada(int valor) {
        
    }

    // função que verifica se o jogador ganhou
    // public static boolean vitoria(int[] torre) {
        
    // }

}
