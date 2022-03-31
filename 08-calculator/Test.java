public class Test {
  public static void main(String[] args) {
    // System.out.println(Calculator.eval("11 3 - 4 + 2.5 *")); //30.0
    // System.out.println(Calculator.eval("10 2.0 +")); //12.0
    // System.out.println(Calculator.eval("8 2 + 99 9 - * 2 + 9 -")); //893.0
    // System.out.println(Calculator.eval("1 2 3 4 5 + * - -")); //26.0
    //System.out.println(Calculator.eval("1 *")); //26.0
    int i = 0;
    while (i < 20) {
      String calc = generateCalc();
      try {
        System.out.println(Calculator.eval(calc));
        System.out.println(calc);
        i++;
      } catch (IllegalArgumentException e){}
    }
  }
  public static String generateCalc (){
    String ans = "";
    int length = (int)(Math.random()*10)+1;
    for (int i = 0; i<length; i++) {
      if (Math.random() < 0.3) {
        double rand = Math.random();
        if (rand < 0.2) {
          ans += "+ ";
        } else if (rand < 0.4) {
          ans += "- ";
        } else if (rand < 0.6) {
          ans += "* ";
        } else if (rand < 0.8) {
          ans += "/ ";
        } else {
          ans += "% ";
        }
      } else {
        ans += (int)(Math.random()*40) + " ";
      }
    }
    return ans;
  }
}
