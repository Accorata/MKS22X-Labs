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
      int[][] ways = new int[spaceX][spaceY]);
      ways[data.nextInt()][data.nextInt()] = 1;
      ways = generateWays(space, time, ways)
    } catch (FileNotFoundException e){
      e.printStackTrace();
    }
  }
  public static int[][] generateWays (char[][] space, int time, int[][] ways){
    if (time == 0) return ways;
    int[][] ans = new int[ways.length][ways[0].length];
    for (int i = 0; i<spaceX; i++) {
      for (int j = 0; j<spaceY; j++) {
        if (space.getChar(i,j) != '*') {
          ans += ways[i-1][j];
          ans += ways[i+1][j];
          ans += ways[i][j-1];
          ans += ways[i][j+1];
        }
      }
    }
    return generateWays (space, time-1, ans);
  }
}
