import java.util.*;
import java.io.*;
public class Maze{
  private char[][]maze;
  private boolean animate;//false by default
  private int startRow,startCol;

  public Maze(String filename) throws FileNotFoundException{
    animate = false;
    try {
      maze = ReadFile.getValuesFromFile(filename);
    } catch (FileNotFoundException e){
      e.printStackTrace();
      System.exit(1);
    }
  }

}
