import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Silver {
  public static void main(String args[]) {
    try {
      File f = new File(args[0]);
      Scanner data = new Scanner(f);
      int spaceX = data.nextInt();
      int spaceY = data.nextInt();
      char[][] space = new char[spaceX][spaceY];
      int time = data.nextInt();
      for (int i = 0; i<spaceX; i++) {
        for (int j = 0; j<spaceY; j++) {
          space[i][j] = data.nextChar();
        }
      }
      int[][] ways = generateWays(space, data.nextInt(), data.nextInt(), time, new int[spaceX][spaceY]);
    } catch (FileNotFoundException e){
      e.printStackTrace();
    }
  }
  public static int[][] generateWays (char[][] space, int row, int col, int time, int[][] ans){
    if (time == 0) return ans;
  }
}
