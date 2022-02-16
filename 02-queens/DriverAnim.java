public class DriverAnim {
  public static void main(String[] args){
      System.out.println(Text.CLEAR_SCREEN);
      System.out.println(Text.HIDE_CURSOR);
      System.out.println(Text.go(1,1));
      int n = Integer.parseInt(args[0]);
      QueenBoard a = new QueenBoard(n);
      System.out.println(a.solve());
      //call your solve
      System.out.println(Text.RESET);
  }
}
