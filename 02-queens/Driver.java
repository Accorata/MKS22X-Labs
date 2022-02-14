public class Driver {
  public static void main (String[] args){
    QueenBoard a = new QueenBoard(2);
    System.out.println(a.toStringDebug());
    System.out.println(a);
    System.out.println(a.solve());
  }
}
