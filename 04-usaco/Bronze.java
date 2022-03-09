import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Bronze {
  public static void main(String args[]) {
    //Scanner data;
    try {
      File f = new File(args[0]);
      Scanner data = new Scanner(f);
      int[][] elevs = new int[data.nextInt()][data.nextInt()];
      int lakeElev = data.nextInt();
      int stomps = data.nextInt();
      for (int i = 0; i<elevs.length; i++) {
        for (int j = 0; j<elevs[0].length; j++) {
          elevs[i][j] = data.nextInt();
        }
      }
      System.out.println(lakeElev);
      System.out.println(stomps);
      for (int i = 0; i<stomps; i++){
        stomp(elevs, data.nextInt(), data.nextInt(), data.nextInt());
      }
    } catch (FileNotFoundException e){
      e.printStackTrace();
    }
  }
  public static void stomp (int[][] elevs, int r, int c, int depth){
    int newDepth = -depth;
    for (int i = r; i<r+2; i++){
      for (int j = c; j<c+2; j++){
        if (elevs[i][j]-depth > newDepth) newDepth = elevs[i][j]-depth;
      }
    }
    for (int i = r; i<r+2; i++){
      for (int j = c; j<c+2; j++){
        if (elevs[i][j] < newDepth) elevs[i][j] = newDepth;
      }
    }
  }
}
