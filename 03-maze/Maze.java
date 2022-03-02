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
    for (int i = 0; i<maze.length; i++){
      for(int j = 0; j<maze[0].length; j++){
        if (maze[i][j] == 'S') return solve(i,j);
      }
    }
    return -1;
  }
  private int solve(int row, int col){
    if (maze[row][col] == 'E') {
      int count = 0;
      for(int i = 0; i<maze.length; i++){
        for(int j = 0; j<maze[0].length; j++){
          if (maze[i][j] == '@') count++;
        }
      }
      return count;
    }

    if (maze[row][col] != ' ' && maze[row][col] != 'S') return -1;
    maze[row][col] = '@';
    if(animate){
      gotoTop();
      System.out.println(this);
      wait(50);
    }

    int ans = solve(row-1,col);
    if (ans > -1) return ans;
    ans = solve(row,col-1);
    if (ans > -1) return ans;
    ans = solve(row+1,col);
    if (ans > -1) return ans;
    ans = solve(row,col+1);
    if (ans > -1) return ans;

    maze[row][col] = '.';
    if(animate){
      gotoTop();
      System.out.println(this);
      wait(50);
    }
    return -1;
  }
}
