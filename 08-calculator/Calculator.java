import java.util.*;
public class Calculator{
      /*Evaluate a postfix expression stored in s.
      *Assume valid postfix notation, of ints doubles and operators separated by spaces.
      *Valid operators are + - / * and % (remainder not modulo)
      *All results are doubles even if the operands are both int.
      *@throws IllegalArgumentException when there are too many or too few operands.
      *        Use the string parameter of your exception to indicate what happened.
      *        Either "too many operands" or "too few operands for operation _" replace _ with +,- etc.
      */
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
    if (stack.size() > 1) throw new IllegalArgumentException("too many operands");
    return stack.removeLast();
  }
}
