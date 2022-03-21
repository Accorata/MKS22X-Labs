import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Silver {
  public static long solve(String filename){
    try {
      File f = new File(filename);
      Scanner data = new Scanner(f);
      int spaceX = data.nextInt();
      int spaceY = data.nextInt();
      long[][] ways = new long[spaceX][spaceY];
      int time = data.nextInt();
      data.nextLine();
      for (int i = 0; i<spaceX; i++) {
        String ln = data.nextLine();
        //System.out.println(ln);
        for (int j = 0; j<ln.length(); j++) {
          if (ln.charAt(j) == '*') ways[i][j] = -1;
        }
      }
      ways[data.nextInt()-1][data.nextInt()-1] = 1;
      //printAry(ways);
      ways = generateWays(spaceX, spaceY, time, ways);
      //printAry(ways);
      System.out.println(ways[data.nextInt()-1][data.nextInt()-1]);
    } catch (FileNotFoundException e){
      System.out.println(-1);
    }
  }
  public static long[][] generateWays (int spaceX, int spaceY, int time, long[][] ways){
    if (time == 0) return ways;
    long[][] ans = new long[ways.length][ways[0].length];
    for (int i = 0; i<spaceX; i++) {
      for (int j = 0; j<spaceY; j++) { //space[0].length
        if (ways[i][j] != -1) {
          if (isLegal(spaceX, spaceY, i-1, j, ways)) ans[i][j] += ways[i-1][j];
          if (isLegal(spaceX, spaceY, i+1, j, ways)) ans[i][j] += ways[i+1][j];
          if (isLegal(spaceX, spaceY, i, j-1, ways)) ans[i][j] += ways[i][j-1];
          if (isLegal(spaceX, spaceY, i, j+1, ways)) ans[i][j] += ways[i][j+1];
        } else {
          ans[i][j] = -1;
        }
      }
    }
    //printAry(ans);
    return generateWays (spaceX, spaceY, time-1, ans);
  }
  public static boolean isLegal (int spaceX, int spaceY, int r, int c, long[][] ways){
    if (r < 0 || r >= spaceX) return false;
    if (c < 0 || c >= spaceY) return false;
    if(ways[r][c] == -1) return false;
    return true;
  }
  public static void printAry (long[][] ary) {
    for (long[] row : ary) {
      for (long i : row) {
        System.out.print(i);
      }
      System.out.println();
    }
  }
}
