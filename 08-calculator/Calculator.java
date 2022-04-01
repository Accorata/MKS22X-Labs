import java.util.*;
public class Calculator{
  public static double eval(String s){
    Scanner input = new Scanner(s);
    ArrayDeque<Double> stack = new ArrayDeque<Double>();
    while (input.hasNext()) {
      String val = input.next();
      //System.out.println(val);
      if (val.equals("*")) {
        if (stack.size() < 2) throw new IllegalArgumentException("too few operands for operation "+val);
        stack.addLast(stack.removeLast() * stack.removeLast());
      } else if (val.equals("/")) {
        if (stack.size() < 2) throw new IllegalArgumentException("too few operands for operation "+val);
        double last = stack.removeLast();
        stack.addLast(stack.removeLast() / last);
      } else if (val.equals("+")) {
        if (stack.size() < 2) throw new IllegalArgumentException("too few operands for operation "+val);
        stack.addLast(stack.removeLast() + stack.removeLast());
      } else if (val.equals("-")) {
        if (stack.size() < 2) throw new IllegalArgumentException("too few operands for operation "+val);
        double last = stack.removeLast();
        stack.addLast(stack.removeLast() - last);
      } else if (val.equals("%")) {
        if (stack.size() < 2) throw new IllegalArgumentException("too few operands for operation "+val);
        double last = stack.removeLast();
        stack.addLast(stack.removeLast() % last);
      } else {
        stack.addLast(Double.parseDouble(val));
      }
    }
    if (stack.size() < 1) throw new IllegalArgumentException("too few operands");
    if (stack.size() > 1) throw new IllegalArgumentException("too many operands");
    return stack.removeLast();
  }
}
