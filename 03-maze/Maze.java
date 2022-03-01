import java.util.*;
import java.io.*;
public class Maze{
  private char[][]maze;
  private boolean animate;//false by default
  private int startRow,startCol;

  public Maze(String filename) throws FileNotFoundException{
    animate = false;
    // try {
    maze = ReadFile.getValuesFromFile(filename);
    // } catch (FileNotFoundException e){
    //   e.printStackTrace();
    //   System.exit(1);
    // }
  }
  private void wait(int millis){
    try {
      Thread.sleep(millis);
    } catch (InterruptedException e) {
    }
  }
  public void setAnimate(boolean b){
    animate = b;
  }
  public static void clearTerminal(){
    System.out.println("\033[2J");
  }
  public static void gotoTop(){
    System.out.println("\033[1;1H");
  }
  public String toString(){
    String ans = "";
    for(int i = 0; i<maze.length; i++){
      for(int j = 0; j<maze[0].length; j++){
        ans+=maze[i][j];
      }
      if (i != maze.length-1) ans += "\n";
    }
    return ans;
  }
  public int solve(){
    if(animate){
      clearTerminal();
    }
              //start solving at the location of the s.
    return solve(1,7);
  }
  private int solve(int row, int col){
    if(animate){
      gotoTop();
      System.out.println(this);
      wait(50);
    }

    if (maze[row][col] != ' ') return -1;
    maze[row][col] = '@';

    int ans = solve[row-1][col];
    if (ans > -1) return ans;
    ans = solve[row][col-1];
    if (ans > -1) return ans;
    ans = solve[row+1][col];
    if (ans > -1) return ans;
    ans = solve[row][col+1];
    if (ans > -1) return ans;

    if (maze[row][col] == 'E') {
      int count = 0;
      for(int i = 0; i<maze.length; i++){
        for(int j = 0; j<maze[0].length; j++){
          if (maze[row][col] == '@') count++;
        }
      }
      return count;
    }

    maze[row][col] = '.';
    return -1;
  }
}
