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
      String[][] space = new String[spaceX][spaceY];
      int time = data.nextInt();
      for (int i = 0; i<spaceX; i++) {
        //for (int j = 0; j<spaceY; j++) {
          String ln = data.next();
          //space[i][j] = data.next();
          space[i] = ln.split(" ");
        //}
      }
      long[][] ways = new long[spaceX][spaceY];
      ways[data.nextInt()-1][data.nextInt()-1] = 1;
      ways = generateWays(space, time, ways);
      // System.out.println(data.nextInt());
      // System.out.println(data.nextInt());
      System.out.println(ways[data.nextInt()-1][data.nextInt()-1]);
    } catch (FileNotFoundException e){
      e.printStackTrace();
    }
  }
  public static long[][] generateWays (String[][] space, int time, long[][] ways){
    if (time == 0) return ways;
    long[][] ans = new long[ways.length][ways[0].length];
    for (int i = 0; i<space.length; i++) {
      for (int j = 0; j<space[0].length; j++) {
        if (space[i][j] != "*") {
          if (isLegal(space, i-1, j)) ans[i][j] += ways[i-1][j];
          if (isLegal(space, i+1, j)) ans[i][j] += ways[i+1][j];
          if (isLegal(space, i, j-1)) ans[i][j] += ways[i][j-1];
          if (isLegal(space, i, j+1)) ans[i][j] += ways[i][j+1];
        }
      }
    }
    return generateWays (space, time-1, ans);
  }
  public static boolean isLegal (String[][] space, int r, int c){
    if (r < 0 || r >= space.length) return false;
    if (c < 0 || c >= space[0].length) return false;
    return true;
  }
  // public static String board (long[][] ways) {
  //
  // }
}
