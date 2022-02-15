public class Driver {
  public static void main (String[] args){
    int n = Integer.parseInt(args[0]);
    QueenBoard a = new QueenBoard(n);
    System.out.println(a.toStringDebug());
    System.out.println(a);
    System.out.println(a.solve());
  }
}
