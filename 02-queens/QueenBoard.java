public class QueenBoard {
  private int[][]board;
  private boolean animated = false;
  private int delay = 1000;

  public void setAnimate(boolean newValue){
    animated = newValue;
  }
  public void setDelay(int newValue){
    delay = newValue;
  }
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
  public boolean solve(){
    for (int i = 0; i<board.length; i++){
      for (int j = 0; j<board.length; j++){
        if (board[i][j] != 0) throws IllegalStateException;
      }
    }
    return solve(0);
  }
  public boolean solve(int r){
    if (r >= board.length) return true;
    for (int c = 0; c<board.length; c++){
      if (addQueen(r,c)){
        if(animated){
          System.out.println(Text.go(1,1));
          System.out.println(this);//can change this to your debug print as well
          Text.wait(delay);//change the delay 1000 = 1 second
        }
        if(solve(r+1)) return true;
        removeQueen(r,c);
        if(animated){
          System.out.println(Text.go(1,1));
          System.out.println(this);//can change this to your debug print as well
          Text.wait(delay);//change the delay 1000 = 1 second
        }
      }
    }
    return false;
  }
  public int countSolutions(){
    return countSolutions(0,0);
  }
  public int countSolutions(int r, int count){
    if (r >= board.length) return count+1;
    for (int c = 0; c<board.length; c++){
      if (addQueen(r,c)){
        count += countSolutions(r+1, 0);
        removeQueen(r,c);
      }
    }
    return count;
  }
}
