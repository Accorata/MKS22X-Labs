import java.util.*;
public class pclassic {
  public static void main(String[] args) {
    System.out.println(five(Integer.parseInt(args[0])));
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
}
