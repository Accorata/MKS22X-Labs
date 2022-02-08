public class Recursion {
  public static void main(String[] args){
    //int n = Integer.parseInt(args[0]);
    System.out.println(partialSum(new int[]{5,7,2,3,0},2));
    //printAllWords(n);
    //printNoDoubleLetterWords(3, new char[]{'a','z','f'});
  }
  public static void printAllWords(int length){
    printAllWords(length,"");
  }
  public static void printAllWords(int length,String word){
    if (word.length() >= length){
      System.out.println(word);
    } else {
      for (char c = 'a'; c<='e'; c++){
        printAllWords(length, word+c);
      }
    }
  }
  public static void printNoDoubleLetterWords(int length,char[] letters){
    printNoDoubleLetterWords(length,"",letters);
  }
  public static void printNoDoubleLetterWords(int length,String word,char[]letters){
    if (word.length() >= length){
      System.out.println(word);
    } else {
      for (int i = 0; i<letters.length; i++){
        if (word.length() == 0 || word.lastIndexOf(letters[i]) != word.length()-1){
          printNoDoubleLetterWords(length, word+letters[i], letters);
        }
      }
    }
  }
  public static String reverse(String s){
    if (s.length() <= 1) return s;
    return reverse(s.substring(1))+s.charAt(0);
  }
  public static long countNoDoubleLetterWords(int length,String word){
    long count = 0;
    if (word.length() >= length){
      count = 1;
    } else {
      for (char c = 'a'; c<='z'; c++){
        if (word.length() == 0 || word.lastIndexOf(c) != word.length()-1){
          count += countNoDoubleLetterWords(length, word+c);
        }
      }
    }
    return count;
  }
  public static double sqrt(double n) {
    if (n == 0) return 0;
    return sqrt(n, 1);
  }
  public static double sqrt(double n, double guess) {
    if (guess*guess < n*1.00001 && guess*guess > n*0.99999) return guess;
    return sqrt(n, ( n / guess + guess) / 2);
  }
  public static int fibIter(int n, int f1, int f2){
    if (n == 0) return f2;
    if (n == 1) return f1;
    return fibIter(n-1, f1+f2, f1);
  }
  public static boolean partialSum(int[] ary, int target){
    return partialSum(ary, target, 0, 0);
  }
  public static boolean partialSum(int[] ary, int target, int sum, int index){
    if (sum  == target) return true;
    if (index >= ary.length) return false;
    return partialSum(ary, target, sum+ary[index], index+1) || partialSum(ary, target, sum, index+1);
  }
  public static int sumArr(int[] ary, int[] excluded){
    int sum = 0;
    for (int i = 0; i<ary.length; i++) sum += ary[i];
    for (int i = 0; i<excluded.length; i++) sum -= excluded[i];
    return sum;
  }
}
