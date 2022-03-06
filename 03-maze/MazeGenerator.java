import java.util.*;
public class MazeGenerator {
  public static void generate(char[][]maze, int row, int col){
    if (row != 0 && row != maze.length-1 && col != 0 && col != maze[0].length-1) {
      int count = 0;
      if (maze[row-1][col] == ' ') count++;
      if (maze[row+1][col] == ' ') count++;
      if (maze[row][col-1] == ' ') count++;
      if (maze[row][col+1] == ' ') count++;
      if (count < 2) {
        maze[row][col] = ' ';
        ArrayList<Integer> options = new ArrayList<Integer>();
        Collections.addAll(options, -1,0, 1,0, 0,-1, 0,1);
        for (int i = 0; i<4; i++){
          int r = (int)(Math.random()*options.size()/2);
          generate(maze, row+options.get(r), col+options.get(r+1));
          //generate(maze, row+options.get(r), col+options.get(r));
          options.remove(r);
          options.remove(r);
        }

      }
    }
  }
}
