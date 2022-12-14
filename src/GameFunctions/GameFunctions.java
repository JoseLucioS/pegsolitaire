package GameFunctions;

public class GameFunctions {

    //Inicializa o tabuleiro
    public void initializeTable(String[][] board){
        for (int i = 0; i < 7; i++){
            for (int j = 0; j < 7; j++) {
                board[i][j] = "1";
            }
        }
        board[0][0] = " ";
        board[0][1] = " ";
        board[0][5] = " ";
        board[0][6] = " ";

        board[1][0] = " ";
        board[1][1] = " ";
        board[1][5] = " ";
        board[1][6] = " ";

        board[5][0] = " ";
        board[5][1] = " ";
        board[5][5] = " ";
        board[5][6] = " ";

        board[6][0] = " ";
        board[6][1] = " ";
        board[6][5] = " ";
        board[6][6] = " ";

        board[3][3] = "0";
    }

    //desenha o tabuleiro no console
    public void drawTable(String[][] board){
        for (int i = 0; i < 7; i++){
            for (int j = 0; j < 7; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void movePiece(int row, int column, char direction, String[][] board){
        //os pinos das colunas 0 e 1 não podem ir para a esquerda
        //os pinos das colunas 5 e 6 não podem ir para a direita
        //os pinos das linhas 0 e 1 não podem subir
        //os pinos das linhas 5 e 6 não podem descer
        if(direction == 'a' && column >= 2){ //para a esquerda
            if(board[row][column-2].equals("0") && board[row][column-1].equals("1")){
                board[row][column] = "0";
                board[row][column-1] = "0";
                board[row][column-2] = "1";
            } else {
                System.out.println("Movimento inválido!");
            }
        } else if(direction == 'd' && column <= 4){ //para a direita
            if(board[row][column+2].equals("0") && board[row][column+1].equals("1")){
                board[row][column] = "0";
                board[row][column+1] = "0";
                board[row][column+2] = "1";
            } else {
                System.out.println("Movimento inválido!");
            }
        } else if(direction == 'w' && row >=2){//para cima
            if(board[row-2][column].equals("0") && board[row-1][column].equals("1")){
                board[row][column] = "0";
                board[row-1][column] = "0";
                board[row-2][column] = "1";
            } else {
                System.out.println("Movimento inválido!");
            }
        } else if (direction == 's' && row <=4){//para baixo
            if(board[row+2][column].equals("0") && board[row+1][column].equals("1")){
                board[row][column] = "0";
                board[row+1][column] = "0";
                board[row+2][column] = "1";
            } else {
                System.out.println("Movimento inválido!");
            }
        } else {
            System.out.println("Movimento inválido!");
        }
    }

    //verifica se resta somente um pino no tabuleiro. Em caso positivo, o jogador venceu
    public boolean checkWin(String[][] board){
        int pegsRemaining = 0;
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                if(board[i][j].equals("1")){
                    pegsRemaining++;
                }
            }
        }
        return pegsRemaining == 1;
    }

    public boolean checkMoveIsPossible(String[][] board){
        boolean result = false;

        for (int i = 0; i < 7; i++) {
            if(i < 2 || i > 4){
                result = threeRowCheck(i, board); //checando as linhas de 3 colunas
            } else {
                result = sevenRowCheck(i, board); //checando as linhas de 7 colunas
            }
            if(result){
                return true;
            }
        }
        //se após a checagem, não houver movimento possível nas linhas, então testa as colunas para ver se há movimento
        //possível

        //checando as colunas de 3 linhas
        for (int i = 0; i < 7; i++) {
            if(i < 2 || i > 4){
                result = threeColCheck(i, board); //checando as colunas de 3 linhas
            } else {
                result = sevenColCheck(i, board); //checando as colunas de 7 linhas
                if(result){
                    return true;
                }
            }
        }
        return result;
    }

    private boolean threeRowCheck(int row, String[][] board){
        //checando se existe movimento válido nas linhas de 3 colunas
        if(board[row][2].equals("1") && board[row][3].equals("1") && board[row][4].equals("0")){
            return true;
        }
        if(board[row][2].equals("0") && board[row][3].equals("1") && board[row][4].equals("1")){
            return true;
        }
        return false;
    }

    private boolean sevenRowCheck(int row, String[][] board){
        //checando se existe movimento válido nas linhas de 7 colunas
        for (int i = 0; i < 7; i++) {
            if(i == 0){
                if(board[row][0].equals("1") && board[row][1].equals("1") && board[row][2].equals("0")){
                    return true;
                }
            } else if(i == 5 || i == 6){
                if(board[row][6].equals("1") && board[row][5].equals("1") && board[row][4].equals("0")){
                    return true;
                }
            } else {
                if(board[row][i].equals("1") && board[row][i+1].equals("1")){
                    if(board[row][i-1].equals("0") || board[row][i+2].equals("0")){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    private boolean threeColCheck(int col, String[][] board){
        //checando se existe movimento válido nas colunas de 3 linhas
        if(board[2][col].equals("1") && board[3][col].equals("1") && board[4][col].equals("0")){
            return true;
        }
        if(board[2][col].equals("0") && board[3][col].equals("1") && board[4][col].equals("1")){
            return true;
        }
        return false;
    }
    private boolean sevenColCheck(int col, String[][] board){
        //checando se existe movimento válido nas colunas de 7 linhas
        for (int i = 0; i < 7; i++) {
            if(i == 0){
                if(board[0][col].equals("1") && board[1][col].equals("1") && board[2][col].equals("0")){
                    return true;
                }
            } else if(i == 5 || i == 6){
                if(board[6][col].equals("1") && board[5][col].equals("1") && board[4][col].equals("0")){
                    return true;
                }
            } else {
                if(board[i][col].equals("1") && board[i+1][col].equals("1")){
                    if(board[i-1][col].equals("0") || board[i-2][col].equals("0")){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
