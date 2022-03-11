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
      long[][] ways = new long[spaceX][spaceY];
      int time = data.nextInt();
      data.nextLine();
      for (int i = 0; i<spaceX; i++) {
        String[] ln = data.nextLine().split(" ");
        for (int j = 0; j<spaceY; j++) {
          if (ln[j].equals("*")) ways[i][j] = -1;
        }
      }
      ways[data.nextInt()-1][data.nextInt()-1] = 1;
      //printAry(space);
      printAry(ways);
      ways = generateWays(spaceX, spaceY, time, ways);
      // System.out.println(data.nextInt());
      // System.out.println(data.nextInt());
      printAry(ways);
      System.out.println(ways[data.nextInt()-1][data.nextInt()-1]);
    } catch (FileNotFoundException e){
      e.printStackTrace();
    }
  }
  public static long[][] generateWays (int spaceX, int spaceY, int time, long[][] ways){
    if (time == 0) return ways;
    long[][] ans = new long[ways.length][ways[0].length];
    for (int i = 0; i<spaceX; i++) {
      for (int j = 0; j<spaceY; j++) { //space[0].length
        if (ways[i][j] != -1) {
          if (isLegal(spaceX, spaceY, i-1, j)) ans[i][j] += ways[i-1][j];
          if (isLegal(spaceX, spaceY, i+1, j)) ans[i][j] += ways[i+1][j];
          if (isLegal(spaceX, spaceY, i, j-1)) ans[i][j] += ways[i][j-1];
          if (isLegal(spaceX, spaceY, i, j+1)) ans[i][j] += ways[i][j+1];
        }
      }
    }
    printAry(ans);
    return generateWays (spaceX, spaceY, time-1, ans);
  }
  public static boolean isLegal (int spaceX, int spaceY, int r, int c){
    if (r < 0 || r >= spaceX) return false;
    if (c < 0 || c >= spaceY) return false;
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
  public static void printAry (String[][] ary) {
    for (String[] row : ary) {
      for (String i : row) {
        System.out.print(i);
      }
      System.out.println();
    }
  }
}
