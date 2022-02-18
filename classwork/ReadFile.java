import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Arrays;
public class ReadFile {
  public static void main(String args[]) {
    try {
      char[][] data = getValuesFromFile("Maze1.txt");
      for(int i = 0; i<data.length; i++){
        for(int j = 0; j<data[0].length; j++){
          System.out.print(data[i][j]);
        }
        System.out.println();
      }
    } catch (FileNotFoundException e){
      e.printStackTrace();
    }
  }
  public static char[][] getValuesFromFile(String filename) throws FileNotFoundException {
    File f = new File(filename);
    Scanner data = new Scanner(f);
    int[] dimensions = new int[2];
    while(data.hasNextLine()){
      dimensions[1] = data.nextLine().length();
      dimensions[0]++;
    }
    char[][] ans = new char[dimensions[0]][dimensions[1]];
    data = new Scanner(f);
    //String line;
    for (int i = 0; i<dimensions[0]; i++){
      ans[i] = data.nextLine().toCharArray();
      // line = data.nextLine();
      // for (int j = 0; j<dimensions[1]; j++){
      //   ans[i][j] = line.charAt(j);
      // }
    }
    return ans;
  }
}
