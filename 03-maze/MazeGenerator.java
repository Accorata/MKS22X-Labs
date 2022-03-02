import java.util.ArrayList;
public class MazeGenerator {
  public static void generate(Maze m, int row, int col){
    if (row != 0 && row != m.rows()-1 && col != 0 && col != m.cols()-1) {
      int count = 0;
      if (m.pos(row-1,col) == ' ') count++;
      if (m.pos(row+1,col) == ' ') count++;
      if (m.pos(row,col-1) == ' ') count++;
      if (m.pos(row,col+1) == ' ') count++;
      if (count < 2) {
        ArrayList<Integer> options = new Arraylist<Integer>[] {
          {
            add([-1,0]);
            add([1,0]);
            add([0,-1]);
            add([0,1]);
          }
        };
        for (int i = 3; i>=0; i--){
          int r = (int)(Math.random()*i);
          generate(m, row+options.get(r)[0], col+options.get(r)[1]);
          options.remove(r);
        }

      }
    }
  }
}
