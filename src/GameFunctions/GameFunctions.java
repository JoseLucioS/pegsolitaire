package GameFunctions;

public class GameFunctions {
    //public String Table[][] = new String[7][7];

    //Inicializa o tabuleiro
    public void initializeTable(String Table[][]){
        for (int i = 0; i < 7; i++){
            for (int j = 0; j < 7; j++) {
                Table[i][j] = "1";
            }
        }
        Table[0][0] = " ";
        Table[0][1] = " ";
        Table[0][5] = " ";
        Table[0][6] = " ";

        Table[1][0] = " ";
        Table[1][1] = " ";
        Table[1][5] = " ";
        Table[1][6] = " ";

        Table[5][0] = " ";
        Table[5][1] = " ";
        Table[5][5] = " ";
        Table[5][6] = " ";

        Table[6][0] = " ";
        Table[6][1] = " ";
        Table[6][5] = " ";
        Table[6][6] = " ";

        Table[3][3] = "0";
    }

    //desenha o tabuleiro no console
    public void drawTable(String Table[][]){
        for (int i = 0; i < 7; i++){
            for (int j = 0; j < 7; j++) {
                System.out.print(Table[i][j] + " ");
            }
            System.out.println();
        }
    }

    //TODO funcao para mover as peças
    public void movePiece(int row, int column, char direction, String table[][]){
        //os pinos das colunas 0 e 1 não podem ir para a esquerda
        //os pinos das colunas 5 e 6 não podem ir para a direita
        //os pinos das linhas 0 e 1 não podem subir
        //os pinos das linhas 5 e 6 não podem descer
        if(direction == 'a' && column >= 2){ //para a esquerda
            if(table[row][column-2] == "0" && table[row][column-1] == "1"){
                table[row][column] = "0";
                table[row][column-1] = "0";
                table[row][column-2] = "1";
            } else {
                System.out.println("Movimento inválido!");
            }
        } else if(direction == 'd' && column <= 4){ //para a direita
            if(table[row][column+2] == "0" && table[row][column+1] == "1"){
                table[row][column] = "0";
                table[row][column+1] = "0";
                table[row][column+2] = "1";
            } else {
                System.out.println("Movimento inválido!");
            }
        } else if(direction == 'w' && row >=2){//para cima
            if(table[row-2][column] == "0" && table[row-1][column] == "1"){
                table[row][column] = "0";
                table[row-1][column] = "0";
                table[row-2][column] = "1";
            } else {
                System.out.println("Movimento inválido!");
            }
        } else if (direction == 's' && row <=4){//para baixo
            if(table[row+2][column] == "0" && table[row+1][column] == "1"){
                table[row][column] = "0";
                table[row+1][column] = "0";
                table[row+2][column] = "1";
            } else {
                System.out.println("Movimento inválido!");
            }
        } else {
            System.out.println("Movimento inválido!");
        }
    }

    //TODO funcao de gameover
}
