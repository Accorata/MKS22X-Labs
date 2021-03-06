import java.util.*;
public class MazeGenerator {
  public static void generate(char[][]maze, int row, int col){
    generateR(maze, row, col);
    int endR = 1;
    if (row <= (maze.length-2)/2) endR = maze.length-2;
    int endC = 1;
    if (col <= (maze[0].length-2)/2) endC = maze[0].length-2;
    maze[row][col] = 'S';
    maze[endR][endC] = 'E';
    if (!solve(maze, row, col)) {
      for (int i = 0; i<maze.length; i++){
        for (int j = 0; j<maze[0].length; j++){
          maze[i][j] = '#';
        }
      }
      generate(maze,row,col);
    }
    for (int i = 0; i<maze.length; i++){
      for (int j = 0; j<maze[0].length; j++){
        if (maze[i][j] == '.' || maze[i][j] == '@') maze[i][j] = ' ';
      }
    }
  }
  public static void generateR(char[][]maze, int row, int col){
    if (row != 0 && row != maze.length-1 && col != 0 && col != maze[0].length-1 && maze[row][col] != ' ') {
      int count = 0;
      if (maze[row-1][col] == ' ') count++;
      if (maze[row+1][col] == ' ') count++;
      if (maze[row][col-1] == ' ') count++;
      if (maze[row][col+1] == ' ') count++;
      if (count < 2) {
        maze[row][col] = ' ';
        // System.out.println(KDriver.arrToStr(maze));
        // wait(50);
        ArrayList<Integer> options = new ArrayList<Integer>();
        Collections.addAll(options, -1,0, 1,0, 0,-1, 0,1);
        for (int i = 0; i<4; i++){
          int r = (int)(Math.random()*options.size()/2);
          generateR(maze, row+options.get(r*2), col+options.get(r*2+1));
          options.remove(r*2);
          options.remove(r*2);
        }
      }
    }
  }
  private static void wait(int millis){
    try {
      Thread.sleep(millis);
    } catch (InterruptedException e) {
    }
  }
  private static boolean solve(char[][] maze, int row, int col){
    if (maze[row][col] == 'E') {
      return true;
    }
    if (maze[row][col] != ' ' && maze[row][col] != 'S') return false;
    if (maze[row][col] != 'S') maze[row][col] = '@';
    boolean ans = solve(maze, row-1,col);
    if (ans) return ans;
    ans = solve(maze, row,col-1);
    if (ans) return ans;
    ans = solve(maze, row+1,col);
    if (ans) return ans;
    ans = solve(maze, row,col+1);
    if (ans) return ans;
    if (maze[row][col] != 'S') maze[row][col] = '.';
    return false;
  }
  //private static int[] pathDist(char[][] maze, int row, int col, int dis){

  //}
}
