public class Driver {
  public static void main (String[] args){
    int n = Integer.parseInt(args[0]);
    QueenBoard a = new QueenBoard(n);
    //a.solve();
    System.out.println(a.countSolutions());
    System.out.println(a);
  }
}
