package Main;

import GameFunctions.GameFunctions;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        GameFunctions GF = new GameFunctions();
        String board[][] = new String[7][7];

        int row, column;
        //directions: a=left, w=up, s=down, d=right
        char direction;

        GF.initializeTable(board);


        while(true){
            GF.drawTable(board);

            System.out.println("Selecione a linha:");
            row = input.nextInt();
            System.out.println("Selecione a coluna:");
            column = input.nextInt();
            System.out.println("Selecione a direcao:");
            direction = input.next().toLowerCase().charAt(0);

            //ajustando os índices recebidos
            row--;
            column--;

            GF.movePiece(row, column, direction, board);

            //funcao para checar o fim do jogo, seja por vitoria ou por impossibilidade de continuar
            if(GF.checkWin(board)){
                System.out.println("Vencedor! Parabéns!");
                break;
            } else if(GF.checkLoss(board)){
                System.out.println("Você perdeu! Tente novamente!");
                break;
            }
        }
    }
}
