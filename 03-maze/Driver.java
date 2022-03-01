import java.io.FileNotFoundException;
public class Driver{
  public static void main(String[]args){
    String filename = args[0];

    try{
      Maze f;
      f = new Maze(filename);
      System.out.println(f);
      f.setAnimate(true);
      System.out.println(f.solve()+" steps");  
    } catch(FileNotFoundException e){
      System.out.println("Invalid filename: "+filename);
    }
  }
}
