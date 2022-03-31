public class Test {
  public static void main(String[] args) {
    System.out.println(Calculator.eval("11 3 - 4 + 2.5 *")); //30.0
    System.out.println(Calculator.eval("10 2.0 +")); //12.0
    System.out.println(Calculator.eval("8 2 + 99 9 - * 2 + 9 -")); //893.0
    System.out.println(Calculator.eval("1 2 3 4 5 + * - -")); //26.0
    System.out.println(Calculator.eval("1 *")); //26.0
  }
}
