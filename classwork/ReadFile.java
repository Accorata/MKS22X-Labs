import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Arrays;
public class ReadFile {
  public static void main(String args[]) {
    try {
      File text = new File("Maze1.txt");
      char[][] data = ReadFileToArr(text);
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
  public static char[][] ReadFileToArr(File f) throws FileNotFoundException {
    Scanner data = new Scanner(f);
    int[] dimensions = new int[2];
    while(data.hasNextLine()){
      dimensions[1] = data.nextLine().length();
      dimensions[0]++;
    }
    char[][] ans = new char[dimensions[0]][dimensions[1]];
    data = new Scanner(f);
    String line;
    for (int i = 0; i<dimensions[0]; i++){
      line = data.nextLine();
      for (int j = 0; j<dimensions[1]; j++){
        ans[i][j] = line.charAt(j);
      }
    }
    return ans;
  }
}
