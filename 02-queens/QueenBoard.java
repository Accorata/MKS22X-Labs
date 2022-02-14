public class QueenBoard {
  private int[][]board;

  private boolean addQueen(int r, int c){
    if (board[r][c] != 0) return false;
    board[r][c] = -1;
    for (int i = 1; i<board.length-r; i++){
      if (c-i>0) board[r+i][c-i] += 1;
      board[r+i][c] += 1;
      if (c+i<board.length) board[r+i][c+i] += 1;
    }
    return true;
  }

  private void removeQueen(int r, int c){
    board[r][c] = 0;
    for (int i = 1; i<board.length-r; i++){
      if (c-i>0) board[r+i][c-i] -= 1;
      board[r+i][c] -= 1;
      if (c+i<board.length) board[r+i][c+i] -= 1;
    }
    return true;
  }

  public QueenBoard(int size){
    board = new int [size][size];
  } //: initialize a square 2d array of the specified size. All values should be 0
  //public String toString(){} //: see format in the comments below.
  _ _ Q _
          *Q _ _ _
          *_ _ _ Q
          *_ Q _ _
  public String toStringDebug(){
    String ans = "";
    for (int i = 0; i<board.length; i++){
      for (int j = 0; j<board.length; j++){
        ans += board[r][c]+" ";
      }
      ans += "\n";
    }
    return ans;
  }
  //public boolean solve(){} //note: wrapper method
  //public int countSolutions(){} //note: wrapper method
}
