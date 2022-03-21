import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Bronze {
  public static long solve(String filename){
    //Scanner data;
    try {
      File f = new File(filename);
      Scanner data = new Scanner(f);
      int[][] elevs = new int[data.nextInt()][data.nextInt()];
      int lakeElev = data.nextInt();
      int stomps = data.nextInt();
      for (int i = 0; i<elevs.length; i++) {
        for (int j = 0; j<elevs[0].length; j++) {
          elevs[i][j] = data.nextInt();
        }
      }
      for (int i = 0; i<stomps; i++){
        //int a  = data.nextInt
        //stomp(elevs, data.nextInt()-1, data.nextInt()-1, data.nextInt());
        stomp(elevs, data.nextInt()-1, data.nextInt()-1, data.nextInt());
      }
      return (lakeAmount(elevs, lakeElev));
    } catch (FileNotFoundException e){
      return -1;
    }
  }
  public static void stomp (int[][] elevs, int r, int c, int depth){
    int newDepth = 0;
    for (int i = r; i<r+3; i++){
      for (int j = c; j<c+3; j++){
        if (elevs[i][j]-depth > newDepth) newDepth = elevs[i][j]-depth;
      }
    }
    for (int i = r; i<r+3; i++){
      for (int j = c; j<c+3; j++){
        if (elevs[i][j] > newDepth) elevs[i][j] = newDepth;
      }
    }
  }
  public static int lakeAmount (int[][] elevs, int lakeElev) {
    int sum = 0;
    for (int i = 0; i<elevs.length; i++){
      for (int j = 0; j<elevs[0].length; j++){
        if (lakeElev-elevs[i][j] > 0) sum+=lakeElev-elevs[i][j];
      }
    }
    return sum*72*72;
  }
}
