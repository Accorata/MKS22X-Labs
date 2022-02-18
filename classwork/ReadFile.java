import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Arrays;
public class ReadFile {
  public static void main(String args[]) {
    File text = new File("Maze1.txt");
    try {
      System.out.println(Arrays.toString(ReadFileToArr(text)));
    } catch (FileNotFoundException e){
      e.printStackTrace();
    }
  }
  public static int[] ReadFileToArr(File f) throws FileNotFoundException {
    Scanner data = new Scanner(f);
    int[] dimensions = new int[2];
    while(data.hasNextLine()){
      dimensions[0] = data.nextLine().length();
      dimensions[1]++;
    }
    return dimensions;
  }
}
