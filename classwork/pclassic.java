import java.util.*;
import java.io.*;
public class pclassic {
  public static void main(String[] args) {
    //System.out.println(five(Integer.parseInt(args[0])));
    System.out.println(six(args[0]));
  }
  public static ArrayList<Integer> five(int input){
    ArrayList<Integer> ans = new ArrayList<Integer>();
    for (int i = 0; i<input; i++) {
      for (int j = 0; j<input; j++) {
        if (Math.pow(i,2) + Math.pow(j,2) == Math.pow(input, 2)) {
          ans.add(i);
          ans.add(j);
        }
      }
    }
    return ans;
  }
  public static ArrayList<Integer> six(String filename){
    try {
      File f = new File(filename);
      Scanner s = new Scanner(f);
      ArrayList<Integer> ans = new ArrayList<Integer>();
      ArrayList<Integer> a = new ArrayList<Integer>();
      a.add(s.nextInt());
      a.add(s.nextInt());
      a.add(s.nextInt());
      a.add(s.nextInt());
      ArrayList<Integer> r = new ArrayList<Integer>();
      r.add(s.nextInt());
      r.add(s.nextInt());
      System.out.println(a);
      System.out.println(r);
      for (int i = 0; i<=r.get(0); i++){
        for (int j = 0; j<=r.get(1); j++){
          ArrayList<Integer> x = new ArrayList<Integer>();
          x.add(i);
          x.add(j);
          //System.out.println(x);
          if (matrixY(a, x, r)) {
            ans.add(i);
            ans.add(j);
          }
        }
      }
      if (ans.size() > 0) return ans;
      ans.add(-1);
      ans.add(-1);
      return ans;
    } catch (FileNotFoundException e) {}
      return new ArrayList<Integer>();
  }
  public static boolean matrixY(ArrayList<Integer> a, ArrayList<Integer> x, ArrayList<Integer> r){
    if ((a.get(0) + a.get(2)) * x.get(0) != r.get(0)) return false;
    if ((a.get(1) + a.get(3)) * x.get(1) != r.get(1)) return false;
    return true;
  }
}
