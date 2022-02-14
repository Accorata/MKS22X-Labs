public class QueenBoard {
  private int[][]board;

  private boolean addQueen(int r, int c){
    if (board[r][c] != 0) return false;
    board[r][c] = -1;
    for (int i = 1; i<board.length-r; i++){
      if (c-i>=0) board[r+i][c-i] += 1;
      board[r+i][c] += 1;
      if (c+i<board.length) board[r+i][c+i] += 1;
    }
    return true;
  }
  private void removeQueen(int r, int c){
    board[r][c] = 0;
    for (int i = 1; i<board.length-r; i++){
      if (c-i>=0) board[r+i][c-i] -= 1;
      board[r+i][c] -= 1;
      if (c+i<board.length) board[r+i][c+i] -= 1;
    }
  }
  public QueenBoard(int size){
    board = new int [size][size];
    //addQueen(0,size-1);
    //addQueen(size-1,0);
    //addQueen(2,3);
    //removeQueen(0,0);
    //removeQueen(0,0);
    //removeQueen(2,3);
  }
  public String toString(){
    String ans = "";
    for (int i = 0; i<board.length; i++){
      for (int j = 0; j<board.length; j++){
        if (board[i][j] == -1) ans+="Q";
        else ans+="_";
        if (j != board.length-1) ans+=" ";
      }
      if (i != board.length-1) ans += "\n";
    }
    return ans;
  }
  public String toStringDebug(){
    String ans = "";
    for (int i = 0; i<board.length; i++){
      for (int j = 0; j<board.length; j++){
        ans += board[i][j]+" ";
      }
      ans += "\n";
    }
    return ans;
  }
  //public boolean solve(){} //note: wrapper method
  //public int countSolutions(){} //note: wrapper method
}
