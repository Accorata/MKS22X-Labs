import java.io.FileNotFoundException;
public class Driver{
  public static void main(String[]args){
    String filename = "maze1.txt";

    try{
      Maze f;
      f = new Maze(filename);
      f.setAnimate(true);
      //System.out.println(f.solve()+" steps");
      System.out.println(f);
    } catch(FileNotFoundException e){
      System.out.println("Invalid filename: "+filename);
    }
  }
}
